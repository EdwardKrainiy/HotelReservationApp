package UI.menues.admin;


import UI.menues.menu.CommonMenuSelectingUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.admin.AdministratorMenuService;

import java.io.IOException;

public class AdministratorMenuUI{

    final static Logger log = LogManager.getLogger(AdministratorMenuUI.class);

    public void menu(int number) throws IOException {
        int n = 0;
        while (n != 4) {
            AdministratorMenuOutputUI administratorMenuOutput = new AdministratorMenuOutputUI();
            administratorMenuOutput.menu();

            CommonMenuSelectingUI menuSelecting = new CommonMenuSelectingUI();
            n = menuSelecting.menuSelecting();

            AdministratorMenuService administratorMenu = new AdministratorMenuService();
            switch (n) {
                case 1:
                    administratorMenu.checkRooms();
                    log.info("1st function of administrator menu.");
                    break;
                case 2:
                    administratorMenu.addRoom();
                    log.info("2nd function of administrator menu.");
                    break;
                case 3:
                    log.info("3rd function of administrator menu.");
                    administratorMenu.checkRequest();
            }
            log.info("Exit from administrator menu.");
        }
    }
}
