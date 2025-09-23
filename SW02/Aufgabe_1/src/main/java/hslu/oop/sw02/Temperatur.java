package hslu.oop.sw02;

public class Temperatur {

    double temperatureInCelsius;

    /**
     * Default Constructor
     * sets default temperature to 20 degree Celsius
     */
    public Temperatur() {
        this.temperatureInCelsius = 20.0;
    }

    /**
     * Constructor
     * sets default temperature to given double value degree Celsius
     */
    public Temperatur(double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    /**
     * @return current temperature of class in Kelvin
     */
    public double getTemperatureInKelvin(){
        return temperatureInCelsius  + 273.15;
    }

    /**
     * @return current temperature of class in Fahrenheit
     */
    public double getTemperatureInFahrenheit(){
        return temperatureInCelsius * 1.8f + 32;
    }

    /**
     * changes temperature relative to given value
     * @param temperatureInKelvin relative temperature change in Kelvin
     */
    public void changeTemperatureInKelvin(double temperatureInKelvin){
        this.temperatureInCelsius =- temperatureInKelvin - 273.15;
    }

    /**
     * changes temperature relative to given value
     * @param temperatureInCelsius relative temperature change in Celsius
     */
    public void changeTemperatureInCelsius(double temperatureInCelsius){
        this.temperatureInCelsius =- temperatureInCelsius;
    }

}
