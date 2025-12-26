package hslu.oop.sw13.event;

import hslu.oop.sw13.room.Room;
import hslu.oop.sw13.room.RoomState;

import java.util.EventObject;

public class RoomEvent extends EventObject {

    Room room;
    Integer capacity;
    RoomState roomState;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public RoomEvent(Object source, Room room, Integer capacity, RoomState roomState) {
        super(source);
        this.room = room;
        this.capacity = capacity;
        this.roomState = roomState;
    }

    public Room getRoom() {
        return room;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public RoomState getRoomState() {
        return roomState;
    }

    @Override
    public String toString() {
        return "RoomEvent{" +
                "room=" + this.room +
                ", capacity=" + this.capacity +
                ", roomState=" + this.roomState +
                '}';
    }
}
