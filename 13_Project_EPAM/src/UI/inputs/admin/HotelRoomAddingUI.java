package UI.inputs.admin;

import java.util.Scanner;

public class HotelRoomAddingUI {
    public int roomsEntering(Scanner sc, int roomAmount){
        int rooms;
        while (!sc.hasNextInt() || (rooms = sc.nextInt()) < 0 || rooms >= roomAmount){
            System.out.println("Incorrect value, try again!");
            sc.nextLine();
        }
        return rooms;
    }
}
