package hslu.oop.sw10;

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
        Temperature temperature = Temperature.createFromCelsius(500);

        temperature.changeTemperature(1000);


        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void initTempOver1000Kelvin() {
        assertThrows(IllegalArgumentException.class,
                () -> Temperature.createFromCelsius(1000),
                "Die eingegebene Temperatur in Celsius entspricht nicht einer gültigen Temperatur.");
    }

    @Test
    void setToUnder0Kelvin() {
        Temperature temperature = Temperature.createFromCelsius(500);

        temperature.changeTemperature(-1000);

        assertEquals(errorMessage, outContent.toString());
    }

    @Test
    void initTempUnder0Kelvin() {
        assertThrows(IllegalArgumentException.class,
                () -> Temperature.createFromCelsius(-500),
                "Die eingegebene Temperatur in Celsius entspricht nicht einer gültigen Temperatur.");
    }

    @Test
    void test_tempChange_KelvinToCelsius(){
        float expectedKelvin = 273.15f;
        assertEquals(expectedKelvin, Temperature.fromCelsiusToKelvin(0));
    }

    @Test
    void test_tempChange_CelsiusToKelvin(){
        float expectedCelsius = 0.0f;
        assertEquals(expectedCelsius, Temperature.fromKelvinToCelsius(273.15f));
    }
}