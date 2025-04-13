package parking;

import parking.model.*;
import parking.service.ParkingLot;
import parking.test.ParkingScenarioRunner;

import java.util.List;

/**
 * Entry point for executing all parking lot test scenarios.
 */
public class ParkingLotTestLauncher {
    public static void main(String[] args) {
        ParkingScenarioRunner.runScenario(
                "Scenario #1: Basic parking",
                new ParkingLot(5, 10, 3),
                List.of(
                        new Motorcycle(),
                        new Car(),
                        new Van(),
                        new Van()
                )
        );

        ParkingScenarioRunner.runScenario(
                "Scenario #2: Full lot test",
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

        ParkingScenarioRunner.runScenario(
                "Scenario #3: Only motorcycles",
                new ParkingLot(2, 1, 0),
                List.of(
                        new Motorcycle(),
                        new Motorcycle(),
                        new Motorcycle()
                )
        );

        ParkingScenarioRunner.runScenario(
                "Scenario #4: Only cars",
                new ParkingLot(0, 4, 1),
                List.of(
                        new Car(), new Car(), new Car(), new Car(), new Car()
                )
        );

        ParkingScenarioRunner.runScenario(
                "Scenario #5: Only vans",
                new ParkingLot(0, 6, 1),
                List.of(
                        new Van(), new Van(), new Van()
                )
        );

        ParkingScenarioRunner.runScenario(
                "Scenario #6: Mixed overflow",
                new ParkingLot(1, 1, 1),
                List.of(
                        new Motorcycle(), new Motorcycle(),
                        new Car(), new Car(),
                        new Van(), new Van()
                )
        );
    }
}
