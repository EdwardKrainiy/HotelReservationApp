package UI.roles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class RoleEnteringUI {

    final static Logger log = LogManager.getLogger(RoleEnteringUI.class);

    public String roleEntering(){
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter a role: Admin or Client");
        String role = sc1.nextLine();
        log.info("Role was entered.");
        return role;
    }
}
