package hslu.oop.sw08;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class TemperatureTest {

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
        Temperature temperature = new Temperature(500);

        temperature.changeTemperature(1000);


        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void initTempOver1000Kelvin() {
        Temperature temperature = new Temperature(1000);

        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void setToUnder0Kelvin() {
        Temperature temperature = new Temperature(500);

        temperature.changeTemperature(-1000);

        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void initTempUnder0Kelvin() {
        Temperature temperature = new Temperature(-500);

        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void test_tempChange_KelvinToCelsius(){
        float expectedKelvin = 273.15f;
        assertEquals(expectedKelvin, Temperature.fromCelsiusToKelvin(0));
    }

    @Test
    void test_tempChange_CelsiusToKelvin(){
        float expectedCelcius = 0.0f;
        assertEquals(expectedCelcius, Temperature.fromKelvinToCelsius(273.15f));
    }
}