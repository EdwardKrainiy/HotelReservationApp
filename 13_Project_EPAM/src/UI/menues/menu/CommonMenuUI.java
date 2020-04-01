package UI.menues.menu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommonMenuUI {

    final static Logger log = LogManager.getLogger(CommonMenuUI.class);

    public void commonMenu(){
        System.out.println();
        System.out.println("1. Registration.");
        System.out.println("2. Log in.");
        System.out.println("3. Exit.");
        log.info("Common menu output.");
    }
}
