package UI.roles;

import UI.menues.admin.AdministratorMenuUI;
import UI.menues.client.ClientMenuUi;
import dao.AdministratorsDAO;
import dao.ClientsDAO;
import services.admin.AdministratorLoginCheckService;
import services.admin.AdministratorRegistrationService;
import services.client.ClientLoginCheckService;
import services.client.ClientRegistrationService;

import java.io.IOException;
import java.util.Scanner;

import static UI.inputs.common.LoginEnteringUI.enterLogin;
import static UI.inputs.common.PasswordEnteringUI.enterPassword;

public class RoleCheckingUI {
    public static void roleCheckRegistration(String role) throws IOException {
        if(role.equals("Admin")){
            AdministratorRegistrationService.administratorRegistration();
        } else if (role.equals("Client")){
            ClientRegistrationService.clientRegistration();
        } else System.out.println("Error! Incorrect role!");
    }

    public static void roleCheckLogging(String role) throws IOException {
        if(role.equals("Admin")){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter login:");
            String login = enterLogin(s);
            System.out.println("Enter password:");
            String password = enterPassword(s);

            int number = AdministratorLoginCheckService.listChecking(login, password, AdministratorsDAO.adminReading());
            if(AdministratorLoginCheckService.elementChecking(number, AdministratorsDAO.adminReading(), login, password) >= 0){
                AdministratorMenuUI.menu(number);
            }

        } else if (role.equals("Client")){
            Scanner s = new Scanner(System.in);
            System.out.println("Enter login:");
            String login = enterLogin(s);
            System.out.println("Enter password:");
            String password = enterPassword(s);

            int number = ClientLoginCheckService.listChecking(login, password, ClientsDAO.clientReading());
            if(ClientLoginCheckService.elementChecking(number, ClientsDAO.clientReading(), login, password) >= 0){
                ClientMenuUi.menu(number);
            }
        } else System.out.println("Error! Incorrect role!");
    }
}
