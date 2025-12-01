import controller.MeasurementDao;
import dto.MeasurementDto;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class Main {

    private static MeasurementDao measurementDao = new MeasurementDao(Persistence.createEntityManagerFactory("default"));

    public static void main(String[] args) {
        MeasurementDto measurement = new MeasurementDto(10000L, 100, 10, LocalDateTime.now());

        measurementDao.createMeasurement(measurement);
    }
}
