package by.epam.hotelreservation.dao;


import by.epam.hotelreservation.domain.Administrator;
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
            log.error("Admin adding error!");
        }
        log.info("Administrator was added.");
    }

    public List<Administrator> adminReading() {
        List<Administrator> administrators = new ArrayList<Administrator>();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select firstName, secondName, age, login, password from administrator");
        ){
            while(resultSet.next()){
                Administrator a = new Administrator(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4), resultSet.getString(5));
                administrators.add(a);
            }
        } catch (Exception e) {
            log.error("Admin reading error!");
        }
        log.info("Administrators was obtained.");
        return administrators;
    }

    public void adminUpdating(Administrator administrator){
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("update administrator set firstName = administrator.firstName, secondName = administrator.secondName, age = administrator.age where login = administrator.login");
        ){
        } catch (Exception e) {
            log.error("Admin updating error!");
        }
        log.info("Administrators was obtained.");
    }

    public void adminDeleting(Administrator administrator){
        try(Connection connection = ConnectionFactory.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("delete from  administrator where login = administrator.login");
        } catch (Exception e) {
            log.error("Admin deleting error!");
        }
        log.info("Administrators was obtained.");
    }
}
