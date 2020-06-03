package by.epam.hotelreservation.controller;

import by.epam.hotelreservation.dao.AdministratorsDAO;
import by.epam.hotelreservation.domain.Administrator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @GetMapping
    public ResponseEntity<ArrayList<Administrator>> getAdminList(){
        try {
            return ResponseEntity.ok(new AdministratorsDAO().adminReading());
        } catch (IOException e) {
            return ResponseEntity.ok(new ArrayList<Administrator>());
        }
    }

    @GetMapping("{login}")
    public ResponseEntity<Administrator> getAdmin(@PathVariable("login") String adminLogin){
        Administrator administrator = new AdministratorsDAO().adminReading(adminLogin);
        if (administrator.getLogin() != null){
            return ResponseEntity.ok(administrator);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> addAdmin(@RequestBody Map<String, String> request) throws IOException {
        String firstName = "";
        String secondName = "";
        int age = -1;
        String login = "";
        String password = "";
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
        new AdministratorsDAO().adminAdding(new Administrator(firstName, secondName, age, login, password));
        return new ResponseEntity<>("Add Success", HttpStatus.OK);
    }

    @PutMapping("{login}")
    public ResponseEntity<String> changeAdmin(@RequestBody Map<String, String> request, @PathVariable("login") String login) {
        Administrator administrator = new AdministratorsDAO().adminReading(login);
        try{
            if (administrator == null){
                return new ResponseEntity<>("Error: couldn't get admin with this login", HttpStatus.NOT_ACCEPTABLE);
            }
            String firstName = request.get("firstName");
            if (firstName != null){
                administrator.setFirstName(firstName);
            }

            String secondName = request.get("secondName");
            if (secondName != null){
                administrator.setSecondName(secondName);
            }

            int age = Integer.parseInt(request.get("age"));
            if (age >= 0){
                administrator.setAge(age);
            }
            new AdministratorsDAO().adminUpdating(administrator);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Update Success", HttpStatus.OK);
    }

    @DeleteMapping("{login}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("login") String login) throws IOException {
        Administrator administrator = new AdministratorsDAO().adminReading(login);
        if (administrator == null){
            return new ResponseEntity<>("Error: couldn't get admin with this login", HttpStatus.NOT_ACCEPTABLE);
        }

        AdministratorsDAO administratorsDAO = new AdministratorsDAO();
        ArrayList<Administrator> administrators = administratorsDAO.adminReading();
        for(int i = 0; i < administrators.size(); i++) {
            if (administrators.get(i).getLogin().equals(login)) {
                administratorsDAO.adminDeleting(login);
            }
        }
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
