package service;

import domain.Aircraft;
import service.array.ArrayCreating;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaximalCapacityCheck {
    public void maxCapacityChecking(){
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        System.out.println(aircraftStream.max(Aircraft::compare).get().toString());
    }
}
