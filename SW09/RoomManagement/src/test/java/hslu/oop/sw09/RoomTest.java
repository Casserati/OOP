package hslu.oop.sw09;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RoomTest {

    @ParameterizedTest
    @MethodSource("provideValidParameters")
    void test_init(int roomNumber, int roomCapacity) {
        Room room = new Room(roomNumber, roomCapacity);

        assertEquals(roomNumber, room.getRoomNumber());
        assertEquals(roomCapacity, room.getRoomCapacity());
    }

    @ParameterizedTest
    @MethodSource("provideInvalidRoomNumber")
    void test_invalidRoomNumber(int roomNumber, int roomCapacity) {
        assertThrows(IllegalArgumentException.class, () -> new Room(roomNumber, roomCapacity),"Invalid room number, room number must be between 100 and 999");
    }

    @ParameterizedTest
    @MethodSource("provideInvalidRoomCapacity")
    void test_invalidRoomCapacity(int roomNumber, int roomCapacity) {
        assertThrows(IllegalArgumentException.class, () -> new Room(roomNumber, roomCapacity),"Invalid room capacity, room capacity must be larger than 2");
    }

    private static Stream<Arguments> provideValidParameters() {
        return Stream.of(
                Arguments.of(100, 2),
                Arguments.of(200, 3),
                Arguments.of(300, 4),
                Arguments.of(400, 5),
                Arguments.of(500, 6));
    }

    private static Stream<Arguments> provideInvalidRoomNumber() {
        return Stream.of(
                Arguments.of(10, 2),
                Arguments.of(20, 3),
                Arguments.of(30, 4),
                Arguments.of(40, 5),
                Arguments.of(50, 6));
    }



    private static Stream<Arguments> provideInvalidRoomCapacity() {
        return Stream.of(
                Arguments.of(100, 1),
                Arguments.of(200, 0),
                Arguments.of(300, -1),
                Arguments.of(400, -2),
                Arguments.of(500, -3));
    }
}