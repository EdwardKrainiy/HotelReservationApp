package UI.roles;

import java.util.Scanner;

public class RoleEnteringUI {
    public static String roleEntering(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter a role: Admin or Client");
        String role = sc1.nextLine();
        return role;
    }
}
