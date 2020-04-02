package service;

import domain.Aircraft;
import service.array.ArrayCreating;

import java.util.Arrays;
import java.util.stream.Stream;

public class OneOwnerCheck {
    public void oneOwnerChecking(){
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        aircraftStream.filter((aircraft)->aircraft.getStores().size() == 1).forEach(aircraft -> System.out.println(aircraft.toString()));
    }

    public void oneOwnerCheckingTrueOrNot(){
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        if(!aircraftStream.filter((aircraft)->aircraft.getStores().size() == 1).findFirst().isPresent()){
            System.out.println("There are no aircrafts with one owner.");
        } else System.out.println("There are aircrafts with one owner.");
    }
}
