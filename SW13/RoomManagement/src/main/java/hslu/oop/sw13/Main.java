package hslu.oop.sw13;

import hslu.oop.sw13.event.RoomEventEventHandler;
import hslu.oop.sw13.room.Room;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final RoomEventEventHandler roomEventEventHandler = new RoomEventEventHandler();

    public static void main(String[] args) {

        Room best11Room = roomEventEventHandler.bookBestRoom(11);
        Room best6Room = roomEventEventHandler.bookBestRoom(6);
        Room best17Room = roomEventEventHandler.bookBestRoom(17);

        System.out.println("Best room for 11 People: " + best11Room);
        System.out.println("Best room for 6 People: " + best6Room);
        System.out.println("Best room for 17 People: " + best17Room);
    }
}