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

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public void setNamePoint(int namePoint) {
        this.namePoint = namePoint;
    }

    Point(int namePoint){
        this.namePoint = namePoint;
        coordinateX = new Random().nextInt(10)-5;
        coordinateY = new Random().nextInt(10)-5;
    }

    public Point( int namePoint, int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.namePoint = namePoint;
    }

    @Override
    public String toString()
    {
        return "Point "+namePoint+" (X " + coordinateX + ",Y " + coordinateY + ")";
    }

    public String showPoint(){
        return "( "+coordinateX+","+coordinateY+" )";
    }
}
