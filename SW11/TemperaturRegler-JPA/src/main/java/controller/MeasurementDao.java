package controller;

import dto.MeasurementDto;
import entity.MeasurementEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class MeasurementDao {

    private EntityManagerFactory emf;
    private MeasurementMapper mapper;

    public MeasurementDao(EntityManagerFactory emf) {
        this.emf = emf;
        this.mapper = new MeasurementMapper();
    }

    public void createMeasurement(MeasurementDto measurement) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mapper.fromDtoToEntity(measurement));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public MeasurementEntity updateMeasurement(Long id, MeasurementDto measurement) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MeasurementEntity measurementToBeUpdated = em.find(MeasurementEntity.class, id);
            updateMeasurement(measurementToBeUpdated, mapper.fromDtoToEntity(measurement));
            em.getTransaction().commit();
            return measurementToBeUpdated;
        } finally {
            em.close();
        }
    }

    public void deleteMeasurement(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MeasurementEntity measurementToBeDeleted = em.find(MeasurementEntity.class, id);
            em.remove(measurementToBeDeleted);
        } finally {
            em.close();
        }
    }

    public MeasurementDto findMeasurementById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            return mapper.fromEntityToDto(em.find(MeasurementEntity.class, id));
        } finally {
            em.close();
        }
    }

    public List<MeasurementDto> getMeasurementBetweenLocaleDateTime(LocalDateTime start, LocalDateTime end) {
        EntityManager em = emf.createEntityManager();
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<MeasurementEntity> cq = cb.createQuery(MeasurementEntity.class);
            Root<MeasurementEntity> root = cq.from(MeasurementEntity.class);

            Predicate condition = cb.between(root.get("timeOfMeasurement"), start, end);
            cq.where(condition);

            List<MeasurementEntity> entries = em.createQuery(cq).getResultList();
            return entries.stream().map(mapper::fromEntityToDto).collect(Collectors.toList());
        } finally {
            em.close();
        }
    }

    private void updateMeasurement(MeasurementEntity measurementToBeUpdated, MeasurementEntity measurement) {
        measurementToBeUpdated.setTimeOfMeasurement(measurement.getTimeOfMeasurement());
        measurementToBeUpdated.setTemperature(measurement.getTemperature());
        measurementToBeUpdated.setHumidity(measurement.getHumidity());
    }

    public static class MeasurementMapper {
        MeasurementEntity fromDtoToEntity(MeasurementDto source) {
            if (source == null) {
                return null;
            }

            MeasurementEntity measurementEntity = new MeasurementEntity();

            measurementEntity.setId(source.getId());
            measurementEntity.setHumidity(source.getHumidity());
            measurementEntity.setTimeOfMeasurement(source.getTimeOfMeasurement());
            measurementEntity.setTemperature(source.getTemperature());

            return measurementEntity;
        }

        MeasurementDto fromEntityToDto(MeasurementEntity destination) {
            if (destination == null) {
                return null;
            }

            Long id = 0L;
            float temperature = 0.0f;
            int humidity = 0;
            LocalDateTime timeOfMeasurement = null;

            if (destination.getId() != null) {
                id = destination.getId();
            }
            if (destination.getTemperature() != null) {
                temperature = destination.getTemperature();
            }
            if (destination.getHumidity() != null) {
                humidity = destination.getHumidity();
            }
            timeOfMeasurement = destination.getTimeOfMeasurement();

            return new MeasurementDto(destination.getId(), temperature, humidity, timeOfMeasurement);
        }
    }
}
