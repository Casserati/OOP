package hslu.oop.sw13.room.exception;

public class NoRoomsFullException extends RuntimeException {

    public NoRoomsFullException() {
        super("No rooms exist");
    }

    public NoRoomsFullException(String message) {
        super(message);
    }

    public NoRoomsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoRoomsFullException(Throwable cause) {
        super(cause);
    }
}
