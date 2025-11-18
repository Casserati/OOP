package hslu.oop.sw10.collections.event;

import hslu.oop.sw10.Temperature;

import java.util.EventObject;

public class TemperatureEvent extends EventObject {

    EventType type;
    Temperature value;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
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
