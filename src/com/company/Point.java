package com.company;

import java.util.Random;

public class Point {
    private int coordinateX;
    private int coordinateY;
    private int namePoint;

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public int getNamePoint() {
        return namePoint;
    }

    Point(int namePoint){
        this.namePoint = namePoint;
        coordinateX = new Random().nextInt(100)-50;
        coordinateY = new Random().nextInt(100)-50;
    }

    public Point(int coordinateX, int coordinateY, int namePoint) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.namePoint = namePoint;
    }

    @Override
    public String toString() {
        return "Point "+namePoint+" (X " + coordinateX + ",Y " + coordinateY + ")";
    }

    public String showPoint(){
        return "( "+coordinateX+","+coordinateY+" )";
    }
}
