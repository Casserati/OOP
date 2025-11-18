package hslu.oop.sw10.collections.event;


import java.util.EventListener;

public interface TemperatureEventListener extends EventListener {
        void eventChanged(TemperatureEvent event);
}

