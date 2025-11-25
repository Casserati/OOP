package hslu.oop.sw10.collections;

import hslu.oop.sw10.Temperature;

import hslu.oop.sw10.event.EventType;
import hslu.oop.sw10.event.TemperatureEvent;
import hslu.oop.sw10.event.TemperatureEventListener;

import java.util.*;

public class TemperatureVerlaufImpl implements TemperatureVerlauf {

    private final List<TemperatureEventListener> temperatureEventListeners = new ArrayList<>();

    List<Temperature> temperatureSet = new ArrayList<>();

    public void add(Temperature temperature) {
        this.temperatureSet.add(temperature);
        Temperature currentMax = getMaxValue();
        Temperature currentMin = getMinValue();
        if (temperature.equals(currentMin)) {
            fireEvent(new TemperatureEvent(this, currentMax, EventType.MinEvent));
        }
        if (temperature.equals(currentMax)) {
            fireEvent(new TemperatureEvent(this, currentMin, EventType.MaxEvent));
        }
    }

    public void clear() {
        this.temperatureSet.clear();
    }

    public int getCount() {
        return temperatureSet.size();
    }

    public Temperature get(int index) {
        return temperatureSet.get(index);
    }

    public Temperature getMaxValue() {
        if (temperatureSet.isEmpty()) {
            return null;
        }
        return Collections.max(temperatureSet);
    }

    public Temperature getMinValue() {
        if (temperatureSet.isEmpty()) {
            return null;
        }
        return Collections.min(temperatureSet);
    }

    public Temperature getAverage() {
        if (temperatureSet.isEmpty()) {
            return null;
        }
        float values = 0.0f;
        for (Temperature temperature : temperatureSet) {
            values += temperature.getTemperatureInCelsius();
        }
        return Temperature.createFromCelsius(values / temperatureSet.size());
    }

    public void addPropertyChangeListener(final TemperatureEventListener listener) {
        if (listener != null) {
            this.temperatureEventListeners.add(listener);
        }
    }

    public void removePropertyChangeListener(final TemperatureEventListener listener) {
        if (listener != null) {
            this.temperatureEventListeners.remove(listener);
        }
    }

    public void fireEvent(TemperatureEvent event) {
        for (final TemperatureEventListener listener : this.temperatureEventListeners) {
            listener.eventChanged(event);
        }
    }
}
