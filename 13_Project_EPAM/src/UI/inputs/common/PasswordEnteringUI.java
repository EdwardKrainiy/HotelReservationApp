package UI.inputs.common;

import java.util.Scanner;

public class PasswordEnteringUI {
    public String enterPassword(Scanner sc){
        String password = sc.next();
        while(!sc.nextLine().isEmpty()){
            System.out.println("Error, enter password!");
            sc.nextLine();
        }
        return password;
    }
}
