package services.admin;

import UI.inputs.common.*;
import dao.AdministratorsDAO;
import domain.Administrator;

import java.io.IOException;
import java.util.Scanner;

public class AdministratorRegistrationService {
    public static void administratorRegistration() throws IOException {
        Scanner S2 = new Scanner(System.in);

        System.out.println("Enter first name:");
        String firstName = FirstNameEnteringUI.enterFirstName(S2);

        System.out.println("Enter second name:");
        String secondName = SecondnameEnteringUI.enterSecondName(S2);

        System.out.println("Enter age:");
        int age = AgeEnteringUI.enterAge(S2);

        System.out.println("Enter login:");
        String login = LoginEnteringUI.enterLogin(S2);

        System.out.println("Enter password:");
        String password = PasswordEnteringUI.enterPassword(S2);

        Administrator a1 = new Administrator(firstName, secondName, age, login, password);
        System.out.println("You successfully registered!");
        AdministratorsDAO.adminAdding(a1);
    }
}
