package com.example.demo.service;

import com.example.demo.model.Rover;
import org.springframework.stereotype.Service;

@Service
public class RoverService {

    private final Rover rover;

    // Initialize the Rover when the service starts
    public RoverService() {
        this.rover = new Rover();
    }

    // Processes a string of commands (e.g., "FFRFFL")
    public Rover processCommands(String commands) {
        for (char command : commands.toUpperCase().toCharArray()) {
            if (command == 'L') {
                turnLeft();
            } else if (command == 'R') {
                turnRight();
            } else if (command == 'F') {
                moveForward();
            }
        }
        return rover;
    }

    public Rover getRoverStatus() {
        return rover;
    }
    
    // Reset rover to starting position
    public Rover resetRover() {
        rover.setX(0);
        rover.setY(0);
        rover.setDirection("N");
        return rover;
    }

    // Logic Methods:
    private void turnLeft() {
        switch (rover.getDirection()) {
            case "N":
                rover.setDirection("W");
                break;
            case "W":
                rover.setDirection("S");
                break;
            case "S":
                rover.setDirection("E");
                break;
            case "E":
                rover.setDirection("N");
                break;
        }
    }

    private void turnRight() {
        switch (rover.getDirection()) {
            case "N":
                rover.setDirection("E");
                break;
            case "E":
                rover.setDirection("S");
                break;
            case "S":
                rover.setDirection("W");
                break;
            case "W":
                rover.setDirection("N");
                break;
        }
    }

    private void moveForward() {
        int currentX = rover.getX();
        int currentY = rover.getY();

        switch (rover.getDirection()) {
            case "N":
                if (currentY < 9) {
                    rover.setY(currentY + 1);
                }
                break;
            case "S":
                if (currentY > 0) {
                    rover.setY(currentY - 1);
                }
                break;
            case "E":
                if (currentX < 9) {
                    rover.setX(currentX + 1);
                }
                break;
            case "W":
                if (currentX > 0) {
                    rover.setX(currentX - 1);
                }
                break;
        }
    }
}


