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

    public float getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(float temperatureInCelsius) {
        if (verifyTemperatureValid(temperatureInCelsius)) {
            this.temperatureInCelsius = temperatureInCelsius;
        }
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
     * @param temperatureInKelvin relative temperature change in Kelvin
     */
    public void changeTemperatureInKelvin(float temperatureInKelvin) {
        if (verifyTemperatureValid(this.temperatureInCelsius + fromKelvinToCelsius(temperatureInKelvin))) {
            this.temperatureInCelsius =+ temperatureInKelvin - 273.15f;
        }
    }

    /**
     * changes temperature relative to given value
     *
     * @param temperatureInCelsius relative temperature change in Celsius
     */
    public void changeTemperatureInCelsius(float temperatureInCelsius) {
        if(verifyTemperatureValid(this.temperatureInCelsius + temperatureInCelsius)) {
            this.temperatureInCelsius =+ temperatureInCelsius;
        }
    }

    private boolean verifyTemperatureValid(float value) {
        if (fromCelsiusToKelvin(value) > 1000f || fromCelsiusToKelvin(value) < 0f) {
            System.out.println("Temperatur ist nicht gültig für den gegebenen Wertebereich!");
            return false;
        } else {
            return true;
        }
    }

    private float fromCelsiusToFahrenheit(float temperatureInCelsius) {
        return temperatureInCelsius * 1.8f + 32f;
    }

    private float fromCelsiusToKelvin(float temperatureInCelsius){
        return temperatureInCelsius + 273.15f;
    }

    private float fromKelvinToCelsius(float temperatureInKelvin){
        return temperatureInKelvin - 273.15f;
    }
}
