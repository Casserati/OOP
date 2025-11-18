package hslu.oop.sw10;

import hslu.oop.sw10.collections.TemperatureVerlaufImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static TemperatureVerlaufImpl temperatureVerlauf = new TemperatureVerlaufImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Temperature in Celsius (or 'exit' to exit):");
        String input = scanner.next();

        if (!input.equals("exit")) {
            try {
                Temperature created = Temperature.createFromCelsius(Float.parseFloat(input));
                LOGGER.info("Temperature created: {}", created);
                temperatureVerlauf.add(created);
                LOGGER.info("Temperature was successfully inserted into the list! Size now: {}", temperatureVerlauf.getCount());
            } catch (IllegalArgumentException ex) {
                LOGGER.error(ex.getMessage());
            }
        }
    }
}