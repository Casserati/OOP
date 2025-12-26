package hslu.oop.sw09.room;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import static hslu.oop.sw09.room.RoomState.FREE;

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

    public Room findBestRoom(int roomCapacity){
        Room bestRoom = null;
        for (Room r : rooms.values()){
            if (r.getRoomCapacity() >= roomCapacity && r.isFree()){
                if (bestRoom == null || r.getRoomCapacity() < bestRoom.getRoomCapacity()){
                    bestRoom = r;
                }
            }
        }
        return bestRoom;
    }

    public boolean freeUpRoom(int roomNumber){
        Room room = rooms.get(roomNumber);

        if(room == null){
            return false;
        }

        if(room.isFree()){
            return false; //room was never reserved
        }

        room.setRoomState(FREE);
        return true;
    }
}
