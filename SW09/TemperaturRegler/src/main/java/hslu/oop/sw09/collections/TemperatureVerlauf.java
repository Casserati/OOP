package hslu.oop.sw09.collections;

import hslu.oop.sw09.Temperature;

public interface TemperatureVerlauf {

    public void add(Temperature temperature);

    public void clear();

    public int getCount();
}
