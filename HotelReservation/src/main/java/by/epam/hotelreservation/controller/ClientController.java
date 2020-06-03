package by.epam.hotelreservation.controller;


import by.epam.hotelreservation.dao.ClientsDAO;
import by.epam.hotelreservation.domain.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("api/client")
public class ClientController {

    @GetMapping
    public ResponseEntity<ArrayList<Client>> getClientList(){
        try {
            return ResponseEntity.ok(new ClientsDAO().clientReading());
        } catch (IOException e) {
            return ResponseEntity.ok(new ArrayList<Client>());
        }
    }

    @GetMapping("{login}")
    public ResponseEntity<Client> getClient(@PathVariable("login") String clientLogin){
        Client client = new ClientsDAO().clientReading(clientLogin);
        if (client.getLogin() != null){
            return ResponseEntity.ok(client);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody Map<String, String> request) throws IOException {
        String firstName = "";
        String secondName = "";
        int age = -1;
        String login = "";
        String password = "";
        int cost = 0;
        int id = -1;
        try {
            firstName = request.get("firstName");
            secondName = request.get("secondName");
            age = Integer.parseInt(request.get("age"));
            login = request.get("login");
            password = request.get("password");
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            return new ResponseEntity<>("Error: incorrect variables", HttpStatus.BAD_REQUEST);
        }
        new ClientsDAO().clientAdding(new Client(firstName, secondName, age, login, password, cost, id));
        return new ResponseEntity<>("Add Success", HttpStatus.OK);
    }

    @PutMapping("{login}")
    public ResponseEntity<String> changeClient(@RequestBody Map<String, String> request, @PathVariable("login") String login) {
        Client client1 = new ClientsDAO().clientReading(login);
        try{
            if (client1 == null){
                return new ResponseEntity<>("Error: couldn't get client with this login", HttpStatus.NOT_ACCEPTABLE);
            }
            String firstName = request.get("firstName");
            if (firstName != null){
                client1.setFirstName(firstName);
            }

            String secondName = request.get("secondName");
            if (secondName != null){
                client1.setSecondName(secondName);
            }

            int age = Integer.parseInt(request.get("age"));
            if (age >= 0){
                client1.setAge(age);
            }
            new ClientsDAO().clientUpdating(client1);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Update Success", HttpStatus.OK);
    }

    @DeleteMapping("{login}")
    public ResponseEntity<String> deleteClient(@PathVariable("login") String login) throws IOException {
        Client client = new ClientsDAO().clientReading(login);
        if (client == null){
            return new ResponseEntity<>("Error: couldn't get client with this login", HttpStatus.NOT_ACCEPTABLE);
        }

        ClientsDAO clientsDAO = new ClientsDAO();
        ArrayList<Client> clients = clientsDAO.clientReading();
        for(int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getLogin().equals(login)) {
                clientsDAO.clientDeleting(login);
            }
        }
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
