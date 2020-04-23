package services.admin;

import UI.menues.admin.AdministratorRegistration;
import dao.AdministratorsDAO;
import domain.Administrator;
import domain.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorRegistrationService {
    public void administratorRegistration() throws IOException {
        AdministratorRegistration administrator = new AdministratorRegistration();
        AdministratorsDAO administratorsDAO = new AdministratorsDAO();
        List<Administrator> administrators = new ArrayList<>();
        administrators = administratorsDAO.adminReading();
        Administrator a1 = administrator.registration();
        int ind = 0;
        for(int i = 0; i < administrators.size() ; i++){
            if(administrators.get(i).getLogin().equals(a1.getLogin())){
                ind++;
            }
        }
        if(ind > 0){
            System.out.println("This administrator already registered!");
        }
        else
        {
            administratorsDAO.adminAdding(a1);
            System.out.println("You successfully registered!");
        }
    }
}
