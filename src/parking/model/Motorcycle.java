package parking.model;

import parking.service.ParkingLot;

/**
 * Represents a motorcycle which can fit in any type of spot.
 */
public class Motorcycle extends Vehicle {
    private static int count = 0;

    public Motorcycle() {
        super("Motorcycle-" + (++count));
        this.spotsNeeded = 1;
        this.vehicleType = "Motorcycle";
    }

    @Override
    public ParkingResult tryPark(ParkingLot lot) {
        if (lot.hasAvailableMotorcycleSpot()) {
            lot.incrementMotorcycle();
            return new ParkingResult(true, "Parked in motorcycle spot.");
        }
        if (lot.hasAvailableCarSpot()) {
            lot.incrementCar();
            return new ParkingResult(true, "Motorcycle parked in car spot (motorcycle spots full).");
        }
        if (lot.hasAvailableLargeSpot()) {
            lot.incrementLarge();
            return new ParkingResult(true, "Motorcycle parked in large spot (motorcycle & car spots full).");
        }
        return new ParkingResult(false, "❌ No available spot for motorcycle.");
    }
}