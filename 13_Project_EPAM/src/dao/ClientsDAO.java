package dao;

import domain.Client;
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

    public List clientReading() throws IOException {
        List<Client> clients = new ArrayList<Client>();
        try(Connection connection = ConnectionFactory.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from client");
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

    public void clientRewriting(List<Client> clients) throws IOException {
        try(Connection connection = ConnectionFactory.getConnection()){
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from client");
            for(int i = 0; i < clients.size(); i++) {
                String firstName = clients.get(i).getFirstName();
                String secondName = clients.get(i).getSecondName();
                int age = clients.get(i).getAge();
                String login = clients.get(i).getLogin();
                String password = clients.get(i).getPassword();
                int cost = clients.get(i).getCost();
                int id = clients.get(i).getId();

                PreparedStatement statement1 = connection.prepareStatement("insert into client values(?, ?, ?, ?, ?, ?, ?)");

                statement1.setString(1, firstName);
                statement1.setString(2, secondName);
                statement1.setInt(3, age);
                statement1.setString(4, login);
                statement1.setString(5, password);
                statement1.setInt(6, cost);
                statement1.setInt(7, id );
                statement1.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Clients was changed.");
    }
}
