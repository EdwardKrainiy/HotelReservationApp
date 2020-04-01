package UI.inputs.common;

import java.util.Scanner;

public class LoginEnteringUI {
    public String enterLogin(Scanner sc) {
        String login = sc.next();
        while (!sc.nextLine().isEmpty()) {
            System.out.println("Error, enter login!");
            sc.nextLine();
        }
        return login;
    }
}
