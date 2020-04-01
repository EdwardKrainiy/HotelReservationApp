package services.admin;

import domain.Administrator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AdministratorLoginCheckService {

    final static Logger log = LogManager.getLogger(AdministratorLoginCheckService.class);

    public int listChecking(String login, String password, List<Administrator> administrators){
        int num = -1;
        for(int i = 0; i < administrators.size(); i++){
            if(administrators.get(i).getLogin().equals(login) && administrators.get(i).getPassword().equals(password)){
                num = i;
            }
        }
        return num;
    }

    public int elementChecking(int num, List<Administrator> administrators, String login, String password){
        if(num < 0){
            System.out.println("Login or password is incorrect!");
            log.info("Incorrect values for log to admin account.");
            return num;
        }
        else{
            System.out.println("You successfully logged as " + administrators.get(num).getFirstName() + " " + administrators.get(num).getSecondName() + "!");
            log.info("Successful log to admin account.");
            return num;
        }
    }
}
