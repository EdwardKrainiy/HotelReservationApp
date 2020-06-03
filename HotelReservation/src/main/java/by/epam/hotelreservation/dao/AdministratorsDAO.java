package by.epam.hotelreservation.dao;


import by.epam.hotelreservation.domain.Administrator;
import by.epam.hotelreservation.domain.Client;
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

    public ArrayList<Administrator> adminReading() throws IOException {
        ArrayList<Administrator> administrators = new ArrayList<Administrator>();
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

    public Administrator adminReading(String relogin){
        Administrator administrator = new Administrator();
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM administrator where login = ?");
        ) {
            preparedStatement.setString(1, relogin);
            ResultSet result2 = preparedStatement.executeQuery();

            while(result2.next()) {
                administrator.setFirstName(result2.getString(1));
                administrator.setSecondName(result2.getString(2));
                administrator.setAge(result2.getInt(3));
                administrator.setLogin(result2.getString(4));
                administrator.setPassword(result2.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        log.info("Admin with login " + relogin + " was obtained.");
        return administrator;
    }

    public void adminUpdating(Administrator administrator) throws IOException{
        try(Connection connection = ConnectionFactory.getConnection();){
            PreparedStatement preparedStatement = connection.prepareStatement("update administrator set firstName = ?, secondName = ?, age = ? where login = ?");
            preparedStatement.setString(1, administrator.getFirstName());
            preparedStatement.setString(2, administrator.getSecondName());
            preparedStatement.setInt(3, administrator.getAge());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            log.error("Admin updating error!");
        }
        log.info("Administrators was obtained.");
    }

    public void adminDeleting(String login){
        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement();){
            PreparedStatement preparedStatement = connection.prepareStatement("delete from  administrator where login = ?");
            preparedStatement.setString(1, login);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            log.error("Admin deleting error!");
        }
        log.info("Administrators was obtained.");
    }
}
