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
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public float getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(float temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    /**
     * @return current temperature of class in Kelvin
     */
    public float getTemperatureInKelvin(){
        return temperatureInCelsius  + 273.15f;
    }

    /**
     * @return current temperature of class in Fahrenheit
     */
    public float getTemperatureInFahrenheit(){
        return temperatureInCelsius * 1.8f + 32f;
    }

    /**
     * changes temperature relative to given value
     * @param temperatureInKelvin relative temperature change in Kelvin
     */
    public void changeTemperatureInKelvin(float temperatureInKelvin){
        this.temperatureInCelsius =- temperatureInKelvin - 273.15f;
    }

    /**
     * changes temperature relative to given value
     * @param temperatureInCelsius relative temperature change in Celsius
     */
    public void changeTemperatureInCelsius(float temperatureInCelsius){
        this.temperatureInCelsius =- temperatureInCelsius;
    }

}
