package hslu.oop.sw08.collections;

import hslu.oop.sw08.Temperature;

public interface TemperatureVerlauf {

    public void add(Temperature temperature);

    public void clear();

    public int getCount();
}
