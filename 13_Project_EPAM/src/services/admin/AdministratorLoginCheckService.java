package services.admin;

import domain.Administrator;

import java.util.List;

public class AdministratorLoginCheckService {
    public static int listChecking(String login, String password, List<Administrator> administrators){
        int num = -1;
        for(int i = 0; i < administrators.size(); i++){
            if(administrators.get(i).getLogin().equals(login) && administrators.get(i).getPassword().equals(password)){
                num = i;
            }
        }
        return num;
    }

    public static int elementChecking(int num, List<Administrator> administrators, String login, String password){
        if(num < 0){
            System.out.println("Login or password is incorrect!");
            return num;
        }
        else{
            System.out.println("You successfully logged as " + administrators.get(num).getFirstName() + " " + administrators.get(num).getSecondName() + "!");
            return num;
        }
    }
}
