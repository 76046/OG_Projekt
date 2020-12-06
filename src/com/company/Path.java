package com.company;

import java.util.ArrayList;

public class Path {
    ArrayList<Point> pathWay = new ArrayList<Point>();
    private double scorePath;

    public double getScorePath() {
        return scorePath;
    }

    public ArrayList<Point> getPathWay() {
        return pathWay;
    }

    public void addPoint(Point newPoint){
        pathWay.add(newPoint);
    }

    public double countPathValue(){
        double sum = 0;
        for(int i = 0;i<pathWay.size()-1;i++){
            sum += Math.sqrt(
                    Math.pow(pathWay.get(i).getCoordinateX()-pathWay.get(i+1).getCoordinateX(),2)
                    +
                    Math.pow(pathWay.get(i).getCoordinateY()-pathWay.get(i+1).getCoordinateY(),2));
        }
        sum += Math.sqrt(
                Math.pow(pathWay.get(0).getCoordinateX()-pathWay.get(pathWay.size()-1).getCoordinateX(),2)
                        +
                Math.pow(pathWay.get(0).getCoordinateY()-pathWay.get(pathWay.size()-1).getCoordinateY(),2));
        scorePath = sum;
        return sum;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0;i<pathWay.size();i++){

            if(i==pathWay.size()-1){
                result += pathWay.get(i).showPoint()+" = "+scorePath+"\n";
            }else{
                result += pathWay.get(i).showPoint()+",";
            }
        }
        return result;
    }
}
