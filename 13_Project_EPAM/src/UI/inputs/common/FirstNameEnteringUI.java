package UI.inputs.common;

import java.util.Scanner;

public class FirstNameEnteringUI {
    public static String enterFirstName(Scanner sc){
        String firstName = sc.next();
        while(!sc.nextLine().isEmpty()){
            System.out.println("Error, enter first name!");
        }
        return firstName;
    }
}
