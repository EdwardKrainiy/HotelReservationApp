package UI.menues.menu;

import java.util.Scanner;

public class CommonMenuSelectingUI {
    public static int menuSelecting(){
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number.");
        while (!sc.hasNextInt()) {
            System.out.println("Incorrect value, try again!");
            sc.nextLine();
        }
        n = sc.nextInt();
        return n;
    }
}
