package hslu.oop.sw02;

public class Temperatur {

    float temperatureInCelsius;

    /**
     * Default Constructor
     * sets default temperature to 20 degree Celsius
     */
    public Temperatur() {
        this.temperatureInCelsius = 20.0f;
    }

    /**
     * Constructor
     * sets default temperature to given float value degree Celsius
     */
    public Temperatur(float temperatureInCelsius) {
        if (verifyTemperatureValid(temperatureInCelsius)){
            this.temperatureInCelsius = temperatureInCelsius;
        }
    }

    /**
     * gets the current temperature in Celsius
     * @return the current temperature in Celsius
     */
    public float getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    /**
     * sets the temperature to given celsius value
     * @param temperatureInCelsius Celsius value that has to be converted
     */
    public void setTemperatureInCelsius(float temperatureInCelsius) {
        if (verifyTemperatureValid(temperatureInCelsius)) {
            this.temperatureInCelsius = temperatureInCelsius;
        }
    }

    /**
     * gets current temperature in kelvin
     *
     * @return current temperature of class in Kelvin
     */
    public float getTemperatureInKelvin() {
        return fromCelsiusToKelvin(temperatureInCelsius);
    }

    /**
     * gets current temperature in fahrenheit
     *
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
    public void changeTemperature(float temperature) {
        if (verifyTemperatureValid(this.temperatureInCelsius + temperature)) {
            this.temperatureInCelsius =+ temperature;
        }
    }

    /**
     *  verifies value is valid for given range 0 to 1000 Kelvin
     * @param value value that has to be validated
     * @return true if temperature is valid
     */
    private boolean verifyTemperatureValid(float value) {
        if (fromCelsiusToKelvin(value) > 1000f || fromCelsiusToKelvin(value) < 0f) {
            System.out.println("Temperatur ist nicht gültig für den gegebenen Wertebereich!");
            return false;
        } else {
            return true;
        }
    }

    /**
     *  converts given celsius value into the fahrenheit value
     * @param temperatureInCelsius Celsius value that has to be converted
     * @return the current temperature in fahrenheit
     */
    private float fromCelsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }

    /**
     *  converts given celsius value into the kelvin value
     * @param temperatureInCelsius Celsius value that has to be converted
     * @return the current temperature in kelvin
     */
    private float fromCelsiusToKelvin(float temperatureInCelsius){
        return temperatureInCelsius + 273.15f;
    }
}
