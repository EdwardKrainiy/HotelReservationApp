package by.epam.hotelreservation.dao;

import by.epam.hotelreservation.domain.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList requestReading() throws IOException {
        ArrayList<Request> requests = new ArrayList<Request>();
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

    public Request requestReading(int requestId){
        Request request = new Request();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM request where requestId = ?");
        ) {
            preparedStatement.setInt(1, requestId);
            ResultSet result2 = preparedStatement.executeQuery();

            while(result2.next()) {
                request.setRoomsAmount(result2.getInt(1));
                request.setComfortLevel(result2.getInt(2));
                request.setPrice(result2.getInt(3));
                request.setDaysAmount(result2.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("Request with id " + requestId + " was obtained.");
        return request;
    }

    public void requestUpdating(Request request) throws IOException {
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();){
            PreparedStatement preparedStatement = connection.prepareStatement("update request set roomsAmount = ?, comfortLevel = ?, price = ?, daysAmount = ? where requestId = ?");
            preparedStatement.setInt(1, request.getRoomsAmount());
            preparedStatement.setInt(2, request.getComfortLevel());
            preparedStatement.setInt(3, request.getPrice());
            preparedStatement.setInt(4, request.getDaysAmount());
            preparedStatement.setInt(5, request.getRequestId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            log.error("Request updating error!");
        }
        log.info("Requests was changed.");
    }

    public void requestDeleting(int requestId) throws IOException {
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();){
            PreparedStatement preparedStatement = connection.prepareStatement("delete from request where requestId = ?");
            preparedStatement.setInt(1, requestId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            log.error("Request deleting error!");
        }
        log.info("Request was deleted.");
    }
}
