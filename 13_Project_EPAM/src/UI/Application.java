package UI;

import UI.menues.menu.CommonMenuSelectingUI;
import UI.menues.menu.CommonMenuUI;
import UI.roles.RoleCheckingUI;
import UI.roles.RoleEnteringUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Application {

    final static Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        int n = 0;
        while (n != 3) {
            CommonMenuUI Menu = new CommonMenuUI();
            Menu.commonMenu();

            CommonMenuSelectingUI MenuSelecting = new CommonMenuSelectingUI();
            n = MenuSelecting.menuSelecting();

            RoleCheckingUI Roles = new RoleCheckingUI();
            RoleEnteringUI roleEntering = new RoleEnteringUI();
            switch (n) {
                case 1:
                    Roles.roleCheckRegistration(roleEntering.roleEntering());
                    log.info("1st application menu.");
                    break;
                case 2:
                    Roles.roleCheckLogging(roleEntering.roleEntering());
                    log.info("2nd application menu.");
                    break;
            }
            log.info("Exit from application menu.");
        }
    }
}
