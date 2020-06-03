package by.epam.hotelreservation.dao;

import by.epam.hotelreservation.domain.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ClientsDAO{

    final static Logger log = LogManager.getLogger(ClientsDAO.class);

    public void clientAdding(Client c1) throws IOException {
        List<Client> clients = new ArrayList<>();
        clients = clientReading();

        String firstName = c1.getFirstName();
        String secondName = c1.getSecondName();
        int age = c1.getAge();
        String login = c1.getLogin();
        String password = c1.getPassword();
        int cost = c1.getCost();
        int id = clients.size();

        int ind = 0;
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getLogin().equals(c1.getLogin()) && clients.get(i).getPassword().equals(c1.getPassword())){
                ind++;
            }
        }
        if(ind > 0){
            System.out.println("This client is already registered!");
        } else
            try(Connection connection = ConnectionFactory.getConnection()) {
                PreparedStatement statement1  = connection.prepareStatement("insert into client values(?, ?, ?, ?, ?, ?, ?)");
                statement1.setString(1, firstName);
                statement1.setString(2, secondName);
                statement1.setInt(3, age);
                statement1.setString(4, login);
                statement1.setString(5, password);
                statement1.setInt(6, cost);
                statement1.setInt(7, id);
                statement1.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        log.info("Client was added.");
    }

    public ArrayList clientReading() throws IOException {
        ArrayList<Client> clients = new ArrayList<Client>();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from client");
        ){
            while(resultSet.next()){
                Client c = new Client(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getInt(7));
                clients.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Clients was obtained.");
        return clients;
    }

    public Client clientReading(String relogin){
        Client client = new Client();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM client where login = ?");
        ) {
            preparedStatement.setString(1, relogin);
            ResultSet result2 = preparedStatement.executeQuery();

            while(result2.next()) {
                client.setFirstName(result2.getString(1));
                client.setSecondName(result2.getString(2));
                client.setAge(result2.getInt(3));
                client.setLogin(result2.getString(4));
                client.setPassword(result2.getString(5));
                client.setCost(result2.getInt(6));
                client.setId(result2.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("Client with login " + relogin + " was obtained.");
        return client;
    }

    public void clientUpdating(Client client1) throws IOException {
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();){
            PreparedStatement preparedStatement = connection.prepareStatement("update client set firstName = ?, secondName = ?, age = ? where login = ?");
            preparedStatement.setString(1, client1.getFirstName());
            preparedStatement.setString(2, client1.getSecondName());
            preparedStatement.setInt(3, client1.getAge());
            preparedStatement.setString(4, client1.getLogin());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            log.error("Client updating error!");
        }
        log.info("Clients was changed.");
    }

    public void clientDeleting(String login){
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();){
            PreparedStatement preparedStatement = connection.prepareStatement("delete from  client where login = ?");
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            log.error("Client deleting error!");
        }
        log.info("Client was deleted.");
    }
}
