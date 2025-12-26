package hslu.oop.sw13.event;

import java.util.EventListener;

public interface RoomEventListener extends EventListener {
    void eventChanged(RoomEvent event);
}
