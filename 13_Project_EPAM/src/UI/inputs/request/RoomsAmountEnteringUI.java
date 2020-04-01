package UI.inputs.request;

import java.util.Scanner;

public class RoomsAmountEnteringUI {
    public int rooms(Scanner sc){
        int rooms;
        while (!sc.hasNextInt() || (rooms = sc.nextInt()) <= 0 || rooms > 5){
            System.out.println("Incorrect value, try again!");
            sc.nextLine();
        }
        return rooms;
    }
}
