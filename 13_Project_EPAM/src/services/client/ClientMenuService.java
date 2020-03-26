package services.client;

import dao.ClientsDAO;
import dao.RequestsDAO;
import UI.inputs.request.ComfortLvlEnteringUI;
import UI.inputs.request.RequiredDaysEnteringUI;
import UI.inputs.request.RoomsAmountEnteringUI;
import domain.Client;
import domain.Request;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ClientMenuService {
    public static void viewProfile(int number) throws IOException {
        List<Client> clients = ClientsDAO.clientReading();
        System.out.println("First name: " + clients.get(number).getFirstName());
        System.out.println("Second name: " + clients.get(number).getSecondName());
        System.out.println("Age: " + clients.get(number).getAge());
        System.out.println("Login: " + clients.get(number).getLogin());
        System.out.println("Cost: " + clients.get(number).getCost());
    }

    public static void requestRegistration(int number) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<Request> requests = RequestsDAO.requestReading();
        List<Client> clients = ClientsDAO.clientReading();
        if(requests.size() == 0){
            System.out.println("Enter comfort level. From 1 to 3: ");
            int lvl = ComfortLvlEnteringUI.comfortLevel(sc);

            System.out.println("Enter amount of days: ");
            int days = RequiredDaysEnteringUI.days(sc);

            System.out.println("Enter room amount. From 1 to 5: ");
            int rooms = RoomsAmountEnteringUI.rooms(sc);

            int price = 0;
            int id = clients.get(number).getId();
            Request r1 = new Request(id, price, rooms, lvl, days);
            System.out.println("Request was added!");
            RequestsDAO.requestAdding(r1);
        }
        else {
            for (int i = 0; i < requests.size(); i++) {
                if (clients.get(number).getId() == requests.get(i).getRequestId()) {
                    System.out.println("You already sent request!");
                } else {
                    System.out.println("Enter comfort Level. From 1 to 3: ");
                    int lvl = ComfortLvlEnteringUI.comfortLevel(sc);

                    System.out.println("Enter amount of days: ");
                    int days = RequiredDaysEnteringUI.days(sc);

                    System.out.println("Enter room amount. From 1 to 5: ");
                    int rooms = RoomsAmountEnteringUI.rooms(sc);

                    int price = 0;
                    int id = clients.get(number).getId();
                    Request r1 = new Request(id, price, rooms, lvl, days);
                    System.out.println("Request was added!");
                    RequestsDAO.requestAdding(r1);
                }
            }
        }
    }
}
