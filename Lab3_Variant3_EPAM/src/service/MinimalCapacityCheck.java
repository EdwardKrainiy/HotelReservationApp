package service;

import domain.Aircraft;
import service.array.ArrayCreating;

import java.util.Arrays;
import java.util.stream.Stream;

public class MinimalCapacityCheck {
    public void minCapacityChecking() {
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        System.out.println(aircraftStream.min(Aircraft::compare).get().toString());
    }
}
