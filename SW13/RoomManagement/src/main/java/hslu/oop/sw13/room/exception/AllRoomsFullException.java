package hslu.oop.sw13.room.exception;

public class AllRoomsFullException extends RuntimeException {

    public AllRoomsFullException() {
        super("All rooms are full");
    }

    public AllRoomsFullException(String message) {
        super(message);
    }

    public AllRoomsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public AllRoomsFullException(Throwable cause) {
        super(cause);
    }
}
