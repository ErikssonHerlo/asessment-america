package parking.model;

import parking.ParkingLot;
import parking.ParkingResult;

/**
 * Abstract representation of a vehicle.
 */

public abstract class Vehicle {
    protected int spotsNeeded;
    protected String vehicleType;
    protected String id;

    public Vehicle(String id) {
        this.id = id;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getId() {
        return id;
    }

    /**
     * Attempts to park the vehicle in the given parking lot.
     *
     * @param lot The parking lot where the vehicle is trying to park.
     * @return A ParkingResult indicating whether the vehicle was parked successfully or not.
     */
    public abstract ParkingResult tryPark(ParkingLot lot);
}

