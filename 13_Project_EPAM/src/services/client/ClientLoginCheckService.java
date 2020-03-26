package services.client;

import domain.Client;

import java.util.List;

public class ClientLoginCheckService {
    public static int listChecking(String login, String password, List<Client> clients){
        int number = -1;
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getLogin().equals(login) && clients.get(i).getPassword().equals(password)){
                number = i;
            }
        }
        return number;
    }

    public static int elementChecking(int number, List<Client> clients, String login, String password){
        if(number < 0){
            System.out.println("Login or password is incorrect!");
            return number;
        }
        if(clients.get(number).getLogin().equals(login) && clients.get(number).getPassword().equals(password)){
            System.out.println("You successfully logged as " + clients.get(number).getFirstName() + " " + clients.get(number).getSecondName() + "!");
            return number;
        }
        return number;
    }
}
