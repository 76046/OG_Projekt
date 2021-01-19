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

        for(int i = 0; i < mainPathOfPoints.getPathWay().size(); i++){
            for(int j = 0; j < mainPathOfPoints.getPathWay().size(); j++){
                System.out.print(individualRoads[i][j] + " ");
            }
            System.out.println();
        }

        boolean spr = false;
        ArrayList<Integer> pickNumbers = new ArrayList<>();
        double[][] pathAndScore = new double[mainPathOfPoints.getPathWay().size()][mainPathOfPoints.getPathWay().size()+1];
        for(int k = 0; k< mainPathOfPoints.getPathWay().size(); k++ ){
            pickNumbers.clear();
            int i = k;
            for(;mainPathOfPoints.getPathWay().size()!=pickNumbers.size();){
                System.out.println("I :"+i);
                pickNumbers.add(i);
                double value = 100000;
                int temp = 0;
                for(int j = 0; j < mainPathOfPoints.getPathWay().size(); j++){
                    if(i!=j){
                        spr = false;
                        System.out.println(j);
                        for(int g = 0; g < pickNumbers.size(); g++){
                            if(pickNumbers.contains(j)){
                                System.out.println("   "+pickNumbers.get(g));
                                spr = true;
                            }
                        }
                        System.out.println("  "+!spr);
                        if(individualRoads[i][j]<value && !spr){
                            value = individualRoads[i][j];
                            temp = j;
                            System.out.println("  "+individualRoads[i][j]+" temp "+temp);
                        }
                    }
                }
                System.out.println(" ost: "+temp);
                i = temp;
            }
            double sum= 0;
            for(int b = 0; b < pickNumbers.size()-1; b++ ){
                sum += individualRoads[pickNumbers.get(b)][pickNumbers.get(b+1)];
                        System.out.println(individualRoads[pickNumbers.get(b)][pickNumbers.get(b+1)]);
                pathAndScore[k][b] = pickNumbers.get(b);
                        System.out.println("L:"+pickNumbers.get(b));
            }
            pathAndScore[k][pickNumbers.size()-1] = pickNumbers.get(pickNumbers.size()-1);
                        System.out.println(individualRoads[pickNumbers.get(pickNumbers.size()-1)][pickNumbers.get(0)]);
                        System.out.println("L1:"+pickNumbers.get(pickNumbers.size()-1));
            sum += individualRoads[pickNumbers.get(pickNumbers.size()-1)][pickNumbers.get(0)];
                        System.out.println("sum ="+sum);
            pathAndScore[k][pickNumbers.size()] = sum;
        }

        for(int i = 0; i < mainPathOfPoints.getPathWay().size(); i++){
            System.out.print(i+") ");
            for(int j = 0; j <= mainPathOfPoints.getPathWay().size(); j++){
                System.out.print(pathAndScore[i][j] + " ");
            }
            System.out.println();
        }
    }
}
