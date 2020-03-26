package services.client;

import UI.inputs.common.*;
import dao.ClientsDAO;
import domain.Client;

import java.io.IOException;
import java.util.Scanner;

public class ClientRegistrationService{
    public static void clientRegistration() throws IOException {
        Scanner S1 = new Scanner(System.in);

        System.out.println("Enter first name:");
        String firstName = FirstNameEnteringUI.enterFirstName(S1);

        System.out.println("Enter second name:");
        String secondName = SecondnameEnteringUI.enterSecondName(S1);

        System.out.println("Enter age:");
        int age = AgeEnteringUI.enterAge(S1);

        System.out.println("Enter login:");
        String login = LoginEnteringUI.enterLogin(S1);

        System.out.println("Enter password:");
        String password = PasswordEnteringUI.enterPassword(S1);

        Client C1 = new Client(firstName, secondName, age, login, password, 0, 0);
        System.out.println("You successfully registered!");
        ClientsDAO.clientAdding(C1);
    }
}
