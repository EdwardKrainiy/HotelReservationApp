package services.client;

import UI.menues.client.ClientRegistration;
import dao.ClientsDAO;
import domain.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientRegistrationService{
    public void clientRegistration() throws IOException {
        ClientRegistration clientRegistration = new ClientRegistration();
        ClientsDAO clientsDAO = new ClientsDAO();
        List<Client> clients = new ArrayList<>();
        clients = clientsDAO.clientReading();
        Client c1 = clientRegistration.registration();
        int ind = 0;
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getLogin().equals(c1.getLogin())){
                ind++;
            }
        }
        if(ind > 0){
            System.out.println("This client already registered!");
        }
        else
        {
            clientsDAO.clientAdding(c1);
            System.out.println("You successfully registered!");
        }
    }
}
