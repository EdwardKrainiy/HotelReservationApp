package service.array;

import domain.Aircraft;
import domain.Owner;

import java.util.Arrays;
import java.util.List;

public class ArrayCreating {

    public static Owner[] ownerCreating(){
        Owner owner1 = new Owner("PlanesAndBirdsCO", "Moscow");
        Owner owner2 = new Owner("AircraftProBros", "Minsk");
        Owner owner3 = new Owner("BrothersZeppelin", "Tokyo");
        Owner owner4 = new Owner("FlyTogether", "Moscow");
        Owner owner5 = new Owner("FlightsAndLights", "London");
        Owner owner6 = new Owner("SunnyTravel", "Brazilia");

        Owner[] owners = {owner1, owner2, owner3, owner4, owner5, owner6};
        return owners;
    }

    public static Aircraft[] aircraftCreating() {
        Owner[] owners = ownerCreating();

        List<Owner> ownerArray1 = Arrays.asList(owners[0]);
        List<Owner> ownerArray2 = Arrays.asList(owners[1], owners[2], owners[5]);
        List<Owner> ownerArray3 = Arrays.asList(owners[3]);
        List<Owner> ownerArray4 = Arrays.asList(owners[2], owners[3], owners[5]);
        List<Owner> ownerArray5 = Arrays.asList(owners[4]);

        Aircraft aircraft1 = new Aircraft("AirFlightCO", 3500, 150, ownerArray1);
        Aircraft aircraft2 = new Aircraft("OxygenLines", 4200, 190, ownerArray2);
        Aircraft aircraft3 = new Aircraft("BirdOlympus", 3200, 130, ownerArray3);
        Aircraft aircraft4 = new Aircraft("EmpireFlight", 4500, 270, ownerArray4);
        Aircraft aircraft5 = new Aircraft("DoDoPlanes", 2700, 140, ownerArray5);

        return new Aircraft[]{aircraft1, aircraft2, aircraft3, aircraft4, aircraft5};
    }
}
