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
        int numberOfPoints = 5;
        int numberOfCombinations = 10;
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
            System.out.println(newPath);
        }

        for(int i = 0 ; i<listOfPath.size();i++){
            System.out.println(i+" "+listOfPath.get(i));
        }







    }
}


// zrobic cos do wypisywania sciezki 1-2
// 