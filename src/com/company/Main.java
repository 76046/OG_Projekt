package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        GUI2 frame=new GUI2();
        frame.setVisible(true);
    }
    public static void run(int nops, int noph, int noes, String tosn, String tosc, String toc, double pom, double poi, double poc ) throws FileNotFoundException {
        //Dijkstra Algorytm Dijkstry
        int numberOfPoints = nops;
        int numberOfPath = noph;
        int numberOfEpochs = noes;
        String typeOfSelection = tosn;  //"tournament" "ranking" "roulette"
        String typeOfSuccession = tosc;  //"trivial" "elite" "random" "with a squeeze"
        String typeOfCrossing = toc;  //"PMX" "OX"
        boolean ifTrival;
        double probabilityOfMutation = pom;
        double probabilityOfInversion = poi;
        double probabilityOfCrossing = poc;
        System.out.println(numberOfPoints);
        System.out.println(numberOfPath);
        System.out.println(numberOfEpochs);
        System.out.println(typeOfSelection);
        System.out.println(typeOfSuccession);
        System.out.println(typeOfCrossing);
        System.out.println(probabilityOfMutation);
        System.out.println(probabilityOfInversion);
        System.out.println(probabilityOfCrossing);
        if(typeOfSuccession.equals("trivial")){
            ifTrival = true;
        }else{
            ifTrival = false;
        }


//        Path mainPathOfPoints = new Path();
        Path mainPathOfPoints = ReadFromFile.rFF("src/points.txt");
        ArrayList<Path> listOfPath = new ArrayList<Path>();
        //tworzenie punktow
//        for(int i = 0;i < numberOfPoints;i++){
//            mainPathOfPoints.addPoint(new Point(i));
//        }

        TheFastestWay.theFastestWayFunction(mainPathOfPoints);

        //losowanie i wpisywanie nowych sciezek
//        for(int i = 0; i < numberOfPath; i++){
//            Collections.shuffle(mainPathOfPoints.getPathWay());
//            Path newPath = new Path();
//            for(int j = 0; j < mainPathOfPoints.getPathWay().size();j++){
//                newPath.addPoint(new Point( mainPathOfPoints.pathWay.get(j).getCoordinateX(),
//                        mainPathOfPoints.pathWay.get(j).getCoordinateY(),
//                        mainPathOfPoints.pathWay.get(j).getNamePoint()));
//            }
//            listOfPath.add(newPath);
//            newPath.countPathValue();
//        }
//
//        System.out.println("unsubscribing");
//        unsubscribing(listOfPath);
//
//        ArrayList<Path> listEpoch = new ArrayList<>(listOfPath);
//        for(int epoch=0;epoch < numberOfEpochs; epoch++){
//
//            ArrayList<Path> listBeforeSelection = new ArrayList<>(listEpoch);
//
//            switch (typeOfSelection)
//            {
//                case "Turniejowa":
//                    listEpoch = Selection.tournamentMethod(listEpoch);
//                    break;
//                case "Rankingowa":
//                    listEpoch = Selection.rankingMethod(listEpoch);
//                    break;
//                case "Ruletki":
//                    listEpoch = Selection.rouletteMethod(listEpoch);
//                    break;
//            }
//
//            ArrayList<Path> listBeforeMutation = new ArrayList<>(listBeforeSelection);
//
//            unsubscribing(listEpoch);
//            System.out.println("Mutation");
//            listEpoch = Mutation.mutation(listEpoch,probabilityOfMutation,ifTrival);
//            unsubscribing(listEpoch);
//
//            ArrayList<Path> listBeforeInversion = new ArrayList<>(listBeforeMutation);
//
//            System.out.println("Inversion");
//            listEpoch = Mutation.inversion(listEpoch,probabilityOfInversion,ifTrival);
//            unsubscribing(listEpoch);
//
//            ArrayList<Path> listBeforeCrossing = new ArrayList<>(listBeforeInversion);
//
//            System.out.println("Crossing");
//            switch (typeOfCrossing)
//            {
//                case "OX":
//                    unsubscribing(listEpoch);
//                    listEpoch = Crossing.OX(listBeforeCrossing,probabilityOfCrossing,ifTrival);
//                    break;
//                case "PMX":
//                    listEpoch = Crossing.PMX(listBeforeCrossing,probabilityOfCrossing,ifTrival);
//                    break;
//            }
//            System.out.println("calculationOfValues");
//            calculationOfValues(listBeforeCrossing);
//            Selection.comparator comparator = new Selection.comparator();
//            Collections.sort(listBeforeCrossing,comparator);
//            System.out.println("unsubscribing1");
//            unsubscribing(listEpoch);
//
//            ArrayList<Path> listBeforeSuccession = new ArrayList<>(listBeforeCrossing);
//
//            switch (typeOfSuccession)
//            {
//                case "Elitarna":
//                    listEpoch = Succession.eliteFunction(listBeforeSuccession,numberOfPath);
//                    break;
//                case "Losowa":
//                    listEpoch = Succession.randomFunction(listBeforeSuccession,numberOfPath);
//                    break;
//                case "Ze ściskiem":
//                    listEpoch = Succession.withSqueezeFunction(listBeforeSuccession,numberOfPath);
//                    break;
//            }
//            System.out.println("unsubscribing2");
//            unsubscribing(listBeforeSuccession);
//
//
//            copyFunction(listBeforeSuccession,listEpoch,numberOfPath);
//        }
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


