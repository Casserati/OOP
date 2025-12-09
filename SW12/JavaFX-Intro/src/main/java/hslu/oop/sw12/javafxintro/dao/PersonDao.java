package hslu.oop.sw12.javafxintro.dao;

import hslu.oop.sw12.javafxintro.dto.PersonDto;
import hslu.oop.sw12.javafxintro.entity.PersonEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PersonDao {

    private EntityManagerFactory emf;
    private PersonMapper mapper;

    public PersonDao(EntityManagerFactory emf) {
        this.emf = emf;
        this.mapper = new PersonMapper();
    }

    public void createPerson(PersonDto person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(mapper.fromDtoToEntity(person));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public PersonEntity updatePerson(Long id, PersonDto person) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            PersonEntity measurementToBeUpdated = em.find(PersonEntity.class, id);
            updatePerson(measurementToBeUpdated, mapper.fromDtoToEntity(person));
            em.getTransaction().commit();
            return measurementToBeUpdated;
        } finally {
            em.close();
        }
    }

    public void deletePerson(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            PersonEntity measurementToBeDeleted = em.find(PersonEntity.class, id);
            em.remove(measurementToBeDeleted);
        } finally {
            em.close();
        }
    }

    public PersonDto findPersonById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            return mapper.fromEntityToDto(em.find(PersonEntity.class, id));
        } finally {
            em.close();
        }
    }

    private void updatePerson(PersonEntity personToBeUpdated, PersonEntity personEntity) {
        personToBeUpdated.setId(personEntity.getId());
        personToBeUpdated.setFirstname(personEntity.getFirstname());
        personToBeUpdated.setLastname(personEntity.getLastname());
        personToBeUpdated.setBirthdate(personEntity.getBirthdate());
    }

    public static class PersonMapper {
        PersonEntity fromDtoToEntity(PersonDto source) {
            if (source == null) {
                return null;
            }

            PersonEntity PersonEntity = new PersonEntity();

            PersonEntity.setId(source.getId());
            PersonEntity.setFirstname(source.getFirstname());
            PersonEntity.setLastname(source.getLastname());
            PersonEntity.setBirthdate(source.getBirthdate());

            return PersonEntity;
        }

        PersonDto fromEntityToDto(PersonEntity destination) {
            if (destination == null) {
                return null;
            }

            Long id = 0L;
            String firstname = "";
            String lastname = "";
            LocalDate birthDate = null;

            if (destination.getId() != null) {
                id = destination.getId();
            }
            if (destination.getFirstname() != null) {
                firstname = destination.getFirstname();
            }
            if (destination.getLastname() != null) {
                lastname = destination.getLastname();
            }
            birthDate = destination.getBirthdate();

            return new PersonDto(id, firstname, lastname, birthDate);
        }
    }
}
