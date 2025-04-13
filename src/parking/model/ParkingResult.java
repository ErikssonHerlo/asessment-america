package parking.model;

/**
 * Represents the result of attempting to park a vehicle.
 * This class encapsulates the outcome of a parking attempt,
 * indicating whether the vehicle was successfully parked
 * and providing a message with details about the attempt.
 */
public class ParkingResult {
    public final boolean parked;
    public final String message;

    public ParkingResult(boolean parked, String message) {
        this.parked = parked;
        this.message = message;
    }
}
