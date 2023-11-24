package com.example.stickhero;

public class Mines {
    private int xcoord;
    private int ycoord;
    private int updown;

    public Mines() {
        makeMines();
    }

    public int getXcoord() {
        return xcoord;
    }

    public int getYcoord() {
        return ycoord;
    }

    public int getUpdown() {
        return updown;
    }
    public void makeMines(){
        Math.random();//to generate x,y and updown coords
    }

}
