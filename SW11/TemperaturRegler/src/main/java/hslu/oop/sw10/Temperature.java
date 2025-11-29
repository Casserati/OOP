package hslu.oop.sw10;

import hslu.oop.sw10.element.ChemicalElement;
import hslu.oop.sw10.element.State;
import hslu.oop.sw10.element.impl.Lead;
import hslu.oop.sw10.element.impl.Mercury;
import hslu.oop.sw10.element.impl.Nitrogen;

import java.util.Objects;

public final class Temperature implements Comparable<Temperature> {

    private static final float KELVIN_OFFSET = 273.15f;
    float temperatureInCelsius;

    /**
     * Default Constructor
     * sets default temperature to 20 degree Celsius
     */
    private Temperature() {
        this.temperatureInCelsius = 20.0f;
    }

    /**
     * Constructor
     * sets default temperature to given float value degree Celsius
     */
    private Temperature(final float temperatureInCelsius) {
        if (verifyTemperatureValid(temperatureInCelsius)) {
            this.temperatureInCelsius = temperatureInCelsius;
        }
    }

    public static Temperature createFromCelsius(final float temperatureInCelsius) {
        if (verifyTemperatureValid(temperatureInCelsius)) {
            return new Temperature(temperatureInCelsius);
        }
        throw new IllegalArgumentException("Die eingegebene Temperatur in Celsius entspricht nicht einer gültigen Temperatur.");
    }

    // Factory method for Kelvin
    public static Temperature createFromKelvin(final float temperatureInKelvin) {
        if (verifyTemperatureValid(fromKelvinToCelsius(temperatureInKelvin))) {
            return new Temperature(temperatureInKelvin - KELVIN_OFFSET);
        }
        throw new IllegalArgumentException("Die eingegebene Temperatur in Kelvin entspricht nicht einer gültigen Temperatur.");
    }

    public static float fromCelsiusToFahrenheit(final float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }

    public static float fromCelsiusToKelvin(final float temperatureInCelsius) {
        return temperatureInCelsius + KELVIN_OFFSET;
    }

    public static float fromKelvinToCelsius(final float temperatureInKelvin) {
        return temperatureInKelvin - KELVIN_OFFSET;
    }

    public float getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    /**
     * @return current temperature of class in Kelvin
     */
    public float getTemperatureInKelvin() {
        return fromCelsiusToKelvin(temperatureInCelsius);
    }

    /**
     * @return current temperature of class in Fahrenheit
     */
    public float getTemperatureInFahrenheit() {
        return fromCelsiusToFahrenheit(temperatureInCelsius);
    }

    /**
     * changes temperature relative to given value
     *
     * @param temperature relative temperature
     */
    public void changeTemperature(final float temperature) {
        if (verifyTemperatureValid(this.temperatureInCelsius + temperature)) {
            this.temperatureInCelsius = +temperature;
        }
    }

    @Override
    public int compareTo(final Temperature o) {
        return Float.compare(this.temperatureInCelsius, o.temperatureInCelsius);
    }

    @Override
    public String toString() {
        return "Temperatur{" +
                "temperatureInCelsius=" + this.temperatureInCelsius +
                '}';
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Temperature temp)
                && (temp.temperatureInCelsius == this.temperatureInCelsius);
    }


    @Override
    public int hashCode() {
        return Objects.hash(this.temperatureInCelsius);
    }

    private static boolean verifyTemperatureValid(float value) {
        if (fromCelsiusToKelvin(value) > 1000f || fromCelsiusToKelvin(value) < 0f) {
            System.out.println("Temperatur ist nicht gültig für den gegebenen Wertebereich!");
            return false;
        } else {
            return true;
        }
    }

    private State returnStateBasedOnTemp(ChemicalElement chemicalElement) {
        return chemicalElement.getState(temperatureInCelsius);
    }

    private String returnStateBasedOnTempSwitch(ChemicalElement chemicalElement) {
        return switch (chemicalElement) {
            case Mercury mercury -> output(mercury, returnStateBasedOnTemp(mercury));
            case Nitrogen nitrogen -> output(nitrogen, returnStateBasedOnTemp(nitrogen));
            case Lead lead -> output(lead, returnStateBasedOnTemp(lead));
            default -> {
                System.out.println("Sie haben kein gültiges Element verwendet");
                yield "Error";
            }
        };
    }

    private String output(ChemicalElement element, State currentState) {
        return element.getChemicalFormula().getValue() + "ist bei " + temperatureInCelsius + "°C " + currentState.getValue();
    }
}
