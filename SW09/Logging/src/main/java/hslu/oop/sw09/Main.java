package hslu.oop.sw09;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.valueOf(input);
                LOGGER.info("inserted value: " + value);
                System.out.println("Temperatur: " + value);
            } catch (NumberFormatException e) {
                LOGGER.warn("Exception was caught!");
                if (!input.equals("exit")) {
                    LOGGER.error("Catch-block was called without the input 'exit'.");
                    System.out.println("Bitte geben Sie eine gültige Zahl ein!");
                }
                LOGGER.debug("Catch-block was called with the input 'exit', program is going to end now.");
            }
        } while (!"exit".equals(input));
        System.out.println("Programm beendet.");
    }
}