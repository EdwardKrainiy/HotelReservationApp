package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestsDAO{

    final static Logger log = LogManager.getLogger(RequestsDAO.class);

    public void requestAdding(Request r1) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Request> requests = new ArrayList<Request>();
        requests = mapper.readValue(new File("resources\\requests.json"),  new TypeReference<List<Request>>(){});
        requests.add(r1);
        mapper.writeValue(new File("resources\\requests.json"),  requests);
        log.info("Request was added.");
    }

    public List requestReading() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Request> requests = new ArrayList<>();
        requests =  mapper.readValue(new File("resources\\requests.json"),  new TypeReference<List<Request>>(){});
        log.info("Requests was obtained.");
        return requests;
    }

    public void requestRewriting(List<Request> r1) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Request> requests = r1;
        mapper.writeValue(new File("resources\\requests.json"),  requests);
        log.info("Requests was changed.");
    }
}
