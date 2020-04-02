package service;

import domain.Aircraft;
import service.array.ArrayCreating;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class AircraftPriceSort {
    public void aircraftPriceSorting(){
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        aircraftStream.sorted(Comparator.comparingInt(Aircraft::getPrice)).forEach(aircraft -> System.out.println(aircraft.toString()));
    }
}
