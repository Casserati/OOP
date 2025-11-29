package hslu.oop.sw10.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvReader {

    public void readCsvFile(File csv) {
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {
            String line;

            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] fields = line.split(";");

                System.out.print("Time Stamp: " + fields[1]);
                System.out.print("Celsius Value : " + fields[2]);
                System.out.print("Luftfeuchtigkeit: " + fields[3]);
                System.out.println();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
