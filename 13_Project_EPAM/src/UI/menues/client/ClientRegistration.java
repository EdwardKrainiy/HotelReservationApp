package UI.menues.client;

import UI.inputs.common.*;
import domain.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ClientRegistration {

    final static Logger log = LogManager.getLogger(ClientRegistration.class);

    public Client registration(){
        Scanner S1 = new Scanner(System.in);

        System.out.println("Enter first name:");
        FirstNameEnteringUI firstNameEntering = new FirstNameEnteringUI();
        String firstName = firstNameEntering.enterFirstName(S1);

        System.out.println("Enter second name:");
        SecondnameEnteringUI secondnameEnteringUI = new SecondnameEnteringUI();
        String secondName = secondnameEnteringUI.enterSecondName(S1);

        System.out.println("Enter age:");
        AgeEnteringUI ageEntering = new AgeEnteringUI();
        int age = ageEntering.enterAge(S1);

        System.out.println("Enter login:");
        LoginEnteringUI loginEntering = new LoginEnteringUI();
        String login = loginEntering.enterLogin(S1);

        System.out.println("Enter password:");
        PasswordEnteringUI passwordEntering = new PasswordEnteringUI();
        String password = passwordEntering.enterPassword(S1);

        Client C1 = new Client(firstName, secondName, age, login, password, 0, 0);
        log.info("Client was created.");
        return C1;
    }
}
