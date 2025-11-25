package hslu.oop.sw10.collections;

import hslu.oop.sw10.Temperature;

import hslu.oop.sw10.collections.event.EventType;
import hslu.oop.sw10.collections.event.TemperatureEvent;
import hslu.oop.sw10.collections.event.TemperatureEventListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeListener;
import java.util.*;

public class TemperatureVerlaufImpl implements TemperatureVerlauf {

    private final List<TemperatureEventListener> temperatureEventListeners = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger(TemperatureVerlaufImpl.class);

    List<Temperature> temperatureSet = new ArrayList<>();

    public void add(Temperature temperature) {
        Temperature currentMax = getMaxValue();
        Temperature currentMin = getMinValue();
        this.temperatureSet.add(temperature);
        if (!getMinValue().equals(currentMin)) {
            fireEvent(new TemperatureEvent(this, getMinValue(), EventType.MinEvent));
        }
        if (!getMaxValue().equals(currentMax)) {
            fireEvent(new TemperatureEvent(this, getMaxValue(), EventType.MaxEvent));
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
