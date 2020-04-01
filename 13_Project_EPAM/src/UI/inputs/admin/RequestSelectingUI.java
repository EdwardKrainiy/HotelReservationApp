package UI.inputs.admin;

import java.util.Scanner;

public class RequestSelectingUI {
    public int variantChoosing(Scanner sc){
        int variant;
        while (!sc.hasNextInt() || (variant = sc.nextInt()) <= 0 || variant > 2){
            System.out.println("Incorrect value, try again!");
            sc.nextLine();
        }
        return variant;
    }
}
