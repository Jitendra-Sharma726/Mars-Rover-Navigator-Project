package com.example.demo.model;

public class Rover {
    private int x;
    private int y;
    private String direction; // "N", "E", "S", "W"

    // Default constructor starting at 0,0 facing North
    public Rover() {
        this.x = 0;
        this.y = 0;
        this.direction = "N";
    }

    public Rover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    // Getters and Setters
    public int getX() { 
        return x; 
    }
    public void setX(int x) { 
        this.x = x; 
    }

    public int getY() { 
        return y; 
    }
    public void setY(int y) { 
        this.y = y; 
    }

    public String getDirection() { 
        return direction; 
    }
    public void setDirection(String direction) { 
        this.direction = direction; 
    }
}


