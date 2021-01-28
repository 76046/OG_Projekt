package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {

        GUI2 frame=new GUI2();
        frame.setVisible(true);

    }
    public static ArrayList<Path> run(/*int nops, */int noph, int noes, String tosn, String tosc, String toc, double pom, double poc, double poi, String fn, Path cPOM) throws FileNotFoundException {
        //Dijkstra Algorytm Dijkstry
        //int numberOfPoints = nops;
        int numberOfPoints;
        int numberOfPath = noph;
        int numberOfEpochs = noes;
        String typeOfSelection = tosn;  //"tournament" "ranking" "roulette"
        String typeOfSuccession = toc ;  //"trivial" "elite" "random" "with a squeeze"
        String typeOfCrossing = tosc;  //"PMX" "OX"
        boolean ifTrival;
        double probabilityOfMutation = pom;
        double probabilityOfInversion = poi;
        double probabilityOfCrossing = poc;
        String fileName = fn;
        Path chosenPointsOnMap = cPOM;
//        //////System.out.println(numberOfPoints);
//        //////System.out.println(numberOfPath);
//        //////System.out.println(numberOfEpochs);
//        //////System.out.println(typeOfSelection);
//        //////System.out.println(typeOfSuccession);
//        /////System.out.println(typeOfCrossing);
//        //////System.out.println(probabilityOfMutation);
//        //////System.out.println(probabilityOfInversion);
//        //////System.out.println(probabilityOfCrossing);
        if(typeOfSuccession.equals("Trywialna")){
            ifTrival = true;
        }else{
            ifTrival = false;
        }




        Path mainPathOfPoints = new Path();


        if(chosenPointsOnMap.getPathWay().size()>0){
            mainPathOfPoints = chosenPointsOnMap;
            for(int i = 0;i < mainPathOfPoints.getPathWay().size();i++){
                mainPathOfPoints.getPathWay().get(i).setNamePoint(i);
            }
        }else if(fn == null) {
            mainPathOfPoints = ReadFromFile.rFF("src/points.txt");
        } else {
            mainPathOfPoints = ReadFromFile.rFF(fn);
        }


        ArrayList<Path> listOfPath = new ArrayList<Path>();

        //////System.out.println(mainPathOfPoints.NumbersOfPath());
        //////System.out.println(mainPathOfPoints);
        //tworzenie punktow

        Path FASTESTPathOfPoints = NearestNeighbor.theNearestNeighborFunction(mainPathOfPoints);


        //losowanie i wpisywanie nowych sciezek
        numberOfPoints = mainPathOfPoints.getPathWay().size();

//        //System.out.println(numberOfPoints);
//        //System.out.println(numberOfPath);
//        //System.out.println(numberOfEpochs);
//        //System.out.println(typeOfSelection);
//        //System.out.println(typeOfSuccession);
//        //System.out.println(typeOfCrossing);
//        //System.out.println(probabilityOfMutation);
//        //System.out.println(probabilityOfInversion);
//        //System.out.println(probabilityOfCrossing);

        for(int i = 0; i < numberOfPath; i++){
            Collections.shuffle(mainPathOfPoints.getPathWay());
            Path newPath = new Path();
            for(int j = 0; j < mainPathOfPoints.getPathWay().size();j++){
                newPath.addPoint(new Point(
                        mainPathOfPoints.pathWay.get(j).getNamePoint(),
                        mainPathOfPoints.pathWay.get(j).getCoordinateX(),
                        mainPathOfPoints.pathWay.get(j).getCoordinateY()));
            }
            newPath.countPathValue();
            listOfPath.add(newPath);

        }

        //////System.out.println("//unsubscribing");
        ////unsubscribing(listOfPath);

        ArrayList<Path> listEpoch = new ArrayList<>();

        //unsubscribing(listOfPath);


        for(int i = 0; i< listOfPath.size(); i++){
            listEpoch.add(listOfPath.get(i));
        }

        //unsubscribing(listEpoch);

        for(int epoch=0;epoch < numberOfEpochs; epoch++){

            //System.out.println("X"+listEpoch.size());
            ArrayList<Path> listBeforeSelection = new ArrayList<>();
            for(int i = 0; i< listEpoch.size(); i++){
                listBeforeSelection.add(listEpoch.get(i));
            }
            listEpoch.clear();

            //System.out.println(listBeforeSelection.size());

            switch (typeOfSelection)
            {
                case "Turniejowa":
                    listEpoch = Selection.tournamentMethod(listBeforeSelection);
                    break;
                case "Rankingowa":
                    listEpoch = Selection.rankingMethod(listBeforeSelection);
                    break;
                case "Ruletki":
                    listEpoch = Selection.rouletteMethod(listBeforeSelection);
                    break;
            }
            //unsubscribing(listEpoch);
            //System.out.println("po typeOfSelection "+listEpoch.size());
            //System.out.println("XX"+listEpoch.size());
            ArrayList<Path> listBeforeMutation = new ArrayList<>();
            for(int i = 0; i< listEpoch.size(); i++){
                listBeforeMutation.add(listEpoch.get(i));
            }
            listEpoch.clear();

            ////unsubscribing(listEpoch);
            //////System.out.println("Mutation");
            listEpoch = Mutation.mutation(listBeforeMutation,probabilityOfMutation,ifTrival);
            ////unsubscribing(listEpoch);
            //unsubscribing(listEpoch);
            //System.out.println("po Mutation "+listEpoch.size());
            //System.out.println("XXX"+listEpoch.size());
            ArrayList<Path> listBeforeInversion = new ArrayList<>();
            for(int i = 0; i< listEpoch.size(); i++){
                listBeforeInversion.add(listEpoch.get(i));
            }
            listEpoch.clear();

            //////System.out.println("Inversion");
            listEpoch = Mutation.inversion(listBeforeInversion,probabilityOfInversion,ifTrival);
            ////unsubscribing(listEpoch);
            //unsubscribing(listEpoch);
            //System.out.println("po inversion "+listEpoch.size());
            //System.out.println("XXXX"+listEpoch.size());
            ArrayList<Path> listBeforeCrossing = new ArrayList<>();
            for(int i = 0; i< listEpoch.size(); i++){
                listBeforeCrossing.add(listEpoch.get(i));
            }
            listEpoch.clear();

            //System.out.println("listBeforeCrossing "+listBeforeCrossing.size());
            //////System.out.println("Crossing");




            switch (typeOfCrossing)
            {
                case "OX":
                    ////unsubscribing(listEpoch);

                    listEpoch = Crossing.OX(listBeforeCrossing,probabilityOfCrossing,ifTrival);
                    break;
                case "PMX":
                    //System.out.println("PMX");
                    listEpoch = Crossing.PMX(listBeforeCrossing,probabilityOfCrossing,ifTrival);
                    break;
                default:
                    //System.out.println("???");
                    break;
            }
            //////System.out.println("calculationOfValues");
            //unsubscribing(listEpoch);
            //System.out.println("po typeOfCrossing "+listEpoch.size());
            //System.out.println("XXXXX"+listEpoch.size());
            calculationOfValues(listEpoch);
            Selection.comparator comparator = new Selection.comparator();
            try
            {
                Collections.sort(listEpoch,comparator);
            }catch(Exception e){
                System.out.println(e);
                unsubscribing(listEpoch);
            }



            //////System.out.println("//unsubscribing1");
            ////unsubscribing(listEpoch);

            ArrayList<Path> listBeforeSuccession = new ArrayList<>();
            //System.out.println("XXXXXX"+listEpoch.size());
            for(int i = 0; i< listEpoch.size(); i++){
                listBeforeSuccession.add(listEpoch.get(i));
            }
            listEpoch.clear();

            switch (typeOfSuccession)
            {
                case "Elitarna":
                    listEpoch = Succession.eliteFunction(listBeforeSuccession,numberOfPath);
                    break;
                case "Losowa":
                    listEpoch = Succession.randomFunction(listBeforeSuccession,numberOfPath);
                    break;
                case "Ze ściskiem":
                    listEpoch = Succession.withSqueezeFunction(listBeforeSuccession,numberOfPath);
                    break;
                default:
                    for(int i = 0; i< listBeforeSuccession.size(); i++){
                        listEpoch.add(listBeforeSuccession.get(i));
                    }
                    break;
            }
            //System.out.println("XXXXXXX"+listEpoch.size());

            ////unsubscribing(listBeforeSuccession);

            //System.out.println("po sukcesji "+listEpoch.size());

            //copyFunction(listBeforeSuccession,listEpoch,numberOfPath);

            System.out.println();



            //System.out.println();

            if(epoch == 10 ||epoch == 20 ||epoch == 50 ||epoch == 100 ){
                System.out.println(epoch);

                for(int i = 0;i < listEpoch.size();i++){
                    System.out.println(listEpoch.get(i).getScorePath());
                    //System.out.println(listEpoch.get(i).hashCode());
                }

                //System.out.println();

//                double sum = 0;
//                for(int i = 0;i < listEpoch.size() ;i++){
//                    sum += listEpoch.get(i).getScorePath();
//                }
//                System.out.println(sum/numberOfPath);
//
//                if(epoch == 100){
//                    unsubscribing(listEpoch);
//                }
            }

            
            
            
        }

        listEpoch.add(FASTESTPathOfPoints);





        return listEpoch;


    }

    private static void calculationOfValues (ArrayList<Path> listOfPath){
        for(int i = 0; i < listOfPath.size();i++){
            listOfPath.get(i).countPathValue();
        }
    }

    private static void unsubscribing(ArrayList<Path> listOfPath){
        System.out.println("XD");
        for(int i = 0 ; i<listOfPath.size();i++){

            System.out.println(i+" "+listOfPath.get(i).NumbersOfPath());
            System.out.println(i+" "+listOfPath.get(i));
            System.out.println(i+" "+listOfPath.get(i).hashCode());

        }
    }

    private static void copyFunction(ArrayList<Path> list1, ArrayList<Path> list2,int numberOfPath){
        list2.clear();
        for(int i = 0; i< numberOfPath;i++){
            list2.add(list1.get(i));
        }
    }
}


