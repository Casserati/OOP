package hslu.oop.sw09.room;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class RoomManagement {

    Map<Integer, Room> rooms = new TreeMap<>();

    public RoomManagement(){
        Room newRoom = new Room(603, 12);
        addRoom(newRoom);
    }

    public void addRoom(Room room) {
        rooms.put(room.getRoomNumber(), room);
    }

    public Room getRoom(int roomNumber) {
        return Optional.ofNullable(
                rooms.get(roomNumber))
                .orElseThrow(() -> new IllegalArgumentException("Room number not found"));
    }
}
