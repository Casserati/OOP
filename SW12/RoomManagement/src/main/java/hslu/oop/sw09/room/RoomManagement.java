package hslu.oop.sw09.room;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import static hslu.oop.sw09.room.RoomState.FREE;
import static hslu.oop.sw09.room.RoomState.RESERVED;

public class RoomManagement {

    Map<Integer, Room> rooms = new TreeMap<>();

    public RoomManagement(){
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
            throw new IllegalArgumentException("Room already exists");
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

    public Room bookBestRoom(int roomCapacity){
        Room bestRoom = null;
        for (Room r : rooms.values()){
            if (r.getRoomCapacity() >= roomCapacity && r.isFree()){
                if (bestRoom == null || r.getRoomCapacity() < bestRoom.getRoomCapacity()){
                    bestRoom = r;
                }
            }
        }
        bestRoom.setRoomState(RESERVED);
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
