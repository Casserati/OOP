package hslu.oop.sw11.csv.data;

import hslu.oop.sw11.Temperature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {

    public static Temperature convertToCelsiusTemperature(String value) {
        return Temperature.createFromCelsius(Float.parseFloat(value));
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }

    public static LocalDateTime convertToLocalDateTime(String value) {
        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("\"yyyy/MM/dd HH:mm:ss\""));
    }

    public static String convertFromLocaleDateTime(LocalDateTime value) {
        return value.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
}
