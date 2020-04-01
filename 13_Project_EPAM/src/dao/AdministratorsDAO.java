package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Administrator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdministratorsDAO{

final static Logger log = LogManager.getLogger(AdministratorsDAO.class);

    public void adminAdding(Administrator a1) throws IOException {
        List<Administrator> administrators = new ArrayList<>();
        administrators = adminReading();
        int ind = 0;
        for(int i = 0; i < administrators.size(); i++){
            if(administrators.get(i).getLogin().equals(a1.getLogin()) && administrators.get(i).getPassword().equals(a1.getPassword())){
                ind++;
            }
        }
        if(ind > 0){
            System.out.println("This administrator is already registered!");
        } else administrators.add(a1);
        adminRewriting(administrators);
        log.info("Administrator was adding.");
    }

    public List adminReading() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Administrator> administrators = new ArrayList<>();
        administrators =  mapper.readValue(new File("resources\\administrators.json"),  new TypeReference<List<Administrator>>(){});
        log.info("Administrators was obtained.");
        return administrators;
    }

    public void adminRewriting(List<Administrator> administrators) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("resources\\administrators.json"), administrators);
        log.info("Administrators was changed.");
    }
}
