package dao;

import domain.Administrator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorsDAO{

final static Logger log = LogManager.getLogger(AdministratorsDAO.class);

    public void adminAdding(Administrator a1) throws IOException {
        List<Administrator> administrators = new ArrayList<>();
        administrators = adminReading();

        String firstName = a1.getFirstName();
        String secondName = a1.getSecondName();
        int age = a1.getAge();
        String login = a1.getLogin();
        String password = a1.getPassword();

        int ind = 0;
        for(int i = 0; i < administrators.size(); i++){
            if(administrators.get(i).getLogin().equals(a1.getLogin()) && administrators.get(i).getPassword().equals(a1.getPassword())){
                ind++;
            }
        }
        if(ind > 0){
            System.out.println("This administrator is already registered!");
        } else
            try(Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement1 = connection.prepareStatement("insert into administrator(firstName, secondName, age, login, password) values(?, ?, ?, ?, ?)");

            statement1.setString(1, firstName);
            statement1.setString(2, secondName);
            statement1.setInt(3, age);
            statement1.setString(4, login);
            statement1.setString(5, password);
            statement1.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("Administrator was added.");
    }

    public  List<Administrator> adminReading() {
        List<Administrator> administrators = new ArrayList<Administrator>();
        try(Connection connection = ConnectionFactory.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from administrator");
            while(resultSet.next()){
                Administrator a = new Administrator(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
                administrators.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Administrators was obtained.");
        return administrators;
    }

    public void adminRewriting(List<Administrator> administrators) throws IOException {
        try(Connection connection = ConnectionFactory.getConnection()){
            for(int i = 0; i < administrators.size(); i++) {
                String firstName = administrators.get(i).getFirstName();
                String secondName = administrators.get(i).getSecondName();
                int age = administrators.get(i).getAge();
                String login = administrators.get(i).getLogin();
                String password = administrators.get(i).getPassword();

                PreparedStatement statement1 = connection.prepareStatement("insert into administrator(firstName, secondName, age, login, password) values(?, ?, ?, ?, ?)");

                statement1.setString(1, firstName);
                statement1.setString(2, secondName);
                statement1.setInt(3, age);
                statement1.setString(4, login);
                statement1.setString(5, password);
                statement1.executeUpdate();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("Administrators was changed.");
    }
}
