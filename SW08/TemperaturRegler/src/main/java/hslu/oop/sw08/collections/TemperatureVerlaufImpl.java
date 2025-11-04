package hslu.oop.sw08.collections;

import hslu.oop.sw08.Temperature;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TemperatureVerlaufImpl implements TemperatureVerlauf {

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

    public Float getMaxValue() {
        if (temperatureSet.isEmpty()) {
            return null;
        }
        return Collections.max(temperatureSet).getTemperatureInCelsius();
    }

    public Float getMinValue() {
        if (temperatureSet.isEmpty()) {
            return null;
        }
        return Collections.min(temperatureSet).getTemperatureInCelsius();
    }

    public Float getAverage(){
        if (temperatureSet.isEmpty()) {
            return null;
        }
        float values = 0.0f;
        for (Temperature temperature : temperatureSet) {
            values += temperature.getTemperatureInCelsius();
        }
        return values / temperatureSet.size();
    }
}
