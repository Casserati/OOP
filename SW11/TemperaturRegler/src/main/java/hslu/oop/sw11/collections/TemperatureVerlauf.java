package hslu.oop.sw11.collections;

import hslu.oop.sw11.Temperature;

public interface TemperatureVerlauf {

    public void add(Temperature temperature);

    public void clear();

    public int getCount();
}
