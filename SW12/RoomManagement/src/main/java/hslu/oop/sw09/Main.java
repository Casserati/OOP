package hslu.oop.sw09;

import hslu.oop.sw09.room.Room;
import hslu.oop.sw09.room.RoomManagement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final RoomManagement roomManagement = new RoomManagement();

    public static void main(String[] args) {

        Room best11Room = roomManagement.bookBestRoom(11);
        Room best6Room = roomManagement.bookBestRoom(6);
        Room best17Room = roomManagement.bookBestRoom(17);

        System.out.println("Best room for 11 People: " + best11Room);
        System.out.println("Best room for 6 People: " + best6Room);
        System.out.println("Best room for 17 People: " + best17Room);
    }
}