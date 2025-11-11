package hslu.oop.sw09;

import java.util.Scanner;

public class Main {

    //c) NumberFormatException erbt von IllegalArgumentException und diese von RuntimeException
    // => unchecked Exception
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            try {
                float value = Float.valueOf(input);
                System.out.println("Temperatur: " + value);
            } catch (NumberFormatException e) {
                if (!input.equals("exit")) {
                    System.out.println("Bitte geben Sie eine gültige Zahl ein!");
                }
            }
        } while (!"exit".equals(input));
        System.out.println("Programm beendet.");
    }
}