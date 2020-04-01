package services.client;

import UI.menues.client.ClientRegistration;
import dao.ClientsDAO;

import java.io.IOException;

public class ClientRegistrationService{
    public void clientRegistration() throws IOException {
        ClientRegistration clientRegistration = new ClientRegistration();
        ClientsDAO clientsDAO = new ClientsDAO();
        clientsDAO.clientAdding(clientRegistration.registration());
        System.out.println("You successfully registered!");
    }
}
