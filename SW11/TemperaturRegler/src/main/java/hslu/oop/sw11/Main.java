package hslu.oop.sw11;

import hslu.oop.sw11.collections.TemperatureVerlaufImpl;
import hslu.oop.sw11.csv.Analyzer;
import hslu.oop.sw11.csv.CsvReader;
import hslu.oop.sw11.csv.Measurement;
import hslu.oop.sw11.event.TemperatureEventHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final Scanner scanner = new Scanner(System.in);
    private static TemperatureEventHandler handler = new TemperatureEventHandler();

    private static final CsvReader csvReader = new CsvReader();

    private static File file = Paths.get("src/main/resources/file.txt").toFile();
    private static File csv = Paths.get("src/main/resources/csv.csv").toFile();


    public static void main(String[] args) {
        TemperatureVerlaufImpl temperatureVerlauf = handler.getTemperatureVerlauf();
        String input;
        do {
            System.out.println("Temperature in Celsius (or 'exit' to exit):");
            input = scanner.next();
            if (!input.equals("exit")) {
                try {
                    Temperature created = Temperature.createFromCelsius(Float.parseFloat(input));
                    LOGGER.info("Temperature created: {}", created);
                    temperatureVerlauf.add(created);
                    LOGGER.info("Temperature was successfully inserted into the list! Size now: {}", temperatureVerlauf.getCount());
                } catch (IllegalArgumentException ex) {
                    LOGGER.error(ex.getMessage());
                }
            } else {
                List<Measurement> measurements = csvReader.readCsvFile(csv);
                Analyzer.query(measurements, LocalDateTime.of(2025, 1, 27, 0, 0), LocalDateTime.of(2025, 1, 28, 0, 0));
                writeIntoFile(temperatureVerlauf);
                readFile(temperatureVerlauf);
                LOGGER.info("Amount Temperatures were: {}", temperatureVerlauf.getCount());
                LOGGER.info("Minimal Temperature was: {}", temperatureVerlauf.getMinValue());
                LOGGER.info("Maximal Temperature was: {}", temperatureVerlauf.getMaxValue());
                LOGGER.info("Average Temperature was: {}", temperatureVerlauf.getAverage());
            }
        } while (!input.equals("exit"));
    }

    private static void writeIntoFile(TemperatureVerlaufImpl temperatureVerlauf) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(temperatureVerlauf.getCount());
            for (int i = 0; i < temperatureVerlauf.getCount(); i++) {
                dos.writeFloat(temperatureVerlauf.get(i).getTemperatureInCelsius());
            }
            LOGGER.info("Integer written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(TemperatureVerlaufImpl temperatureVerlauf) {
        if (file.exists()) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {

                // Example reads (depends on your data format!)
                int number = dis.readInt();
                LOGGER.info("Number of Temps = " + number);

                for (int i = 0; i < temperatureVerlauf.getCount(); i++) {
                    Float temperatureInCelsius = dis.readFloat();
                    LOGGER.info("temperatureInCelsius nr. {}: {}", i + 1, temperatureInCelsius);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}