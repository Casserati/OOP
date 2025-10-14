package hslu.oop.sw02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class TemperaturTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final String errorMessage = "Temperatur ist nicht gültig für den gegebenen Wertebereich!\r\n";

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void setToOver1000Kelvin() {
        Temperatur temperatur = new Temperatur(500);

        temperatur.changeTemperature(1000);


        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void initTempOver1000Kelvin() {
        Temperatur temperatur = new Temperatur(1000);

        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void setToUnder0Kelvin() {
        Temperatur temperatur = new Temperatur(500);

        temperatur.changeTemperature(-1000);

        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void initTempUnder0Kelvin() {
        Temperatur temperatur = new Temperatur(-500);

        assertEquals(errorMessage, outContent.toString());
    }
}