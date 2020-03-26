package services.admin;

import dao.RequestsDAO;
import dao.RoomsDAO;
import UI.inputs.request.ComfortLvlEnteringUI;
import UI.inputs.request.RoomsAmountEnteringUI;
import domain.Request;
import domain.Room;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdministratorMenuService{
    public static void checkRequest() throws IOException {
        List<Request> requests = RequestsDAO.requestReading();
        List<Room> rooms = RoomsDAO.roomReading();
        CheckRequestService.service(requests, rooms);
    }

    public static void addRoom() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rooms amount. From 1 to 5: ");
        int room = RoomsAmountEnteringUI.rooms(sc);

        System.out.println("Enter comfort level. From 1 to 3: ");
        int lvl = ComfortLvlEnteringUI.comfortLevel(sc);

        Room r1 = new Room(room, lvl);
        System.out.println("Room was added!");
        RoomsDAO.roomAdding(r1);
    }

    public static void checkRooms() throws IOException {
        List<Room> rooms = RoomsDAO.roomReading();
        if(rooms.size() == 0){
            System.out.println("No rooms!");
        } else
            for(int i = 0; i < rooms.size(); i++){
                System.out.println(i+ ") " + "Rooms amount: " + rooms.get(i).getRoomsAmount());
                System.out.println("Comfort level: " + rooms.get(i).getComfortLevel());
                System.out.println();
            }
    }
}
