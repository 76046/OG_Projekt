package com.company;

import java.util.ArrayList;

public class TheFastestWay {
    public static void theFastestWayFunction(Path mainPathOfPoints){
        
        double[][] individualRoads = new double[mainPathOfPoints.getPathWay().size()][mainPathOfPoints.getPathWay().size()];
        for(int i = 0; i < mainPathOfPoints.getPathWay().size(); i++){
            for(int j = 0; j < mainPathOfPoints.getPathWay().size(); j++){
                individualRoads[i][j] = Math.sqrt(
                        Math.pow(mainPathOfPoints.getPathWay().get(i).getCoordinateX()-mainPathOfPoints.getPathWay().get(j).getCoordinateX(),2)
                                +
                        Math.pow(mainPathOfPoints.getPathWay().get(i).getCoordinateY()-mainPathOfPoints.getPathWay().get(j).getCoordinateY(),2));
            }
        }
        double[] scoreOfPath = new double[mainPathOfPoints.getPathWay().size()];
        for(int i = 0; i < mainPathOfPoints.getPathWay().size(); i++){
            for(int j = 0; j < mainPathOfPoints.getPathWay().size(); j++){
                System.out.print(individualRoads[i][j] + " ");
            }
            System.out.println();
        }

        //for k
        int k = 0;
        ArrayList<Integer> pickNumbers = new ArrayList<>();
        int i = k;

        for(; i < mainPathOfPoints.getPathWay().size(); i++){
            pickNumbers.add(i);
            double value = 100;
            int temp = 0;
            for(int j = 0; j < mainPathOfPoints.getPathWay().size(); j++){
                if(i==j){
                    continue;
                }else{
                    for(int g = 0; g < pickNumbers.size(); g++){
                        if(pickNumbers.get(g)!=j&&individualRoads[i][j]<value){
                            temp = j;
                            value = individualRoads[i][j];
                        }
                    }
                }
            }
            i = temp;
        }

        for(int j = 0; j < pickNumbers.size(); j++){
            System.out.print(pickNumbers.get(j).toString() + " ");
        }
    }
}
