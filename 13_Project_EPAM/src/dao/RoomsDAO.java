package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Room;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RoomsDAO{
    public static void roomAdding(Room r1) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    List<Room> rooms = new ArrayList<Room>();
    rooms = mapper.readValue(new File("resources\\rooms.json"),  new TypeReference<List<Room>>(){});
    rooms.add(r1);
    mapper.writeValue(new File("resources\\rooms.json"),  rooms);
}

    public static List roomReading() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Room> rooms = new ArrayList<>();
        rooms =  mapper.readValue(new File("resources\\rooms.json"),  new TypeReference<List<Room>>(){});
        return rooms;
    }

    public static void roomRewriting(List<Room> r1) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Room> rooms = r1;
        mapper.writeValue(new File("resources\\rooms.json"),  rooms);
    }
}
