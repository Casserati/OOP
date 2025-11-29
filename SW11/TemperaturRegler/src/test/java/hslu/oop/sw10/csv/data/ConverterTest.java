package hslu.oop.sw10.csv.data;

import hslu.oop.sw10.Temperature;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeParseException;

import static hslu.oop.sw10.Temperature.fromKelvinToCelsius;
import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {

    @Test
    void test_integerParse_valid() {
        assertEquals(42, Converter.convertToInt("42"));
        assertEquals(-10, Converter.convertToInt("-10"));
    }

    @Test
    void test_integerParse_throwsException() {
        assertThrows(NumberFormatException.class, () -> {
            Converter.convertToCelsiusTemperature("abc");
        });
    }

    @Test
    void test_temperatureParse_valid() {
        Temperature temperature = Converter.convertToCelsiusTemperature("50");
        assertEquals(50.0f, temperature.getTemperatureInCelsius(), 0.1f);
    }

    @Test
    void test_temperatureParseOverMax_throwsException() {
        assertTrue(
                assertThrows(IllegalArgumentException.class, () -> {
                    Converter.convertToCelsiusTemperature(String.valueOf(fromKelvinToCelsius(Temperature.MAX_KELVIN) + 1));
                }).getMessage().contains("Die eingegebene Temperatur in Celsius entspricht nicht einer gültigen Temperatur."));
    }

    @Test
    void test_temperatureParseUnderMin_throwsException() {
        assertTrue(
                assertThrows(IllegalArgumentException.class, () -> {
                    Converter.convertToCelsiusTemperature(String.valueOf(fromKelvinToCelsius(Temperature.MIN_KELVIN) - 1));
                }).getMessage().contains("Die eingegebene Temperatur in Celsius entspricht nicht einer gültigen Temperatur."));
    }


    @Test
    void test_localDateTimeParse_valid() {
        LocalDateTime localDateTime = Converter.convertToLocalDateTime("\"2025/02/09 10:11:12\"");
        assertEquals(2025, localDateTime.getYear());
        assertEquals(2, localDateTime.getMonthValue());
        assertEquals(Month.FEBRUARY, localDateTime.getMonth());
        assertEquals(9, localDateTime.getDayOfMonth());
        assertEquals(10, localDateTime.getHour());
        assertEquals(11, localDateTime.getMinute());
        assertEquals(12, localDateTime.getSecond());
    }

    @Test
    void test_localDateTimeParse_throwsException() {
        assertThrows(DateTimeParseException.class, () -> {
            Converter.convertToLocalDateTime("\"2025/2/9 10:11:12\"");
        });
    }

    @Test
    void test_fromLocalDateTimeParse_valid() {
        String localeDateTime = Converter.convertFromLocaleDateTime(LocalDateTime.of(2024, 1, 8, 7, 6, 5));
        assertEquals("08.01.2024 07:06:05", localeDateTime);
    }

    @Test
    void test_fromLocalDateTimeParse_throwsException() {
        assertThrows(DateTimeException.class, () -> {
            Converter.convertFromLocaleDateTime(LocalDateTime.MIN.minusDays(10));
        });
    }
}