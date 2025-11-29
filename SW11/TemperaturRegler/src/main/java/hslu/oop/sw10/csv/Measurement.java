package hslu.oop.sw10.csv;

import hslu.oop.sw10.Temperature;

import java.time.LocalDateTime;

public class Measurement {

    private Temperature temperature;
    private int humidity;
    private LocalDateTime timeOfMeasurement;

    public Measurement(final Temperature temperature, final int humidity, final LocalDateTime timeOfMeasurement) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.timeOfMeasurement = timeOfMeasurement;
    }

    public LocalDateTime getTimeOfMeasurement() {
        return this.timeOfMeasurement;
    }

    public Temperature getTemperature() {
        return this.temperature;
    }

    public int getHumidity() {
        return this.humidity;
    }
}
