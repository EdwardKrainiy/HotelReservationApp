package service;

import domain.Aircraft;
import service.array.ArrayCreating;

import java.util.Arrays;
import java.util.stream.Stream;

public class OwnerListOutput {
    public void ownerListOutputting(){
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        aircraftStream.forEach(aircraft -> System.out.println(aircraft.getStores()));
    }
}
