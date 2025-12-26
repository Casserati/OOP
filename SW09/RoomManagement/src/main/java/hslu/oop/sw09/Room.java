package hslu.oop.sw09;

import org.apache.commons.lang3.Range;

class Room {

    private final int roomNumber;
    private final int roomCapacity;

    public Room(final int roomNumber, final int roomCapacity) {
        if (!Range.between(100, 999).contains(roomNumber)) {
            throw new IllegalArgumentException("Invalid room number, room number must be between 100 and 999");
        }
        if (roomCapacity < 2) {
            throw new IllegalArgumentException("Invalid room capacity, room capacity must be larger than 2");
        }
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        return (object instanceof Room room)
                && (room.roomNumber == this.roomNumber);
    }
}
