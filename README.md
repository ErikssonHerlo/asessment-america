# 💼 Java Technical Assessment - Clean Architecture, OOP & Algorithms

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

## 🧾 Overview

This project includes:

- A **vehicle parking system** with multiple vehicle types, adaptive placement logic, and scenario reporting.
- An optimized **4Sum (QuadrupletSum)** solver using HashMap with O(n^2) complexity.
- A **Quickselect** implementation for locating the k-th smallest element in an array in O(n) average time.

Each solution is designed to:
- Be **modular**, **extensible**, and **testable**
- Use **clear separation of concerns**
- Follow **Java conventions** and **SOLID** design principles

---

## 📁 Project Structure

```
src/
├── parking/          # Parking lot system
├── quadruplet/       # 4Sum algorithm (optimized)
└── quickselect/      # Quickselect algorithm
```

---

## 🅿️ Parking Lot System

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

## 🔢 QuadrupletSum Algorithm

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

## 🔍 Quickselect Algorithm

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

## 🧑‍💻 Author

**Eriksson Hernández**  
📧 [erikssonhernandez25@gmail.com](mailto:erikssonhernandez25@gmail.com)  
Developed as part of a senior-level technical assessment. Focused on:
- High-performance Java
- Clean architecture
- Testable and maintainable systems
```

