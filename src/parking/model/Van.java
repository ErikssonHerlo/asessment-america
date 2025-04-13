package parking.model;

import parking.ParkingLot;
import parking.ParkingResult;

/**
 * Represents a van which requires either one large spot or three car spots.
 */
public class Van extends Vehicle {
    private static int count = 0;

    public Van() {
        super("Van-" + (++count));
        this.spotsNeeded = 3;
        this.vehicleType = "Van";
    }

    @Override
    public ParkingResult tryPark(ParkingLot lot) {
        if (lot.hasAvailableLargeSpot()) {
            lot.incrementLarge();
            lot.incrementVan(1);
            return new ParkingResult(true, "Van parked in large spot.");
        }
        if (lot.availableCarSpots() >= 3) {
            lot.incrementCar(3);
            lot.incrementVan(3);
            return new ParkingResult(true, "Van parked using 3 car spots (no large spots available).");
        }
        return new ParkingResult(false, "No available spot for van.");
    }
}