package com.example.demo.controller;

import com.example.demo.model.Rover;
import com.example.demo.service.RoverService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RoverController {

    private final RoverService roverService;

    // Constructor Injection
    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    // Endpoint: Get current status of the rover
    // GET /api/status
    @GetMapping("/status")
    public Rover getStatus() {
        return roverService.getRoverStatus();
    }

    // Endpoint: Send commands to the rover
    // POST /api/move?commands=FFRFFL
    @PostMapping("/move")
    public Rover moveRover(@RequestParam String commands) {
        return roverService.processCommands(commands);
    }
    
    // Endpoint: Reset the rover to initial position
    // POST /api/reset
    @PostMapping("/reset")
    public Rover resetRover() {
        return roverService.resetRover();
    }
}


