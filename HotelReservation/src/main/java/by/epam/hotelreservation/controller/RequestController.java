package by.epam.hotelreservation.controller;

import by.epam.hotelreservation.dao.RequestsDAO;
import by.epam.hotelreservation.domain.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("api/request")
public class RequestController {

    @GetMapping
    public ResponseEntity<ArrayList<Request>> getRequestList(){
        try {
            return ResponseEntity.ok(new RequestsDAO().requestReading());
        } catch (IOException e) {
            return ResponseEntity.ok(new ArrayList<Request>());
        }
    }

    @GetMapping("{requestId}")
    public ResponseEntity<Request> getRequest(@PathVariable("requestId") int requestLogin){
        Request request = new RequestsDAO().requestReading(requestLogin);
        if (request.getRequestId() != 0){
            return ResponseEntity.ok(request);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> addRequest(@RequestBody Map<String, String> request) throws IOException {
        int roomsAmount = 0;
        int comfortLevel = 0;
        int requestId = 0;
        int price = 0;
        int daysAmount = 0;
        try {
            roomsAmount = Integer.parseInt(request.get("roomsAmount"));
            comfortLevel = Integer.parseInt(request.get("comfortLevel"));
            requestId = Integer.parseInt(request.get("requestId"));
            price = Integer.parseInt(request.get("price"));
            daysAmount = Integer.parseInt(request.get("daysAmount"));
        }
        catch (NumberFormatException e){
            e.printStackTrace();
            return new ResponseEntity<>("Error: incorrect variables", HttpStatus.BAD_REQUEST);
        }
        new RequestsDAO().requestAdding(new Request(roomsAmount, comfortLevel, requestId, price, daysAmount));
        return new ResponseEntity<>("Add Success", HttpStatus.OK);
    }

    @PutMapping("{requestId}")
    public ResponseEntity<String> changeRequest(@RequestBody Map<String, String> request, @PathVariable("requestId") int requestId) {
        Request request1 = new RequestsDAO().requestReading(requestId);
        try{
            if (request1 == null){
                return new ResponseEntity<>("Error: couldn't get admin with this login", HttpStatus.NOT_ACCEPTABLE);
            }

            int roomsAmount = Integer.parseInt(request.get("roomsAmount"));
            if (roomsAmount != 0){
                request1.setRoomsAmount(roomsAmount);
            }

            int comfortLevel = Integer.parseInt(request.get("comfortLevel"));
            if (comfortLevel != 0){
                request1.setComfortLevel(comfortLevel);
            }

            int price = Integer.parseInt(request.get("price"));
            if (price != 0){
                request1.setPrice(price);
            }

            int daysAmount = Integer.parseInt(request.get("daysAmount"));
            if (daysAmount != 0){
                request1.setDaysAmount(daysAmount);
            }
            new RequestsDAO().requestUpdating(request1);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Update Success", HttpStatus.OK);
    }

    @DeleteMapping("{requestId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("requestId") int requestId) throws IOException {
        Request request = new RequestsDAO().requestReading(requestId);
        if (request == null){
            return new ResponseEntity<>("Error: couldn't get admin with this login", HttpStatus.NOT_ACCEPTABLE);
        }

        RequestsDAO requestsDAO = new RequestsDAO();
        ArrayList<Request> requests = requestsDAO.requestReading();
        for(int i = 0; i < requests.size(); i++) {
            if (requests.get(i).getRequestId() == requestId) {
                requestsDAO.requestDeleting(requests.get(i));
            }
        }
        return new ResponseEntity<>("Delete Success", HttpStatus.OK);
    }
}
