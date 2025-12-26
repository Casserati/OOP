package hslu.oop.sw09.room;

import org.apache.commons.lang3.Range;

import java.util.Objects;

class Room {

    private final int roomNumber;
    private final transient int roomCapacity;
    private transient RoomState roomState; // use transient for equalsVerifier to ignore variable

    public Room(final int roomNumber, final int roomCapacity) {
        if (!Range.between(100, 999).contains(roomNumber)) {
            throw new IllegalArgumentException("Invalid room number, room number must be between 100 and 999");
        }
        if (roomCapacity < 2) {
            throw new IllegalArgumentException("Invalid room capacity, room capacity must be larger than 2");
        }
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.roomState = RoomState.FREE;
    }

    public int getRoomNumber() {
        return this.roomNumber;
    }

    public int getRoomCapacity() {
        return this.roomCapacity;
    }

    public RoomState getRoomState() {
        return this.roomState;
    }

    public boolean isFree(){
        return this.roomState == RoomState.FREE;
    }

    protected void setRoomState(final RoomState roomState) {
        this.roomState = roomState;
    }


    @Override
    public final boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Room room)
                && (room.roomNumber == this.roomNumber);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.roomNumber);
    }
}
