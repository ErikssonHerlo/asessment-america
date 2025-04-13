# Java Technical Assessment

---
## Parking Lot System
This project simulates a parking lot system that manages different types of vehicles and parking spots. It was developed as part of a technical Java assessment, with a strong focus on **object-oriented programming (OOP)** principles, **clean architecture**, and **best practices** in software design.

---

## 📁 Project Structure

```
src/
├── parking/
│   ├── model/                  # Vehicle classes and result model
│   │   ├── Vehicle.java
│   │   ├── Motorcycle.java
│   │   ├── Car.java
│   │   ├── Van.java
│   │   └── ParkingResult.java
│   ├── service/
│   │   └── ParkingLot.java     # Core business logic of the parking lot
│   ├── test/
│   │   └── ParkingScenarioRunner.java  # Scenario execution engine
│   └── ParkingLotTestLauncher.java     # Entry point for test scenarios
```

---

## 🚗 Supported Vehicle Types

| Vehicle Type | Allowed Spots (in order of priority)               |
|--------------|----------------------------------------------------|
| Motorcycle   | Motorcycle spot → Car spot → Large spot            |
| Car          | Car spot → Large spot                              |
| Van          | Large spot → 3 Car spots                           |

Each vehicle has a unique identifier (e.g., `Van-1`, `Car-3`) to improve traceability during scenario logging and debugging.

---

## ✅ Main Features

- Flexible vehicle placement based on available spots.
- Polymorphic delegation of parking behavior to each vehicle class.
- Clean and readable logging of all parking attempts.
- Centralized state tracking within the `ParkingLot` class.
- Complete test coverage with multiple realistic parking scenarios.
- Designed following **SOLID principles**:
  - **S**: Each class has a single responsibility.
  - **O**: Easily extendable for new vehicle types.
  - **L**: Vehicles can override behavior safely.
  - **I**: No unnecessary dependencies.
  - **D**: High-level modules depend on abstractions (`Vehicle`).

---

## 🧪 Implemented Scenarios

The following scenarios are included for demonstration and validation:

- Scenario 1: Basic parking (mixed vehicles)
- Scenario 2: Full parking lot
- Scenario 3: Only motorcycles
- Scenario 4: Only cars
- Scenario 5: Only vans
- Scenario 6: Mixed overflow

Each scenario prints the initial and final state of the parking lot, vehicle-by-vehicle decisions, and a summary of any vehicles that could not be parked.

---

## 🔧 How to Run

### Requirements
- Java 17 or higher
- Any Java IDE (e.g., IntelliJ IDEA, Eclipse) or CLI compiler (e.g., `javac`, `java`)

### Run the simulation

Execute the following file to run all scenarios:

```
src/parking/ParkingLotTestLauncher.java
```

This will trigger all parking tests and print detailed logs to the console.

---

## 💡 Technical Highlights

- Vehicles encapsulate their own parking rules via `tryPark(ParkingLot lot)`.
- All parking outcomes are returned as a `ParkingResult` object (boolean + message).
- The `ParkingLot` class strictly manages the state — no scenario logic is embedded inside.
- Parking tests are isolated in the `test` package for separation of concerns.
- Console output clearly communicates all decisions and system status.

---

## 👤 Author

This project was developed by **Eriksson Hernández** as part of a technical challenge.

📧 **Contact**: erikssonhernandez25@gmail.com

---