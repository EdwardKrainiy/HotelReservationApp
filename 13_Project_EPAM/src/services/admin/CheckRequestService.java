package services.admin;

import UI.inputs.admin.RequestSelectingUI;
import dao.ClientsDAO;
import dao.RequestsDAO;
import dao.RoomsDAO;
import UI.inputs.admin.HotelRoomAddingUI;
import domain.Client;
import domain.Request;
import domain.Room;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CheckRequestService {
    public static void service(List<Request> requests, List<Room> rooms) throws IOException {
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
                        int var = RequestSelectingUI.variantChoosing(sc);
                        if (var == 1) {
                            System.out.println("Enter number of room:");
                            int room = HotelRoomAddingUI.roomsEntering(sc, rooms.size());
                            int cost_ = requests.get(j).getComfortLevel() * requests.get(j).getDaysAmount() * requests.get(j).getRoomsAmount();
                            requests.remove(i);
                            RequestsDAO.requestRewriting(requests);
                            rooms.remove(room);
                            RoomsDAO.roomRewriting(rooms);
                            List<Client> clients =  ClientsDAO.clientReading();
                            clients.get(i).setCost(clients.get(i).getCost() + cost_);
                            ClientsDAO.clientRewriting(clients);
                            System.out.println("Request was accepted! Cost: " + cost_);
                        }
                        if (var == 2) {
                            requests.remove(i);
                            RequestsDAO.requestRewriting(requests);
                            System.out.println("Request was deleted!");
                        }
                    }
                }
            }
        }
    }
}
