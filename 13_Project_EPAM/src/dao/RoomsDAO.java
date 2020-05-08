package dao;

import domain.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO{

    final static Logger log = LogManager.getLogger(RoomsDAO.class);

    public void roomAdding(Room r1) throws IOException {
        List<Room> rooms = new ArrayList<>();

        int comfortLevel = r1.getComfortLevel();
        int roomsAmount = r1.getRoomsAmount();

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement statement1  = connection.prepareStatement("insert into room values(?, ?)");
        ) {
            statement1.setInt(1, roomsAmount);
            statement1.setInt(2, comfortLevel);
            statement1.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    log.info("Room was added.");
}

    public List roomReading() throws IOException {
        List<Room> rooms = new ArrayList<Room>();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from room");
        ){
            while(resultSet.next()){
                Room r = new Room(resultSet.getInt(1), resultSet.getInt(2));
                rooms.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Rooms was obtained.");
        return rooms;
    }

    public void roomDeleting(Room room) throws IOException {
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
        ){
            statement.executeQuery("delete from room where roomsAmount = room.roomsAmount && comfortLevel = room.comfortLevel");
        } catch (Exception e) {
            log.error("Room deleting error!");
        }
        log.info("Room was deleted.");
    }
}
