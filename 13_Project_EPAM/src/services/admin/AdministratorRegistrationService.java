package services.admin;

import UI.menues.admin.AdministratorRegistration;
import dao.AdministratorsDAO;

import java.io.IOException;

public class AdministratorRegistrationService {
    public void administratorRegistration() throws IOException {
        AdministratorRegistration administrator = new AdministratorRegistration();
        AdministratorsDAO administratorsDAO = new AdministratorsDAO();
        administratorsDAO.adminAdding(administrator.registration());
        System.out.println("You successfully registered!");
    }
}
