package parking.test;

import parking.model.*;
import parking.service.ParkingLot;

import java.util.ArrayList;
import java.util.List;

/**
 * Runs parking lot test scenarios and prints detailed results.
 */
public class ParkingScenarioRunner {

    public static void runScenario(String name, ParkingLot lot, List<Vehicle> vehicles) {
        List<Vehicle> failed = new ArrayList<>();

        System.out.println("============== " + name + " ==============");
        System.out.println("Initial status:");
        lot.printSpotStatus();
        System.out.println();

        for (Vehicle v : vehicles) {
            System.out.println("Parking " + v.getId() + " (" + v.getVehicleType() + ")...");
            ParkingResult result = v.tryPark(lot);
            System.out.println("-> " + result.message);
            if (!result.parked) {
                failed.add(v);
            }
        }

        System.out.println("\nStatus after parking vehicles:");
        lot.printSpotStatus();
        lot.printLotStatus();

        if (!failed.isEmpty()) {
            System.out.println("\nVehicles that could not be parked:");
            for (Vehicle v : failed) {
                System.out.println("- " + v.getId() + " (" + v.getVehicleType() + ")");
            }
        }

        System.out.println();
    }
}
