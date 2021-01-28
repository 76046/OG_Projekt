package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class NearestNeighbor {
    public static Path theNearestNeighborFunction(Path mainPathOfPoints){

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
                //System.out.print(individualRoads[i][j] + " ");
            }
            //System.out.prinnt();
        }

        boolean spr = false;
        ArrayList<Integer> pickNumbers = new ArrayList<>();
        double[][] pathAndScore = new double[mainPathOfPoints.getPathWay().size()][mainPathOfPoints.getPathWay().size()+1];
        for(int k = 0; k< mainPathOfPoints.getPathWay().size(); k++ ){
            pickNumbers.clear();
            int i = k;
            for(;mainPathOfPoints.getPathWay().size()!=pickNumbers.size();){
                //System.out.prinnt("I :"+i);
                pickNumbers.add(i);
                double value = 100000;
                int temp = 0;
                for(int j = 0; j < mainPathOfPoints.getPathWay().size(); j++){
                    if(i!=j){
                        spr = false;
                        //System.out.prinnt(j);
                        for(int g = 0; g < pickNumbers.size(); g++){
                            if(pickNumbers.contains(j)){
                                //System.out.prinnt("   "+pickNumbers.get(g));
                                spr = true;
                            }
                        }
                        //System.out.prinnt("  "+!spr);
                        if(individualRoads[i][j]<value && !spr){
                            value = individualRoads[i][j];
                            temp = j;
                            //System.out.prinnt("  "+individualRoads[i][j]+" temp "+temp);
                        }
                    }
                }
                //System.out.prinnt(" ost: "+temp);
                i = temp;
            }
            double sum= 0;
            for(int b = 0; b < pickNumbers.size()-1; b++ ){
                sum += individualRoads[pickNumbers.get(b)][pickNumbers.get(b+1)];
                        //System.out.prinnt(individualRoads[pickNumbers.get(b)][pickNumbers.get(b+1)]);
                pathAndScore[k][b] = pickNumbers.get(b);
                        //System.out.prinnt("L:"+pickNumbers.get(b));
            }
            pathAndScore[k][pickNumbers.size()-1] = pickNumbers.get(pickNumbers.size()-1);
                        //System.out.prinnt(individualRoads[pickNumbers.get(pickNumbers.size()-1)][pickNumbers.get(0)]);
                        //System.out.prinnt("L1:"+pickNumbers.get(pickNumbers.size()-1));
            sum += individualRoads[pickNumbers.get(pickNumbers.size()-1)][pickNumbers.get(0)];
                        //System.out.prinnt("sum ="+sum);
            pathAndScore[k][pickNumbers.size()] = sum;
        }

        ArrayList<Path> FinalScoresOfPath = new ArrayList<Path>();

        for(int i = 0; i < mainPathOfPoints.getPathWay().size(); i++){
            //System.out.print(i+") ");

            Path newPath = new Path();
            newPath.setScorePath(pathAndScore[i][mainPathOfPoints.getPathWay().size()]);
            for(int j = 0; j <= mainPathOfPoints.getPathWay().size(); j++){
                //System.out.print(pathAndScore[i][j] + " ");
                for(int l = 0;l< mainPathOfPoints.getPathWay().size();l++){
                    if(pathAndScore[i][j]==mainPathOfPoints.getPathWay().get(l).getNamePoint()){
                        newPath.addPoint(new Point(mainPathOfPoints.getPathWay().get(l).getNamePoint(),
                                                   mainPathOfPoints.getPathWay().get(l).getCoordinateX(),
                                                   mainPathOfPoints.getPathWay().get(l).getCoordinateY()));
                    }
                }
            }
            //System.out.prinnt();
            FinalScoresOfPath.add(newPath);
        }
        //System.out.prinnt("------------------------------------------------------------------");
        Selection.comparator comparator = new Selection.comparator();
        Collections.sort(FinalScoresOfPath,comparator);

        for(int i = 0; i < FinalScoresOfPath.size(); i++){
            //System.out.prinnt(FinalScoresOfPath.get(i));
        }
        return FinalScoresOfPath.get(0);
    }
}
