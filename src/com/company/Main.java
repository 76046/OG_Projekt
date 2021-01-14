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

        //Dijkstra Algorytm Dijkstry
        int numberOfPoints = 10;
        int numberOfPath = 10;
        int numberOfEpochs = 10;
        String typeOfSelection = "ranking";  //"tournament" "ranking" "roulette"
        String typeOfSuccession = "elite";  //"trivial" "elite" "random" "with a squeeze"
        String typeOfCrossing = "PMX";  //"PMX" "OX"
        boolean ifTrival;
        double probabilityOfMutation = 0.2;
        double probabilityOfInversion = 0.2;
        double probabilityOfCrossing = 0.2;
        if(typeOfSuccession.equals("trivial")){
            ifTrival = true;
        }else{
            ifTrival = false;
        }


        Path mainPathOfPoints = new Path();
        ArrayList<Path> listOfPath = new ArrayList<Path>();
        //tworzenie punktow
        for(int i = 0;i < numberOfPoints;i++){
            mainPathOfPoints.addPoint(new Point(i));
        }
        //losowanie i wpisywanie nowych sciezek
        for(int i = 0; i < numberOfPath; i++){
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

        System.out.println("unsubscribing");
        unsubscribing(listOfPath);

        ArrayList<Path> listEpoch = new ArrayList<>(listOfPath);
        for(int epoch=0;epoch < numberOfEpochs; epoch++){

            ArrayList<Path> listBeforeSelection = new ArrayList<>(listEpoch);

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

            ArrayList<Path> listBeforeMutation = new ArrayList<>(listBeforeSelection);

            unsubscribing(listEpoch);
            System.out.println("Mutation");
            listEpoch = Mutation.mutation(listEpoch,probabilityOfMutation,ifTrival);
            unsubscribing(listEpoch);

            ArrayList<Path> listBeforeInversion = new ArrayList<>(listBeforeMutation);

            System.out.println("Inversion");
            listEpoch = Mutation.inversion(listEpoch,probabilityOfInversion,ifTrival);
            unsubscribing(listEpoch);

            ArrayList<Path> listBeforeCrossing = new ArrayList<>(listBeforeInversion);

            System.out.println("Crossing");
            switch (typeOfCrossing)
            {
                case "OX":
                    unsubscribing(listEpoch);
                    listEpoch = Crossing.OX(listBeforeCrossing,probabilityOfCrossing,ifTrival);
                    break;
                case "PMX":
                    listEpoch = Crossing.PMX(listBeforeCrossing,probabilityOfCrossing,ifTrival);
                    break;
            }
            System.out.println("calculationOfValues");
            calculationOfValues(listBeforeCrossing);
            Selection.comparator comparator = new Selection.comparator();
            Collections.sort(listBeforeCrossing,comparator);
            System.out.println("unsubscribing1");
            unsubscribing(listEpoch);

            ArrayList<Path> listBeforeSuccession = new ArrayList<>(listBeforeCrossing);

            switch (typeOfSuccession)
            {
                case "elite":
                    listEpoch = Succession.eliteFunction(listBeforeSuccession,numberOfPath);
                    break;
                case "random":
                    listEpoch = Succession.randomFunction(listBeforeSuccession,numberOfPath);
                    break;
                case "with a squeeze":
                    listEpoch = Succession.withSqueezeFunction(listBeforeSuccession,numberOfPath);
                    break;
            }
            System.out.println("unsubscribing2");
            unsubscribing(listBeforeSuccession);


            copyFunction(listBeforeSuccession,listEpoch,numberOfPath);
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

    private static void copyFunction(ArrayList<Path> list1, ArrayList<Path> list2,int numberOfPath){
        list2.clear();
        for(int i = 0; i< numberOfPath;i++){
            list2.add(list1.get(i));
        }
    }
}


