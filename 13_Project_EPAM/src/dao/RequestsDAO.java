package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Request;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RequestsDAO{
    public static void requestAdding(Request r1) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Request> requests = new ArrayList<Request>();
        requests = mapper.readValue(new File("resources\\requests.json"),  new TypeReference<List<Request>>(){});
        requests.add(r1);
        mapper.writeValue(new File("resources\\requests.json"),  requests);
    }

    public static List requestReading() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Request> requests = new ArrayList<>();
        requests =  mapper.readValue(new File("resources\\requests.json"),  new TypeReference<List<Request>>(){});
        return requests;
    }

    public static void requestRewriting(List<Request> r1) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Request> requests = r1;
        mapper.writeValue(new File("resources\\requests.json"),  requests);
    }
}
