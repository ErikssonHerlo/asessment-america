# Java Technical Assessment - Clean Architecture, OOP & Algorithms

This repository contains the solution to a **technical Java assessment** designed to evaluate problem-solving skills, algorithmic efficiency, object-oriented design, and adherence to professional coding standards. The project covers three classic algorithmic problems, each implemented with:

- ✅ Clean, production-level Java code
- ✅ SOLID principles and reusable abstractions
- ✅ Fully documented and tested behavior

---

## 📚 Table of Contents

1. [Overview](#overview)
2. [Project Structure](#project-structure)
3. [Parking Lot System](#parking-lot-system)
4. [QuadrupletSum Algorithm](#quadrupletsum-algorithm)
5. [Quickselect Algorithm](#quickselect-algorithm)
6. [Execution Instructions](#execution-instructions)
7. [Author](#author)

---

## Overview

This project includes:

- A **vehicle parking system** with multiple vehicle types, adaptive placement logic, and scenario reporting.
- An optimized **4Sum (QuadrupletSum)** solver using HashMap with O(n^2) complexity.
- A **Quickselect** implementation for locating the k-th smallest element in an array in O(n) average time.

Each solution is designed to:
- Be **modular**, **extensible**, and **testable**
- Use **clear separation of concerns**
- Follow **Java conventions** and **SOLID** design principles

---

## Project Structure

```
src/
├── parking/          # Parking lot system
├── quadruplet/       # 4Sum algorithm (optimized)
└── quickselect/      # Quickselect algorithm
```

---

## Parking Lot System

### 🚦 Description
A modular simulation of a parking lot managing:
- Motorcycles
- Cars
- Vans (occupying multiple spots)

### 💡 Optimization Highlights
- Vehicles choose fallback spot types based on availability.
- Multiple test scenarios simulate real-world usage.
- Tracks status dynamically: full, empty, per-vehicle-type occupancy.

### 📈 Performance
| Scenario Type | Vehicles | Time (est.) | Optimization Impact |
|---------------|----------|-------------|----------------------|
| Full scenario | 8-10     | < 1ms       | Replaced `instanceof` with polymorphism, improved scalability |
| Overflow      | 10+      | < 2ms       | Reduced condition nesting, state accessors |

### 💡 SOLID Implementation
- **S**: Each class represents a single concern (`ParkingLot`, `Vehicle`, `Runner`)
- **O**: Easily add new vehicle types
- **L**: Vehicle types override `tryPark()` safely
- **I/D**: Loose coupling between vehicles and parking logic

---
### 📁 Directory Structure and File Responsibilities
```
src/
└── parking/
    ├── model/
    │   ├── Vehicle.java           # Abstract base class for all vehicle types
    │   ├── Motorcycle.java        # Motorcycle implementation with fallback logic
    │   ├── Car.java               # Car implementation with fallback logic
    │   ├── Van.java               # Van implementation, can occupy 1 large or 3 car spots
    │   └── ParkingResult.java     # Encapsulates parking attempt result (success + message)
    │
    ├── service/
    │   └── ParkingLot.java        # Core parking management system; tracks state and availability
    │
    ├── test/
    │   └── ParkingScenarioRunner.java  # Runs parking scenarios and prints detailed logs
    │
    └── ParkingLotTestLauncher.java     # Entry point to execute all test scenarios
```

### 🧪 Scenarios
- Mixed vehicles
- Overflow testing
- Type-specific simulations (only motorcycles/cars/vans)

### 🔎 Run
```bash
# Compile all Java files to an output directory (e.g., 'out')
javac -d out src/**/*.java

java -cp out parking.ParkingLotTestLauncher
```

---

## QuadrupletSum Algorithm

### 📘 Problem
Given an array `nums` and target `t`, find `{a,b,c,d}` such that:
```
a + b + c + d == t
```

### ⚡️ Optimization
- Replaced O(n^4) brute-force logic with **HashMap of pair sums**
- Hash lookups reduce runtime to **O(n^2)**

### 📊 Complexity
| Type   | Time    | Space  |
|--------|---------|--------|
| Brute  | O(n^4)  | O(1)   |
| Final  | O(n^2)  | O(n^2) |

### 📈 Improvement
- ~99.99% runtime reduction on arrays of 1,000+ elements
- From hours (brute) → milliseconds (optimized)

---
### 📁 Directory Structure and File Responsibilities

```
src/
└── quadruplet/
    ├── Quadruplet.java           # Model representing a valid group of four integers
    ├── QuadrupletFinder.java     # Optimized logic using HashMap to find quadruplets in O(n²)
    └── QuadrupletTestRunner.java # Validates multiple test cases including edge and large-scale arrays
```
### 🔎 Example
```
✅ PASSED | Small testcase | result = [2, 0, 5, 4]
✅ PASSED | Large #1       | result = [-94103, ..., -98256]
```

### 🔎 Run
```bash
# Compile all Java files to an output directory (e.g., 'out')
javac -d out src/**/*.java

java -cp out quadruplet.QuadrupletSumTestLauncher
```

---

## Quickselect Algorithm

### 📘 Problem
Find the k-th smallest element in an unsorted array in **less time than sorting**.

### ⚡️ Optimization
- Implemented Quickselect (variation of Quicksort)
- Selects pivot, partitions, and recurses **only on relevant half**

### 📊 Complexity
| Case      | Time  | Space |
|-----------|-------|-------|
| Average   | O(n)  | O(1)  |
| Worst     | O(n^2)| O(1)  |

### 🧠 Enhancements
- Input validation with `Optional<Integer>`
- Full test coverage: edge cases, duplicates, invalid `k`

---
### 📁 Directory Structure and File Responsibilities
```
src/
└── quickselect/
    ├── Quickselect.java            # Implements Quickselect to find the k-th smallest element efficiently
    ├── ArrayUtils.java             # Provides utility for in-place element swapping
    └── QuickselectTestRunner.java  # Runs tests for various input cases including edge and invalid values
```

### 🧪 Sample Output
```
✅ PASSED | [3,1,4,0,2], k=2 → result: 2
✅ PASSED | [5,5,5,5,5], k=3 → result: 5
✅ PASSED | Single element  → result: 10
```

### 🔎 Run
```bash
# Compile all Java files to an output directory (e.g., 'out')
javac -d out src/**/*.java

java -cp out quickselect.QuickselectTestRunner
```

---
Gracias por notarlo. Aquí tienes la sección **Execution Instructions** para el archivo `Main.java`, que sirve como punto de entrada para ejecutar los tres algoritmos en orden:

---

## Execution Instructions

### ✅ Prerequisites
- Java 17 or later
- Terminal or supported IDE (IntelliJ, Eclipse, etc.)
---

### 🛠️ Step-by-step Instructions

#### 1. Compile the entire project

From the root directory (where the `src/` folder is located), run:

```bash
javac -d out src/**/*.java
```

This compiles all source files into a new `out/` folder, preserving the package structure.

---

#### 2. Run the unified entry point

To execute all three algorithms (ParkingLot, QuadrupletSum, and Quickselect), run:

```bash
java -cp out Main
```

This will sequentially:

- Simulate all Parking Lot scenarios
- Run test cases for the optimized QuadrupletSum algorithm
- Run test cases for the Quickselect algorithm

---
## Author

**Eriksson Hernández**  
📧 [erikssonhernandez25@gmail.com](mailto:erikssonhernandez25@gmail.com)  
Developed as part of a technical assessment. Focused on:
- High-performance Java
- Clean architecture
- Testable and maintainable systems