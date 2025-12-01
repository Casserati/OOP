package dto;

import java.time.LocalDateTime;

public class MeasurementDto {

    private Long id;
    private float temperature;
    private int humidity;
    private LocalDateTime timeOfMeasurement;

    public MeasurementDto(final Long id, final float temperature, final int humidity, final LocalDateTime timeOfMeasurement) {
        this.id = id;
        this.temperature = temperature;
        this.humidity = humidity;
        this.timeOfMeasurement = timeOfMeasurement;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getTimeOfMeasurement() {
        return this.timeOfMeasurement;
    }

    public float getTemperature() {
        return this.temperature;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTimeOfMeasurement(LocalDateTime timeOfMeasurement) {
        this.timeOfMeasurement = timeOfMeasurement;
    }
}
