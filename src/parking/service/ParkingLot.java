package parking.service;

import parking.test.ParkingScenarioRunner;
import parking.model.*;

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

    public boolean areMotorcycleSpotsFull() {
        return occupiedMotorcycleSpots >= totalMotorcycleSpots;
    }

    public boolean areCarSpotsFull() {
        return occupiedCarSpots >= totalCarSpots;
    }

    public boolean areLargeSpotsFull() {
        return occupiedLargeSpots >= totalLargeSpots;
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
    public void printSpotStatus() {
        System.out.println("Total Spots: " + getTotalSpots());
        System.out.println("Remaining Spots: " + getRemainingSpots());
        System.out.println("Motorcycle Spots occupied: " + getOccupiedMotorcycleSpots() + " / " + getTotalMotorcycleSpots());
        System.out.println("Car Spots occupied: " + getOccupiedCarSpots() + " / " + getTotalCarSpots());
        System.out.println("Large Spots occupied: " + getOccupiedLargeSpots() + " / " + getTotalLargeSpots());
        System.out.println("Van Occupied Spots: " + vanOccupiedSpots);
    }

    public void printLotStatus() {
        System.out.println("\nLot full? " + (isFull() ? "Yes" : "No"));
        System.out.println("Lot empty? " + (isEmpty() ? "Yes" : "No"));
        System.out.println("Are the motorcycle spots full? " + (areMotorcycleSpotsFull() ? "Yes" : "No"));
        System.out.println("Are the car spots full? " + (areCarSpotsFull() ? "Yes" : "No"));
        System.out.println("Are the large spots full? " + (areLargeSpotsFull() ? "Yes" : "No"));
        System.out.println("Spots occupied by vans: " + getVanOccupiedSpots());
    }

}
