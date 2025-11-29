package hslu.oop.sw10.csv;

import hslu.oop.sw10.Temperature;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class MeasurementTest {

    @Test
    void test_creation_valid() {
        Measurement measurement = new Measurement(Temperature.createFromKelvin(500.0f), 50,
                LocalDateTime.of(2000, Month.JANUARY, 1, 15, 14, 13));

        assertEquals(
                Temperature.createFromKelvin(500.0f).getTemperatureInCelsius(),
                measurement.getTemperature().getTemperatureInCelsius());
        assertEquals(50, measurement.getHumidity());
        assertEquals(2000, measurement.getTimeOfMeasurement().getYear());
        assertEquals(Month.JANUARY, measurement.getTimeOfMeasurement().getMonth());
        assertEquals(1, measurement.getTimeOfMeasurement().getDayOfMonth());
        assertEquals(15, measurement.getTimeOfMeasurement().getHour());
        assertEquals(14, measurement.getTimeOfMeasurement().getMinute());
        assertEquals(13, measurement.getTimeOfMeasurement().getSecond());
    }

    @Test
    void test_creation_throwsException() {
        assertTrue(
                assertThrows(IllegalArgumentException.class, () -> {
                    new Measurement(Temperature.createFromKelvin(Temperature.MAX_KELVIN + 1), 50,
                            LocalDateTime.of(2000, Month.JANUARY, 1, 15, 14, 13));
                }).getMessage().contains("Die eingegebene Temperatur in Kelvin entspricht nicht einer gültigen Temperatur."));
    }

}