package hslu.oop.sw11.event;

import hslu.oop.sw11.Temperature;

import java.util.EventObject;

public class TemperatureEvent extends EventObject {

    EventType type;
    Temperature value;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @param value new value for event
     * @param eventType the enum type of event {@link EventType}
     */
    public TemperatureEvent(Object source, Temperature value,  EventType eventType) {
        super(source);
        this.type = eventType;
        this.value = value;
    }

    public  EventType getType() {
        return this.type;
    }

    public Temperature getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "TemperatureEvent{" +
                "type=" + this. type+
                '}';
    }
}
