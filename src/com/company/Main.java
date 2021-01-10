package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    GUI window = new GUI();
//                    window.getFrame().setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        //tworzymy liste do szaflowania
        int numberOfPoints = 10;
        int numberOfCombinations = 10;
        int numberOfEpochs = 1;
        String typeOfSelection = "tournament";  //"tournament" "ranking" "roulette"
        String typeOfSuccession = "trivial";  //"trivial" "elite" "random" "with a squeeze"
        String typeOfCrossing = "PMX";  //"PMX" "OX"
        boolean ifTrival = true;
        double probabilityOfMutation = 0.2;
        double probabilityOfInversion = 0.2;
        double probabilityOfCrossing = 0.2;


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
            System.out.println(i+") "+listOfPath.get(i));
            System.out.println(i+") "+listOfPath.get(i).NumbersOfPath());
        }
        ArrayList<Path> listEpoch = new ArrayList<>(listOfPath);
        for(int epoch=0;epoch < numberOfEpochs; epoch++){


            switch (typeOfSelection)
            {
                case "tournament":
                    listEpoch = Selection.tournamentMethod(listEpoch);
                    break;
                case "ranking":
                    listEpoch = Selection.rankingMethod(listEpoch);
                    break;
                case "roulette":
                    listEpoch = Selection.rouletteMethod(listEpoch);
                    break;
            }
            System.out.println("Mutation");
            listEpoch = Mutation.mutation(listEpoch,probabilityOfMutation,ifTrival);
            listEpoch = Mutation.inversion(listEpoch,probabilityOfInversion,ifTrival);
            System.out.println("Crossing");
            switch (typeOfCrossing)
            {
                case "OX":
                    listEpoch = Crossing.OX(listEpoch,probabilityOfCrossing,ifTrival);
                    break;
                case "PMX":
                    listEpoch = Crossing.PMX(listEpoch,probabilityOfCrossing,ifTrival);
                    break;
            }
            System.out.println("calculationOfValues");
            calculationOfValues(listEpoch);
            Selection.comparator comparator = new Selection.comparator();
            Collections.sort(listEpoch,comparator);
            System.out.println("unsubscribing");
            unsubscribing(listOfPath);
            switch (typeOfSuccession)
            {
                case "trivial":

                    break;
                case "elite":

                    break;
                case "random":
                    break;
                case "with a squeeze":
                    break;
            }

        }
    }

    private static void calculationOfValues (ArrayList<Path> listOfPath){
        for(int i = 0; i < listOfPath.size();i++){
            listOfPath.get(i).countPathValue();
        }
    }

    private static void unsubscribing(ArrayList<Path> listOfPath){
        for(int i = 0 ; i<listOfPath.size();i++){
            System.out.println(i+" "+listOfPath.get(i).NumbersOfPath());
            System.out.println(i+" "+listOfPath.get(i));
        }
    }
}


