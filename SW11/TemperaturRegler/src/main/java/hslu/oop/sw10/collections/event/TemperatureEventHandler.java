package hslu.oop.sw10.collections.event;

import hslu.oop.sw10.collections.TemperatureVerlaufImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TemperatureEventHandler implements TemperatureEventListener{
    private static final Logger LOGGER = LogManager.getLogger(TemperatureEventHandler.class);

    private final TemperatureVerlaufImpl temperatureVerlauf = new TemperatureVerlaufImpl();

    public TemperatureEventHandler(){
        temperatureVerlauf.addPropertyChangeListener(this);
    }

    @Override
    public void eventChanged(TemperatureEvent event) {
        LOGGER.info("New Temperature Event was fired! EventType: {}, value: {}", event.getType(), event.getValue());
    }

    public TemperatureVerlaufImpl getTemperatureVerlauf() {
        return this.temperatureVerlauf;
    }
}
