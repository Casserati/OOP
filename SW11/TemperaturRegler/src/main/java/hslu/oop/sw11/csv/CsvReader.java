package hslu.oop.sw11.csv;

import hslu.oop.sw11.Temperature;
import hslu.oop.sw11.csv.data.Converter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private static final Logger LOGGER = LogManager.getLogger(CsvReader.class);
    private static final List<Measurement> measurements = new ArrayList<>();

    public static List<Measurement> readCsvFile(File csv) {

        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split the line by semicolon
                String[] fields = line.split(";");

                measurements.add(new Measurement(Converter.convertToCelsiusTemperature(fields[2]),
                        Converter.convertToInt(fields[3]), Converter.convertToLocalDateTime(fields[1])));
            }
            return measurements;

        } catch (IOException ex) {
            LOGGER.error("Error occurred trying to read file");
            LOGGER.error(ex.getMessage());
            return null;
        } catch (DateTimeParseException ex) {
            LOGGER.error("Error trying to parse date from file");
            LOGGER.error(ex.getMessage());
            return null;
        }
    }
}
