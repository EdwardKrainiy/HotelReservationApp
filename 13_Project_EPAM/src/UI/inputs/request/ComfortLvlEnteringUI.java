package UI.inputs.request;

import java.util.Scanner;

public class ComfortLvlEnteringUI {
    public int comfortLevel(Scanner sc){
        int lvl;
        while (!sc.hasNextInt() || (lvl = sc.nextInt()) <= 0 || lvl > 3){
            System.out.println("Incorrect value, try again!");
            sc.nextLine();
        }
        return lvl;
    }
}
