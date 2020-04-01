package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAO{

    final static Logger log = LogManager.getLogger(ClientsDAO.class);

    public void clientAdding(Client c1) throws IOException {
        List<Client> clients = clientReading();
        int ind = 0;
        for(int i = 0; i < clients.size(); i++){
            if(clients.get(i).getLogin().equals(c1.getLogin())){
                ind++;
            }
        }
        if(ind > 0){
            System.out.println("This client is already registered!");
        } else {
            c1.setId(clients.size());
            clients.add(c1);
        }
        clientRewriting(clients);
        log.info("Client was added.");
    }

    public List clientReading() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Client> clients = new ArrayList<>();
        clients =  mapper.readValue(new File("resources\\clients.json"),  new TypeReference<List<Client>>(){});
        log.info("Clients was obtained.");
        return clients;
    }

    public void clientRewriting(List<Client> clients) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("resources\\clients.json"), clients);
        log.info("Clients was changed.");
    }
}
