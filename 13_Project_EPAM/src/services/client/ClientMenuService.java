package services.client;

import dao.ClientsDAO;
import dao.RequestsDAO;
import UI.inputs.request.ComfortLvlEnteringUI;
import UI.inputs.request.RequiredDaysEnteringUI;
import UI.inputs.request.RoomsAmountEnteringUI;
import domain.Client;
import domain.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ClientMenuService {

    final static Logger log = LogManager.getLogger(ClientLoginCheckService.class);

    public void viewProfile(int number) throws IOException {
        ClientsDAO clientsDAO = new ClientsDAO();
        List<Client> clients = clientsDAO.clientReading();
        System.out.println("First name: " + clients.get(number).getFirstName());
        System.out.println("Second name: " + clients.get(number).getSecondName());
        System.out.println("Age: " + clients.get(number).getAge());
        System.out.println("Login: " + clients.get(number).getLogin());
        System.out.println("Cost: " + clients.get(number).getCost());
        log.info("Client profile view.");
    }

    public void requestRegistration(int number) throws IOException {
        Scanner sc = new Scanner(System.in);
        RequestsDAO requestsDAO = new RequestsDAO();
        List<Request> requests = requestsDAO.requestReading();

        ClientsDAO clientsDAO = new ClientsDAO();
        List<Client> clients = clientsDAO.clientReading();
        if(requests.size() == 0){
            System.out.println("Enter comfort level. From 1 to 3: ");
            ComfortLvlEnteringUI comfortEntering = new ComfortLvlEnteringUI();
            int lvl = comfortEntering.comfortLevel(sc);

            System.out.println("Enter amount of days: ");
            RequiredDaysEnteringUI daysEntering = new RequiredDaysEnteringUI();
            int days = daysEntering.days(sc);

            System.out.println("Enter room amount. From 1 to 5: ");
            RoomsAmountEnteringUI roomsEntering = new RoomsAmountEnteringUI();
            int rooms = roomsEntering.rooms(sc);

            int price = 0;
            int id = clients.get(number).getId();
            Request r1 = new Request(id, price, rooms, lvl, days);
            log.info("Request was created.");
            System.out.println("Request was added!");
            requestsDAO.requestAdding(r1);
        }
        else {
            for (int i = 0; i < requests.size(); i++) {
                System.out.println(clients.get(number).getId());
                System.out.println(requests.get(i).getRequestId());
                if (clients.get(number).getId() == requests.get(i).getRequestId()) {
                    System.out.println("You already sent request!");
                    log.info("Request wasn't created, this client is already sent a request.");
                } else {
                    System.out.println("Enter comfort Level. From 1 to 3: ");
                    ComfortLvlEnteringUI comfortEnter = new ComfortLvlEnteringUI();
                    int lvl = comfortEnter.comfortLevel(sc);

                    System.out.println("Enter amount of days: ");
                    RequiredDaysEnteringUI daysEntering = new RequiredDaysEnteringUI();
                    int days = daysEntering.days(sc);

                    System.out.println("Enter room amount. From 1 to 5: ");
                    RoomsAmountEnteringUI roomsEntering = new RoomsAmountEnteringUI();
                    int rooms = roomsEntering.rooms(sc);

                    int price = 0;
                    int id = clients.get(number).getId();
                    Request r1 = new Request(rooms, lvl, id, price, days);
                    log.info("Request was created.");
                    System.out.println("Request was added!");
                    requestsDAO.requestAdding(r1);
                    break;
                }
            }
        }
    }
}
