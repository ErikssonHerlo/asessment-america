import parking.ParkingLotTestLauncher;
import quadruplet.QuadrupletTestRunner;
import quickselect.QuickselectTestRunner;

/**
 * Entry point for running all Java assessment modules:
 * - Parking Lot System
 * - QuadrupletSum Algorithm
 * - Quickselect Algorithm
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("========== JAVA TECHNICAL ASSESSMENT ==============\n");

            System.out.println("Running Parking Lot Simulation\n");
            System.out.println("------------------------------------------");
            ParkingLotTestLauncher.main(args);

            System.out.println("\nRunning QuadrupletSum Tests\n");
            System.out.println("------------------------------------------");
            QuadrupletTestRunner.main(args);

            System.out.println("\nRunning Quickselect Tests\n");
            System.out.println("------------------------------------------");
            QuickselectTestRunner.main(args);

            System.out.println("\nAll modules executed successfully.");
        } catch (Exception e) {
            System.err.println("Error running modules: " + e.getMessage());
        }
    }
}
