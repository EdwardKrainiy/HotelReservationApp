package services.admin;

import dao.RequestsDAO;
import dao.RoomsDAO;
import UI.inputs.request.ComfortLvlEnteringUI;
import UI.inputs.request.RoomsAmountEnteringUI;
import domain.Request;
import domain.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AdministratorMenuService{

    final static Logger log = LogManager.getLogger(AdministratorMenuService.class);

    public void checkRequest() throws IOException {
        RequestsDAO requestsDao = new RequestsDAO();
        RoomsDAO roomsDao = new RoomsDAO();

        List<Request> requests = requestsDao.requestReading();
        List<Room> rooms = roomsDao.roomReading();

        CheckRequestService checkRequest = new CheckRequestService();
        checkRequest.service(requests, rooms);
    }

    public void addRoom() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rooms amount. From 1 to 5: ");
        RoomsAmountEnteringUI roomsAmount = new RoomsAmountEnteringUI();
        int room = roomsAmount.rooms(sc);

        System.out.println("Enter comfort level. From 1 to 3: ");
        ComfortLvlEnteringUI comfortLvl = new ComfortLvlEnteringUI();
        int lvl = comfortLvl.comfortLevel(sc);

        Room r1 = new Room(room, lvl);
        log.info("Room was created.");
        System.out.println("Room was added!");
        RoomsDAO roomsDao = new RoomsDAO();
        roomsDao.roomAdding(r1);
    }

    public void checkRooms() throws IOException {
        RoomsDAO roomsDao = new RoomsDAO();
        List<Room> rooms = roomsDao.roomReading();
        if(rooms.size() == 0){
            System.out.println("No rooms!");
            log.info("No rooms.");
        } else
            for(int i = 0; i < rooms.size(); i++){
                System.out.println(i+ ") " + "Rooms amount: " + rooms.get(i).getRoomsAmount());
                System.out.println("Comfort level: " + rooms.get(i).getComfortLevel());
                System.out.println();
            }
            log.info("Rooms was showed.");
    }
}
