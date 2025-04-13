package parking;

import parking.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a parking lot with multiple types of spots.
 */
public class ParkingLot {

    private int totalMotorcycleSpots;
    private int totalCarSpots;
    private int totalLargeSpots;

    private int occupiedMotorcycleSpots = 0;
    private int occupiedCarSpots = 0;
    private int occupiedLargeSpots = 0;
    private int vanOccupiedSpots = 0;

    public ParkingLot(int motorcycleSpots, int carSpots, int largeSpots) {
        this.totalMotorcycleSpots = motorcycleSpots;
        this.totalCarSpots = carSpots;
        this.totalLargeSpots = largeSpots;
    }


    public int getTotalSpots() {
        return totalMotorcycleSpots + totalCarSpots + totalLargeSpots;
    }

    public int getRemainingSpots() {
        return (totalMotorcycleSpots - occupiedMotorcycleSpots)
                + (totalCarSpots - occupiedCarSpots)
                + (totalLargeSpots - occupiedLargeSpots);
    }

    public int getVanOccupiedSpots() {
        return vanOccupiedSpots;
    }

    public boolean isFull() {
        return getRemainingSpots() == 0;
    }

    public boolean isEmpty() {
        return (occupiedMotorcycleSpots == 0 && occupiedCarSpots == 0 && occupiedLargeSpots == 0);
    }

    public int getOccupiedMotorcycleSpots() {
        return occupiedMotorcycleSpots;
    }

    public int getOccupiedCarSpots() {
        return occupiedCarSpots;
    }

    public int getOccupiedLargeSpots() {
        return occupiedLargeSpots;
    }

    public int getTotalMotorcycleSpots() {
        return totalMotorcycleSpots;
    }

    public int getTotalCarSpots() {
        return totalCarSpots;
    }

    public int getTotalLargeSpots() {
        return totalLargeSpots;
    }

    private String areMotorcycleSpotsFull() {
        if (occupiedMotorcycleSpots == totalMotorcycleSpots) {
            return "Yes";
        } else {
            return "No";
        }
    }

    private String areCarSpotsFull() {
        if (occupiedCarSpots == totalCarSpots) {
            return "Yes";
        } else {
            return "No";
        }
    }

    private String areLargeSpotsFull() {
        if (occupiedLargeSpots == totalLargeSpots) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public boolean hasAvailableMotorcycleSpot() {
        return occupiedMotorcycleSpots < totalMotorcycleSpots;
    }
    public void incrementMotorcycle() {
        occupiedMotorcycleSpots++;
    }

    public boolean hasAvailableCarSpot() {
        return occupiedCarSpots < totalCarSpots;
    }
    public void incrementCar() {
        occupiedCarSpots++;
    }

    public void incrementCar(int spotsUsed) {
        occupiedCarSpots += spotsUsed;
    }

    public boolean hasAvailableLargeSpot() {
        return occupiedLargeSpots < totalLargeSpots;
    }
    public void incrementLarge() {
        occupiedLargeSpots++;
    }

    public void incrementVan(int spotsUsed) {
        vanOccupiedSpots += spotsUsed;
    }

    public int availableCarSpots() {
        return totalCarSpots - occupiedCarSpots;
    }


    /**
     * Prints the current status of the parking lot.
     */
    public void printStatus() {
        System.out.println("Total Spots: " + getTotalSpots());
        System.out.println("Remaining Spots: " + getRemainingSpots());
        System.out.println("Motorcycle Spots occupied: " + occupiedMotorcycleSpots + " / " + totalMotorcycleSpots);
        System.out.println("Car Spots occupied: " + occupiedCarSpots + " / " + totalCarSpots);
        System.out.println("Large Spots occupied: " + occupiedLargeSpots + " / " + totalLargeSpots);
        System.out.println("Van Occupied Spots: " + vanOccupiedSpots);
    }

    /**
     * Runs different parking scenarios and prints the results.
     */
    public static void main(String[] args) {
        System.out.println("===== SCENARIO #1: Basic parking =====");
        runScenario(
                new ParkingLot(5, 10, 3),
                List.of(
                        new Motorcycle(),
                        new Car(),
                        new Van(),
                        new Van()
                )
        );

        System.out.println("\n===== SCENARIO #2: Full lot test =====");
        runScenario(
                new ParkingLot(1, 3, 1),
                List.of(
                        new Motorcycle(),
                        new Motorcycle(),
                        new Car(),
                        new Van(),
                        new Van(),
                        new Car()
                )
        );

        System.out.println("\n===== SCENARIO #3: Only motorcycles =====");
        runScenario(
                new ParkingLot(2, 1, 0),
                List.of(
                        new Motorcycle(),
                        new Motorcycle(),
                        new Motorcycle()
                )
        );

        System.out.println("\n===== SCENARIO #4: Only cars =====");
        runScenario(
                new ParkingLot(0, 4, 1),
                List.of(
                        new Car(), new Car(), new Car(), new Car(), new Car()
                )
        );

        System.out.println("\n===== SCENARIO #5: Only vans =====");
        runScenario(
                new ParkingLot(0, 6, 1),
                List.of(
                        new Van(), new Van(), new Van()
                )
        );

        System.out.println("\n===== SCENARIO #6: Mixed overflow =====");
        runScenario(
                new ParkingLot(1, 1, 1),
                List.of(
                        new Motorcycle(), new Motorcycle(),
                        new Car(), new Car(),
                        new Van(), new Van()
                )
        );
    }

    /**
     * Runs a scenario by attempting to park all vehicles and printing the full process and summary.
     */
    private static void runScenario(ParkingLot lot, List<Vehicle> vehicles) {
        List<Vehicle> failed = new ArrayList<>();

        System.out.println("Initial status:");
        lot.printStatus();
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
        lot.printStatus();

        System.out.println("\nLot full? " + lot.isFull());
        System.out.println("Lot empty? " + lot.isEmpty());
        System.out.println("Are the motorcycle spots full? " + lot.areMotorcycleSpotsFull());
        System.out.println("Are the car spots full? " + lot.areCarSpotsFull());
        System.out.println("Are the large spots full? " + lot.areLargeSpotsFull());
        System.out.println("Spots occupied by vans: " + lot.getVanOccupiedSpots());

        if (!failed.isEmpty()) {
            System.out.println("\nVehicles that could not be parked:");
            for (Vehicle v : failed) {
                System.out.println("- " + v.getId() + " (" + v.getVehicleType() + ")");
            }
        }
    }

}
