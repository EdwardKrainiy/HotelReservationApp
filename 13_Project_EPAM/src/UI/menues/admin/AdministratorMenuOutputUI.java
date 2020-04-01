package UI.menues.admin;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AdministratorMenuOutputUI {

    final static Logger log = LogManager.getLogger(AdministratorMenuOutputUI.class);

    public void menu() {
        System.out.println("");
        System.out.println("1. Check rooms.");
        System.out.println("2. Add a new hotel room.");
        System.out.println("3. Check requests.");
        System.out.println("4. Exit.");
        log.info("Administrator menu output.");
    }
}
