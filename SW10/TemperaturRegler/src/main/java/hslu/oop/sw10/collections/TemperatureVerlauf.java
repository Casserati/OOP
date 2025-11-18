package hslu.oop.sw10.collections;

import hslu.oop.sw10.Temperature;

public interface TemperatureVerlauf {

    public void add(Temperature temperature);

    public void clear();

    public int getCount();
}
