package hslu.oop.sw11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        // Relative path from project root
        Path path = Paths.get("src/main/resources/file.txt");

        writeIntoFile(path.toFile());

        readFile(path.toFile());
    }

    private static void writeIntoFile(File file) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {

            for (int i = 0; i <= 100; i++) {
                dos.writeInt(i);
            }
            LOGGER.info("Integer written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile(File file) {
        if (file.exists()) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {

                // Example reads (depends on your data format!)
                int number = dis.readInt();        // read 4-byte integer
                double value = dis.readDouble();   // read 8-byte double
                boolean flag = dis.readBoolean();  // read boolean
                byte byteValue = dis.readByte();       // read byte
                float floatValue = dis.readFloat();       // read byte

                LOGGER.info("number = {}", number);
                LOGGER.info("value  = {}", value);
                LOGGER.info("flag   = {}", flag);
                LOGGER.info("byte   = {}", byteValue);
                LOGGER.info("float   = {}", floatValue);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}