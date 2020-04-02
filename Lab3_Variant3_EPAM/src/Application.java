
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.*;
import service.array.ArrayCreating;

import java.util.Arrays;

public class Application {

    final static Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) throws Exception {

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        CapacityCheck capacityCheck =  new CapacityCheck();
        capacityCheck.capacityChecking();
        log.info("Showed aircraft with capacity more than 200.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Aircraft with minimal capacity: ");
        MinimalCapacityCheck minimalCapacityCheck = new MinimalCapacityCheck();
        minimalCapacityCheck.minCapacityChecking();
        log.info("Showed aircrafts with minimal capacity.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Aircraft with maximal capacity: ");
        MaximalCapacityCheck maximalCapacityCheck = new MaximalCapacityCheck();
        maximalCapacityCheck.maxCapacityChecking();
        log.info("Showed aircrafts with maximal capacity.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        OneOwnerCheck oneOwnerCheck = new OneOwnerCheck();
        oneOwnerCheck.oneOwnerCheckingTrueOrNot();

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Aircrafts with only one owner: ");
        oneOwnerCheck.oneOwnerChecking();
        log.info("Showed aircrafts with only one owner.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Aircrafts, sorted by price: ");
        AircraftPriceSort aircraftPriceSort = new AircraftPriceSort();
        aircraftPriceSort.aircraftPriceSorting();
        log.info("Aircrafts, sorted by price.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Aircrafts, sorted by capacity: ");
        AircraftCapacitySort aircraftCapacitySort = new AircraftCapacitySort();
        aircraftCapacitySort.aircraftCapacitySorting();
        log.info("Aircrafts, sorted by capacity.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("Owner lists of aircrafts: ");
        OwnerListOutput ownerListOutput = new OwnerListOutput();
        ownerListOutput.ownerListOutputting();
        log.info("Showed owner lists of aircrafts.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.println("All owners without duplicates: ");
        OwnerListNoDuplicates ownerListNoDuplicates = new OwnerListNoDuplicates();
        ownerListNoDuplicates.noDuplicatesOwnerShowing();
        log.info("Showed owner list without duplicates.");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");

    }
}
