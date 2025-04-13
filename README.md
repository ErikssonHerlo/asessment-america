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

# 🔢 QuadrupletSum Algorithm - Java Implementation

This module efficiently solves the classic **4Sum problem**, finding any combination of four distinct integers in an array that sum to a given target value. Designed with clean architecture, high-performance techniques, and Java best practices, it leverages an optimized **O(n²)** approach.

---

## 📁 Project Structure

```
src/
└── quadruplet/
├── Quadruplet.java           # Domain model to represent a valid 4-number combination
├── QuadrupletFinder.java     # Core logic using a HashMap-based pair sum strategy (O(n²))
└── QuadrupletTestRunner.java # Test suite that runs and validates multiple scenarios
```

---

## 📌 Problem Definition

> Given an integer array `nums` and a target value `target`, determine whether there exists a quadruplet `{a, b, c, d}` such that:
>
> `a + b + c + d == target`

---

## 🚀 Optimized Algorithm (O(n²) using HashMap)

### 🧠 Strategy

1. **Build a map** of all pair sums in the array:
   ```
   sum -> list of (i, j)
   ```
2. **Iterate again** through all other pairs `(k, l)` and check if:
   ```
   (target - nums[k] - nums[l]) exists in map
   ```
3. Ensure all **four indices are unique**.

### 📈 Complexity

| Type        | Value       |
|-------------|-------------|
| Time        | O(n²)       |
| Space       | O(n²)       |
| Validated   | Yes (distinct indices and original values) |

---

## ✅ Example Output

```
Small testcase: ✅ PASSED in 1 ms → [2, 0, 5, 4]
With duplicates: ❌ FAILED - No quadruplet found.
With negatives: ❌ FAILED - No quadruplet found.
Zero target: ✅ PASSED in 0 ms → [83, 27, -57, -53]
Large test #1: ✅ PASSED in 164 ms → [-94103, -95983, 98544, -98256]
...
All test cases passed!
```

---

## 🧪 How to Run

### Requirements

- Java 17+
- IDE (IntelliJ, Eclipse) or terminal access (`javac`, `java`)

### Entry Point

Run the following class:

```
src/quadruplet/QuadrupletTestRunner.java
```

This class:
- Runs multiple predefined test cases (including large arrays).
- Validates correct sum and value presence.
- Measures performance in milliseconds.

---

## 🧱 Core Components

| File                      | Responsibility                                             |
|---------------------------|------------------------------------------------------------|
| `Quadruplet.java`         | Represents a 4-number group with helper methods            |
| `QuadrupletFinder.java`   | Contains the efficient O(n²) search logic using HashMap    |
| `QuadrupletTestRunner.java` | Runs and validates all scenarios with performance logging |

---

## 🧑‍💻 Author

This module was designed and implemented by **Eriksson Hernández** as part of a technical challenge, with a strong emphasis on algorithmic efficiency, software craftsmanship, and clear documentation.

📧 Contact: [erikssonhernandez25@gmail.com](mailto:erikssonhernandez25@gmail.com)

---