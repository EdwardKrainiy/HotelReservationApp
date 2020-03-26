package UI;

import UI.menues.menu.CommonMenuSelectingUI;
import UI.menues.menu.CommonMenuUI;
import UI.roles.RoleCheckingUI;
import UI.roles.RoleEnteringUI;

import java.io.IOException;


public class Application {
    public static void main(String[] args) throws IOException {
        int n = 0;
        while (n != 3) {
            CommonMenuUI.commonMenu();
            n = CommonMenuSelectingUI.menuSelecting();
            switch (n) {
                case 1:
                    RoleCheckingUI.roleCheckRegistration(RoleEnteringUI.roleEntering());
                    break;
                case 2:
                    RoleCheckingUI.roleCheckLogging(RoleEnteringUI.roleEntering());
                    break;
            }
        }
    }
}
