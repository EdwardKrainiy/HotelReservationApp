package UI.menues.client;

import UI.menues.menu.CommonMenuSelectingUI;
import services.client.ClientMenuService;

import java.io.IOException;

public class ClientMenuUi {
    public static void menu(int number) throws IOException {
        int n = 0;
        while (n != 3){
            ClientMenuOutput.menu();
            n = CommonMenuSelectingUI.menuSelecting();
            switch (n){
                case 1:
                    ClientMenuService.viewProfile(number);
                    break;
                case 2:
                    ClientMenuService.requestRegistration(number);
                    break;
            }
        }
    }
}
