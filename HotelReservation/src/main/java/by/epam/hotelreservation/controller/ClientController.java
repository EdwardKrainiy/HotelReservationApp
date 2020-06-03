package by.epam.hotelreservation.controller;


import by.epam.hotelreservation.dao.ClientsDAO;
import by.epam.hotelreservation.domain.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @GetMapping
    public ResponseEntity<ArrayList<Client>> getFlightList(){
        try {
            return ResponseEntity.ok(new ClientsDAO().clientReading());
        } catch (IOException e) {
            return ResponseEntity.ok(new ArrayList<Client>());
        }
    }
}
