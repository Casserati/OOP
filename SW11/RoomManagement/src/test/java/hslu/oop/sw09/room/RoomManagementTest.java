package hslu.oop.sw09.room;

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
    void test_getRoom_validNumber(){
        assertNotNull(rm.getRoom(201));
    }

    @Test
    void test_getRoom_invalidNumber(){
        assertEquals("Room number not found",
                assertThrows(
                        IllegalArgumentException.class,
                        () -> rm.getRoom(100)).getMessage());
    }
}