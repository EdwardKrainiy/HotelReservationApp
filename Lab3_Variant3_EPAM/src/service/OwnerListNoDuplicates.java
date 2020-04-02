package service;

import domain.Aircraft;
import domain.Owner;
import service.array.ArrayCreating;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class OwnerListNoDuplicates {
    public void noDuplicatesOwnerShowing(){
        Stream<Aircraft> aircraftStream = Arrays.stream(ArrayCreating.aircraftCreating());
        ArrayList<Owner> owners = new ArrayList<>();
        aircraftStream.forEach(aircraft -> owners.addAll(aircraft.getStores()));

        StringBuilder stringBuilder = new StringBuilder();
        owners.stream().distinct().forEach(owner -> stringBuilder.append(owner.toString()).append("\n"));
        System.out.println(stringBuilder.toString());

    }
}
