# Mars-Rover-Navigator-Project

# Mars Rover Navigator Project

## Overview

The Mars Rover Navigator is a Spring Boot REST API application designed to simulate the movement of a rover exploring the surface of Mars. The system tracks the rover's position on a 10x10 grid and processes navigation commands to determine its final coordinates and orientation.

The application follows a layered architecture consisting of Model, Service, and Controller layers, providing a clean separation between data representation, business logic, and API communication.

## Features

### 1. Rover Position Tracking

* Maintains the rover's current X and Y coordinates.
* Tracks the rover's current direction:

  * North (N)
  * East (E)
  * South (S)
  * West (W)

### 2. Command-Based Navigation

The rover accepts a sequence of commands:

* **F (Forward)** – Moves the rover one step forward in its current direction.
* **L (Left)** – Rotates the rover 90 degrees counter-clockwise.
* **R (Right)** – Rotates the rover 90 degrees clockwise.

Example:

```text
Commands: FFRF
```

### 3. Boundary Protection

The rover operates within a fixed 10x10 exploration zone.

* Minimum coordinate: (0,0)
* Maximum coordinate: (9,9)

If a movement command would cause the rover to leave the grid, that command is ignored and the rover remains in its current position.

### 4. Rover Reset

A dedicated endpoint allows the rover to return to its starting position:

* Coordinates: (0,0)
* Direction: N

## System Architecture

### Model Layer

**Rover.java**

Represents the rover's state and stores:

* X Coordinate
* Y Coordinate
* Direction

Provides constructors, getters, and setters for accessing and updating rover information.

### Service Layer

**RoverService.java**

Contains the core navigation logic:

* Processes command strings
* Executes turns and movement
* Validates grid boundaries
* Resets rover position
* Maintains rover state throughout the application lifecycle

### Controller Layer

**RoverController.java**

Exposes REST endpoints for:

* Viewing rover status
* Moving the rover
* Resetting the rover

Acts as the communication layer between clients and business logic.

## API Endpoints

### Get Rover Status

**GET**

```text
/api/status
```

Returns the rover's current position and direction.

Example Response:

```json
{
  "x": 2,
  "y": 3,
  "direction": "E"
}
```

---

### Move Rover

**POST**

```text
/api/move?commands=FFRFF
```

Processes the provided command sequence and updates the rover's position.

Example Response:

```json
{
  "x": 2,
  "y": 2,
  "direction": "E"
}
```

---

### Reset Rover

**POST**

```text
/api/reset
```

Resets the rover to its default state.

Example Response:

```json
{
  "x": 0,
  "y": 0,
  "direction": "N"
}
```

## Navigation Logic

### Turning Left (L)

| Current Direction | New Direction |
| ----------------- | ------------- |
| N                 | W             |
| W                 | S             |
| S                 | E             |
| E                 | N             |

### Turning Right (R)

| Current Direction | New Direction |
| ----------------- | ------------- |
| N                 | E             |
| E                 | S             |
| S                 | W             |
| W                 | N             |

### Moving Forward (F)

| Direction | Coordinate Change |
| --------- | ----------------- |
| N         | Y + 1             |
| S         | Y - 1             |
| E         | X + 1             |
| W         | X - 1             |

## Technologies Used

* Java
* Spring Boot
* REST APIs
* Maven
* JSON

## Expected Outcome

The Mars Rover Navigator provides a reliable simulation of rover movement on a bounded grid. By processing navigation commands, enforcing exploration boundaries, and exposing RESTful endpoints, the project demonstrates core Spring Boot concepts including dependency injection, layered architecture, REST API development, and state management.
