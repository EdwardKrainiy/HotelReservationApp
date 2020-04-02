package service;

import domain.Aircraft;
import service.array.ArrayCreating;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class AircraftCapacitySort {
    public void aircraftCapacitySorting(){
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        aircraftStream.sorted(Comparator.comparingInt(aircraft -> aircraft.getCapacity())).forEach(aircraft -> System.out.println(aircraft.toString()));
    }
}
