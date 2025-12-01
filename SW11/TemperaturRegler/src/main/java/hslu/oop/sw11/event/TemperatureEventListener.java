package hslu.oop.sw11.event;


import java.util.EventListener;

public interface TemperatureEventListener extends EventListener {
        void eventChanged(TemperatureEvent event);
}

