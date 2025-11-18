package hslu.oop.sw10.collections.event;

import java.util.EventObject;

class TemperatureEvent extends EventObject {

    EventType type;
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public TemperatureEvent(Object source, EventType eventType) {
        super(source);
        this.type = eventType;
    }
}
