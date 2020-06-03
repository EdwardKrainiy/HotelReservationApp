package by.epam.hotelreservation.dao;


import by.epam.hotelreservation.domain.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestsDAO{

    final static Logger log = LogManager.getLogger(RequestsDAO.class);

    public void requestAdding(Request r1) throws IOException {
        int requestId = r1.getRequestId();
        int comfortLevel = r1.getComfortLevel();
        int daysAmount = r1.getDaysAmount();
        int roomsAmount = r1.getRoomsAmount();
        int price = r1.getPrice();

        try(Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement1  = connection.prepareStatement("insert into request values(?, ?, ?, ?, ?)");
            statement1.setInt(1, roomsAmount);
            statement1.setInt(2, comfortLevel);
            statement1.setInt(3, requestId);
            statement1.setInt(4, price);
            statement1.setInt(5, daysAmount);
            statement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("Request was added.");
    }

    public List requestReading() throws IOException {
        List<Request> requests = new ArrayList<Request>();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from request");){
            while(resultSet.next()){
                Request r = new Request(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5));
                requests.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Requests was obtained.");
        return requests;
    }

    public void requestUpdating(Request request) throws IOException {
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();)
        {
            statement.executeQuery("update request set roomsAmount = request.roomsAmount, comfortLevel = request.comfortLevel, price = request.price, daysAmount = request.daysAmount where requestId = request.requestId");
        } catch (SQLException ex) {
            log.error("Request updating error!");
        }
        log.info("Request was changed.");
    }

    public void requestDeleting(Request request) throws IOException {
        try(Connection connection = ConnectionFactory.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeQuery("delete from request where requestId = request.requestId");
        } catch (Exception e) {
            log.error("Request deleting error!");
        }
        log.info("Request was deleted.");
    }
}
