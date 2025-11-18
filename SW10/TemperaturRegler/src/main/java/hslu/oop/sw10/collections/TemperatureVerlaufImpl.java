package hslu.oop.sw10.collections;

import hslu.oop.sw10.Temperature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TemperatureVerlaufImpl implements TemperatureVerlauf {

    private static final Logger LOGGER = LogManager.getLogger(TemperatureVerlaufImpl.class);


    Set<Temperature> temperatureSet = new HashSet<>();

    public void add(Temperature temperature) {
        this.temperatureSet.add(temperature);
    }

    public void clear() {
        this.temperatureSet.clear();
    }

    public int getCount() {
        return temperatureSet.size();
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

    public Temperature getAverage(){
        if (temperatureSet.isEmpty()) {
            return null;
        }
        float values = 0.0f;
        for (Temperature temperature : temperatureSet) {
            values += temperature.getTemperatureInCelsius();
        }
        return Temperature.createFromCelsius(values / temperatureSet.size());
    }

    private class TemperatureVerlaufChange implements PropertyChangeListener{

        private static final Logger LOGGER = LogManager.getLogger(TemperatureVerlaufChange.class);

        @Override
        public void propertyChange(final PropertyChangeEvent evt) {
            LOGGER.info("propertyChange called: {}", evt);
        }
    }
}
