package hslu.oop.sw11.csv;

import hslu.oop.sw11.Temperature;
import hslu.oop.sw11.csv.data.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class Analyzer {

    private static final Logger LOGGER = LogManager.getLogger(Analyzer.class);

    public static void query(final List<Measurement> measurements, final LocalDateTime start, final LocalDateTime end) {

        Measurement maxTemp = new Measurement(Temperature.createFromKelvin(Temperature.MIN_KELVIN), Integer.MIN_VALUE, LocalDateTime.MIN);
        Measurement minTemp = new Measurement(Temperature.createFromKelvin(Temperature.MAX_KELVIN), Integer.MAX_VALUE, LocalDateTime.MAX);
        float average = 0.0f;

        for (Measurement measurement : measurements) {
            if (!measurement.getTimeOfMeasurement().isBefore(start) && !measurement.getTimeOfMeasurement().isAfter(end)) {
                maxTemp = getMaxMeasurement(maxTemp, measurement);
                minTemp = getMinMeasurement(minTemp, measurement);
                average += measurement.getTemperature().getTemperatureInCelsius();
            }
        }

        Temperature averageTemp = Temperature.createFromCelsius(average / measurements.size());

        LOGGER.info("66cef3 Max Temp between {} and {} was {}, recorded on {} with humidity value of {}", Converter.convertFromLocaleDateTime(start), Converter.convertFromLocaleDateTime(end), maxTemp.getTemperature().getTemperatureInCelsius(), Converter.convertFromLocaleDateTime(maxTemp.getTimeOfMeasurement()), maxTemp.getHumidity());
        LOGGER.info("1b12ea Min Temp between {} and {} was {}, recorded on {} with humidity value of {}", Converter.convertFromLocaleDateTime(start), Converter.convertFromLocaleDateTime(end), minTemp.getTemperature().getTemperatureInCelsius(), Converter.convertFromLocaleDateTime(minTemp.getTimeOfMeasurement()),  maxTemp.getHumidity());
        LOGGER.info("83c2c5 Average Temp between {} and {} was {}", start, end, averageTemp.getTemperatureInCelsius());
    }

    private static Measurement getMaxMeasurement(Measurement firstMeasurement, Measurement secondMeasurement) {
        return firstMeasurement.getTemperature().getTemperatureInCelsius() > secondMeasurement.getTemperature().getTemperatureInCelsius() ?
                firstMeasurement : secondMeasurement;
    }

    private static Measurement getMinMeasurement(Measurement firstMeasurement, Measurement secondMeasurement) {
        return firstMeasurement.getTemperature().getTemperatureInCelsius() > secondMeasurement.getTemperature().getTemperatureInCelsius() ?
                secondMeasurement: firstMeasurement;
    }
}
