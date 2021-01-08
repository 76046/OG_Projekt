package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GUI window = new GUI();
                    window.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        //tworzymy liste do szaflowania
        int numberOfPoints = 10;
        int numberOfCombinations = 4;
        Path mainPathOfPoints = new Path();
        ArrayList<Path> listOfPath = new ArrayList<Path>();
        //tworzenie punktow
        for(int i = 0;i < numberOfPoints;i++){
            mainPathOfPoints.addPoint(new Point(i));
        }
        //losowanie i wpisywanie nowych sciezek
        for(int i = 0; i < numberOfCombinations; i++){
            Collections.shuffle(mainPathOfPoints.getPathWay());
            Path newPath = new Path();
            for(int j = 0; j < mainPathOfPoints.getPathWay().size();j++){
                newPath.addPoint(new Point( mainPathOfPoints.pathWay.get(j).getCoordinateX(),
                                            mainPathOfPoints.pathWay.get(j).getCoordinateY(),
                                            mainPathOfPoints.pathWay.get(j).getNamePoint()));
            }
            listOfPath.add(newPath);
            newPath.countPathValue();
        }

        for(int i = 0 ; i<listOfPath.size();i++){
            System.out.println(i+" "+listOfPath.get(i));
        }
        //ArrayList<Path> listAfterMutation = Mutation.mutation(listOfPath,0.9,false);
        //ArrayList<Path> listAfterSelection = Selection.rankingMethod(listOfPath);

//        for(int i = 0 ; i<listAfterMutation.size();i++){
//            System.out.println(i+" "+listAfterMutation.get(i));
//        }

        ArrayList<Path> listAfterCrossing = Crossing.PMX(listOfPath,0.9,false);
        for(int i = 0 ; i<listAfterCrossing.size();i++){
            System.out.println(i+" "+listAfterCrossing.get(i).NumbersOfPath());
        }






    }
}


// zrobic cos do wypisywania sciezki 1-2
// 