package hslu.oop.sw13.room;

import hslu.oop.sw13.event.RoomEvent;
import hslu.oop.sw13.event.RoomEventListener;
import hslu.oop.sw13.room.exception.AllRoomsFullException;
import hslu.oop.sw13.room.exception.NoRoomsFullException;
import hslu.oop.sw13.room.exception.RoomAlreadyExistsException;

import java.util.*;

import static hslu.oop.sw13.room.RoomState.FREE;
import static hslu.oop.sw13.room.RoomState.RESERVED;

public class RoomManagement {

    private final Map<Integer, Room> rooms = new TreeMap<>();
    private final List<RoomEventListener> listeners = new ArrayList<>();

    public RoomManagement() {
        Room newRoom1 = new Room(600, 18);
        Room newRoom2 = new Room(602, 6);
        Room newRoom3 = new Room(603, 12);
        Room newRoom4 = new Room(605, 24);
        Room newRoom5 = new Room(610, 12);
        addRoom(newRoom1);
        addRoom(newRoom2);
        addRoom(newRoom3);
        addRoom(newRoom4);
        addRoom(newRoom5);
    }

    public void addRoom(Room room) {
        if (rooms.containsKey(room.getRoomNumber())) {
            throw new RoomAlreadyExistsException("Room already exists");
        }
        rooms.put(room.getRoomNumber(), room);
    }

    public Room getRoom(int roomNumber) {
        return Optional.ofNullable(
                        rooms.get(roomNumber))
                .orElseThrow(() -> new IllegalArgumentException("Room number not found"));
    }

    public Map<Integer, Room> getRooms() {
        return rooms;
    }

    public Room bookBestRoom(int roomCapacity) {
        Room bestRoom = null;
        for (Room r : rooms.values()) {
            if (r.getRoomCapacity() >= roomCapacity && r.isFree()) {
                if (bestRoom == null || r.getRoomCapacity() < bestRoom.getRoomCapacity()) {
                    bestRoom = r;
                }
            }
        }
        if (!rooms.isEmpty()) {
            if (bestRoom != null) {
                bestRoom.setRoomState(RESERVED);
                fireEvent(new RoomEvent(this, bestRoom, bestRoom.getRoomCapacity(), RoomState.RESERVED));
            } else {
                throw new AllRoomsFullException();
            }
        } else {
            throw new NoRoomsFullException();
        }

        return bestRoom;
    }

    public boolean freeUpRoom(int roomNumber) {
        Room room = rooms.get(roomNumber);

        if (room == null) {
            return false;
        }

        if (room.isFree()) {
            return false; //room was never reserved
        }

        room.setRoomState(FREE);

        fireEvent(new RoomEvent(this, room, room.getRoomCapacity(), RoomState.FREE));
        return true;
    }

    public void addPropertyChangeListener(final RoomEventListener listener) {
        if (listener != null) {
            this.listeners.add(listener);
        }
    }

    public void removePropertyChangeListener(final RoomEventListener listener) {
        if (listener != null) {
            this.listeners.remove(listener);
        }
    }

    private void fireEvent(RoomEvent event) {
        for (final RoomEventListener listener : this.listeners) {
            listener.eventChanged(event);
        }
    }
}
