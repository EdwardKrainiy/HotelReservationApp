package UI.inputs.common;

import java.util.Scanner;

public class AgeEnteringUI {
    public static int enterAge(Scanner sc){
        int age;
        while (!sc.hasNextInt() || (age = sc.nextInt()) <= 0) {
            System.out.println("Incorrect value, try again!");
            sc.nextLine();
        }
        return age;
    }
}
