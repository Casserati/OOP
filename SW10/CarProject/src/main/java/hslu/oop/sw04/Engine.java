package hslu.oop.sw04;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Engine extends CountingSwitchable {

    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();
    private int rpm;

    public Engine(String name) {
        super.setName(name);
    }

    @Override
    public void switchOn() {
        super.switchOn();
        final PropertyChangeEvent event =
                new PropertyChangeEvent(this, "state", State.ON, State.OFF);
        this.firePropertyChangeEvent(event);
        System.out.println("Switching on Engine");
        this.rpm = 500;
    }

    @Override
    public void switchOff() {
        super.switchOff();
        System.out.println("Switching off Engine");
        this.rpm = 0;
    }

    public int getRpm() {
        return this.rpm;
    }

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
        }
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        this.changeListeners.remove(listener);
    }

    private void firePropertyChangeEvent(PropertyChangeEvent event) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(event);
        }
    }
}
