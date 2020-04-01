package UI.menues.client;

import UI.menues.menu.CommonMenuSelectingUI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.client.ClientMenuService;

import java.io.IOException;

public class ClientMenuUi {
    final static Logger log = LogManager.getLogger(ClientMenuUi.class);
    public void menu(int number) throws IOException {
        int n = 0;
        while (n != 3){
            ClientMenuOutput clientMenuOutput = new ClientMenuOutput();
            clientMenuOutput.menu();
            CommonMenuSelectingUI menuSelecting = new CommonMenuSelectingUI();
            n = menuSelecting.menuSelecting();
            ClientMenuService clientMenu = new ClientMenuService();
            switch (n){
                case 1:
                    clientMenu.viewProfile(number);
                    log.info("1st function of client menu.");
                    break;
                case 2:
                    clientMenu.requestRegistration(number);
                    log.info("2nd function of client menu.");
                    break;
            }
            log.info("Exit from client menu.");
        }
    }
}
