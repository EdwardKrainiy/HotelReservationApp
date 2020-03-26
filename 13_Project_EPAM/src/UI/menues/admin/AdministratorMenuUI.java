package UI.menues.admin;


import UI.menues.menu.CommonMenuSelectingUI;
import services.admin.AdministratorMenuService;

import java.io.IOException;

public class AdministratorMenuUI{
    public static void menu(int number) throws IOException {
        int n = 0;
        while (n != 4) {
            AdministratorMenuOutputUI.menu();
            n = CommonMenuSelectingUI.menuSelecting();
            switch (n) {
                case 1:
                    AdministratorMenuService.checkRooms();
                    break;
                case 2:
                    AdministratorMenuService.addRoom();
                    break;
                case 3:
                    AdministratorMenuService.checkRequest();
            }
        }
    }
}
