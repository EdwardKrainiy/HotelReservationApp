package UI.roles;

import UI.inputs.common.LoginEnteringUI;
import UI.inputs.common.PasswordEnteringUI;
import UI.menues.admin.AdministratorMenuUI;
import UI.menues.client.ClientMenuUi;
import dao.AdministratorsDAO;
import dao.ClientsDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.admin.AdministratorLoginCheckService;
import services.admin.AdministratorRegistrationService;
import services.client.ClientLoginCheckService;
import services.client.ClientRegistrationService;

import java.io.IOException;
import java.util.Scanner;

public class RoleCheckingUI {

    final static Logger log = LogManager.getLogger(RoleCheckingUI.class);

    public void roleCheckRegistration(String role) throws IOException {
        if(role.equals("Admin")){
            AdministratorRegistrationService administratorRegistration = new AdministratorRegistrationService();
            administratorRegistration.administratorRegistration();
            log.info("Admin.");
        } else if (role.equals("Client")){
            ClientRegistrationService clientRegistration = new ClientRegistrationService();
            clientRegistration.clientRegistration();
            log.info("Client");
        } else {
            System.out.println("Error! Incorrect role!");
            log.info("Incorrect role. Exit to common menu.");
        }
    }

    public void roleCheckLogging(String role) throws IOException {
        LoginEnteringUI loginEntering = new LoginEnteringUI();
        PasswordEnteringUI passwordEntering = new PasswordEnteringUI();

        if(role.equals("Admin")){
            log.info("Admin logining.");
            Scanner s = new Scanner(System.in);
            System.out.println("Enter login:");
            String login = loginEntering.enterLogin(s);

            System.out.println("Enter password:");
            String password = passwordEntering.enterPassword(s);

            AdministratorsDAO administratorsDAO = new AdministratorsDAO();
            AdministratorLoginCheckService administratorLoginCheck = new AdministratorLoginCheckService();
            int number = administratorLoginCheck.listChecking(login, password, administratorsDAO.adminReading());
            if(administratorLoginCheck.elementChecking(number, administratorsDAO.adminReading(), login, password) >= 0){
                AdministratorMenuUI administratorMenu = new AdministratorMenuUI();
                administratorMenu.menu(number);
            }

        } else if (role.equals("Client")){
            log.info("Client logining.");
            Scanner s = new Scanner(System.in);
            System.out.println("Enter login:");
            String login = loginEntering.enterLogin(s);
            System.out.println("Enter password:");
            String password = passwordEntering.enterPassword(s);

            ClientsDAO clientsDAO = new ClientsDAO();
            ClientLoginCheckService clientLoginCheck = new ClientLoginCheckService();
            int number = clientLoginCheck.listChecking(login, password, clientsDAO.clientReading());
            if(clientLoginCheck.elementChecking(number, clientsDAO.clientReading(), login, password) >= 0){
                ClientMenuUi clientMenu = new ClientMenuUi();
                clientMenu.menu(number);
            }
        } else {
            System.out.println("Error! Incorrect role!");
            log.info("Incorrect role. Exit to common menu.");
        }
    }
}
