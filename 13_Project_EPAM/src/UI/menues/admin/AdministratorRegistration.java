package UI.menues.admin;

import UI.inputs.common.*;
import domain.Administrator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AdministratorRegistration {

    final static Logger log = LogManager.getLogger(AdministratorRegistration.class);

    public Administrator registration() {
        Scanner S2 = new Scanner(System.in);

        System.out.println("Enter first name:");
        FirstNameEnteringUI firstNameEntering = new FirstNameEnteringUI();
        String firstName = firstNameEntering.enterFirstName(S2);

        System.out.println("Enter second name:");
        SecondnameEnteringUI secondNameEntering = new SecondnameEnteringUI();
        String secondName = secondNameEntering.enterSecondName(S2);

        System.out.println("Enter age:");
        AgeEnteringUI ageEntering = new AgeEnteringUI();
        int age = ageEntering.enterAge(S2);

        System.out.println("Enter login:");
        LoginEnteringUI loginEntering = new LoginEnteringUI();
        String login = loginEntering.enterLogin(S2);

        System.out.println("Enter password:");
        PasswordEnteringUI passwordEntering = new PasswordEnteringUI();
        String password = passwordEntering.enterPassword(S2);

        Administrator a1 = new Administrator(firstName, secondName, age, login, password);
        log.info("Administrator was created.");
        return a1;
    }
}
