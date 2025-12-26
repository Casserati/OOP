package hslu.oop.sw13.event;

import hslu.oop.sw13.room.Room;
import hslu.oop.sw13.room.RoomManagement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoomEventEventHandler implements RoomEventListener {
    private static final Logger LOGGER = LogManager.getLogger(RoomEventEventHandler.class);

    private final RoomManagement roomManagement = new RoomManagement();

    public RoomEventEventHandler() {
        roomManagement.addPropertyChangeListener(this);
    }

    @Override
    public void eventChanged(RoomEvent event) {
        LOGGER.info("New RoomEvent was fired! Room: {}, capacity: {}, state: {}", event.getRoom(), event.getCapacity(), event.getRoomState());
    }

    public Room bookBestRoom(int roomCapacity) {
        return roomManagement.bookBestRoom(roomCapacity);
    }
}
