package hslu.oop.sw13.room.exception;

public class RoomAlreadyExistsException extends RuntimeException {

    public RoomAlreadyExistsException() {
        super("Room already exists");
    }

    public RoomAlreadyExistsException(String message) {
        super(message);
    }

    public RoomAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public RoomAlreadyExistsException(Throwable cause) {
        super(cause);
    }
}