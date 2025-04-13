package parking.model;

import parking.ParkingLot;
import parking.ParkingResult;

/**
 * Represents a car which requires one car spot or large spot.
 */
public class Car extends Vehicle {
    private static int count = 0;

    public Car() {
        super("Car-" + (++count));
        this.spotsNeeded = 1;
        this.vehicleType = "Car";
    }

    @Override
    public ParkingResult tryPark(ParkingLot lot) {
        if (lot.hasAvailableCarSpot()) {
            lot.incrementCar();
            return new ParkingResult(true, "Parked in car spot.");
        }
        if (lot.hasAvailableLargeSpot()) {
            lot.incrementLarge();
            return new ParkingResult(true, "Car parked in large spot (car spots full).");
        }
        return new ParkingResult(false, "No available spot for car.");
    }
}