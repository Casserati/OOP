package hslu.oop.sw13.room;

import hslu.oop.sw13.room.exception.AllRoomsFullException;
import hslu.oop.sw13.room.exception.RoomAlreadyExistsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomManagementTest {

    RoomManagement rm;

    @BeforeEach
    void setUp() {
        rm = new RoomManagement();
        for (int i = 1; i <= 10; i++) {
            Room roomCreate = new Room(200 + i, 2 + i);
            rm.addRoom(roomCreate);
        }

    }

    @Test
    void test_getRoom_validNumber() {
        assertNotNull(rm.getRoom(201));
    }

    @Test
    void test_getRoom_invalidNumber() {
        assertEquals("Room number not found",
                assertThrows(
                        IllegalArgumentException.class,
                        () -> rm.getRoom(100)).getMessage());
    }

    @Test
    void test_addRoom_alreadyExists() {
        assertEquals("Room already exists",
                assertThrows(
                        RoomAlreadyExistsException.class,
                        () -> rm.addRoom(new Room(201, 10))).getMessage());
    }

    @Test
    void test_allRoomsBooked_throwsException() {
        for (int i = 1; i <= 15; i++) {
            rm.bookBestRoom(2);
        }

        assertEquals("All rooms are full",
                assertThrows(
                        AllRoomsFullException.class,
                        () -> rm.bookBestRoom(2)).getMessage());
    }
}