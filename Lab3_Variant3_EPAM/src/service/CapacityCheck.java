package service;

import domain.Aircraft;
import service.array.ArrayCreating;

import java.util.Arrays;
import java.util.stream.Stream;

public class CapacityCheck {
    public void capacityChecking(){
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        if(!aircraftStream.filter(aircraft -> aircraft.getCapacity() >=200).findFirst().isPresent()){
            System.out.println("There are no aircrafts with capacity more or equals 200");
        }
        else System.out.println("There is aircraft with capacity more than 200");
    }
}
