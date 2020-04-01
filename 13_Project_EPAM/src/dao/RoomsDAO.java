package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO{

    final static Logger log = LogManager.getLogger(RoomsDAO.class);

    public void roomAdding(Room r1) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    List<Room> rooms = new ArrayList<Room>();
    rooms = mapper.readValue(new File("resources\\rooms.json"),  new TypeReference<List<Room>>(){});
    rooms.add(r1);
    mapper.writeValue(new File("resources\\rooms.json"),  rooms);
    log.info("Room was added.");
}

    public List roomReading() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Room> rooms = new ArrayList<>();
        rooms =  mapper.readValue(new File("resources\\rooms.json"),  new TypeReference<List<Room>>(){});
        log.info("Rooms was obtained.");
        return rooms;
    }

    public void roomRewriting(List<Room> r1) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Room> rooms = r1;
        mapper.writeValue(new File("resources\\rooms.json"),  rooms);
        log.info("Rooms was changed.");
    }
}
