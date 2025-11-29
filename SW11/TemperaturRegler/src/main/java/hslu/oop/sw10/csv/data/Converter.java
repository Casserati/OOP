package hslu.oop.sw10.csv.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Converter {

    public static float convertToFloat(String value) {
        return Float.parseFloat(value);
    }

    public static int convertToInt(String value) {
        return Integer.parseInt(value);
    }

    public static LocalDateTime convertToLocalDateTime(String value) {
        return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
    }
}
