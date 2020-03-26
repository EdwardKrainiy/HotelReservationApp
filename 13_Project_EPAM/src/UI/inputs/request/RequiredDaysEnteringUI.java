package UI.inputs.request;

import java.util.Scanner;

public class RequiredDaysEnteringUI {
    public static int days(Scanner sc){
        int days;
        while (!sc.hasNextInt() || (days = sc.nextInt()) <= 0){
            System.out.println("Incorrect value, try again!");
            sc.nextLine();
        }
        return days;
    }
}
