package services.admin;

import UI.inputs.admin.RequestSelectingUI;
import dao.ClientsDAO;
import dao.RequestsDAO;
import dao.RoomsDAO;
import UI.inputs.admin.HotelRoomAddingUI;
import domain.Client;
import domain.Request;
import domain.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CheckRequestService {

    final static Logger log = LogManager.getLogger(CheckRequestService.class);

    public void service(List<Request> requests, List<Room> rooms) throws IOException {
        if(requests.size() == 0){
            System.out.println("No requests!");
        }
        else {
            for(int i = 0; i < requests.size(); i++) {
                System.out.println("Request #" + i);
                System.out.println("Amount of days: " + requests.get(i).getDaysAmount());
                System.out.println("Rooms amount: " + requests.get(i).getRoomsAmount());
                System.out.println("Comfort level: " + requests.get(i).getComfortLevel());
                System.out.println();
                if(rooms.size() == 0){
                    System.out.println("No rooms for this request!");
                    log.info("No rooms for request number " + i);
                }
                else
                for (int j = 0; j < rooms.size(); j++) {
                    if ((requests.get(i).getRoomsAmount() == rooms.get(j).getRoomsAmount() || (requests.get(i).getComfortLevel() == rooms.get(j).getComfortLevel()))) {
                        System.out.println("Hotel room #" + j);
                        System.out.println("Rooms amount: " + rooms.get(j).getRoomsAmount());
                        System.out.println("Comfort level: " + rooms.get(j).getComfortLevel());
                        System.out.println();
                        System.out.println("Request can be: ");
                        System.out.println("1. Accepted.");
                        System.out.println("2. Declined.");
                        Scanner sc = new Scanner(System.in);

                        RequestSelectingUI requestSelecting = new RequestSelectingUI();

                        int var = requestSelecting.variantChoosing(sc);
                        if (var == 1) {
                            System.out.println("Enter number of room:");
                            HotelRoomAddingUI roomAdding = new HotelRoomAddingUI();
                            int room = roomAdding.roomsEntering(sc, rooms.size());
                            int cost_ = requests.get(j).getComfortLevel() * requests.get(j).getDaysAmount() * requests.get(j).getRoomsAmount();
                            requests.remove(i);

                            RequestsDAO requestsDao = new RequestsDAO();
                            requestsDao.requestRewriting(requests);
                            rooms.remove(room);

                            RoomsDAO roomsDao = new RoomsDAO();
                            roomsDao.roomRewriting(rooms);

                            ClientsDAO clientsDao = new ClientsDAO();
                            List<Client> clients = clientsDao.clientReading();
                            clients.get(i).setCost(clients.get(i).getCost() + cost_);
                            clientsDao.clientRewriting(clients);
                            System.out.println("Request was accepted! Cost: " + cost_);
                            log.info("Accepted request number " + j);
                        }
                        if (var == 2) {
                            requests.remove(i);
                            RequestsDAO requestsDAO = new RequestsDAO();
                            requestsDAO.requestRewriting(requests);
                            System.out.println("Request was deleted!");
                            log.info("Declined request number " + j);
                        }
                    }
                }
            }
        }
    }
}
