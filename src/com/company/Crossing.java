package com.company;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Crossing {
    public static ArrayList<Path> PMX(ArrayList<Path> listOfPath,double probability,boolean isTrivial){
        Random random = new Random();
        int size = listOfPath.size();
        ArrayList<Integer> listOfRandomIndex = new ArrayList<>();
        ArrayList<Path> children = new ArrayList<>();
        ArrayList<Path> finalListOfCrossing = new ArrayList<>();

        for(int i = 0; i< listOfPath.size(); i++){
            finalListOfCrossing.add(listOfPath.get(i));
        }

        for(int i = 0;i<size;i++){
            double randomizedProbabilities = random.nextDouble();
            if(probability>randomizedProbabilities){
                listOfRandomIndex.add(i);
            }

        }
        if(listOfRandomIndex.size()%2!=0){
            listOfRandomIndex.remove(random.nextInt(listOfRandomIndex.size()));
        }
        Collections.shuffle(listOfRandomIndex);

        for(int i = 0;i<listOfRandomIndex.size();i++){
            //System.out.println(listOfRandomIndex.get(i));
        }

        for(int i =0;i<listOfRandomIndex.size();i+=2){
            try{
                children.add(functionPMX(finalListOfCrossing.get(listOfRandomIndex.get(i)),finalListOfCrossing.get(listOfRandomIndex.get(i+1))));
                children.add(functionPMX(finalListOfCrossing.get(listOfRandomIndex.get(i+1)),finalListOfCrossing.get(listOfRandomIndex.get(i))));
            }catch (Exception e){
                //System.out.println(e);
            }

        }

        if(isTrivial){
            for(int i = 0;i<finalListOfCrossing.size();i++){
                for(int j =0; j<listOfRandomIndex.size();j++){
                    if(i == listOfRandomIndex.get(j)){
//
                        finalListOfCrossing.set(listOfRandomIndex.get(j),children.get(j));
                    }
                }
            }
        }else{
            for(int i = 0; i< children.size(); i++){
                finalListOfCrossing.add(children.get(i));
            }
        }
        return finalListOfCrossing;

    }
    public static Path functionPMX(Path pathOne, Path pathTwo) throws InterruptedException {
        Random random = new Random();

        //System.out.println("P1");
        for(int i = 0 ; i<pathOne.getPathWay().size();i++){
            //System.out.print(", "+pathOne.getPathWay().get(i).getNamePoint());
        }
        //System.out.println("\n");
        //System.out.println("P2");
        for(int i = 0 ; i<pathOne.getPathWay().size();i++){
            //System.out.print(", "+pathTwo.getPathWay().get(i).getNamePoint());
        }
        //System.out.println("\n");

        int randomIndex1=0, randomIndex2=0;
        while(randomIndex1==randomIndex2 || randomIndex2<randomIndex1){
            randomIndex1 = random.nextInt(pathOne.getPathWay().size());
            randomIndex2 = random.nextInt(pathOne.getPathWay().size());
        }
        //System.out.println("Przedzial A " +randomIndex1);
        //System.out.println("Przedzial B " +randomIndex2);

        Path child = new Path();
        for(int i = 0;i<pathOne.getPathWay().size();i++) {
            child.addPoint(new Point(100,0,0));
        }
        ArrayList<Integer> selectedSection = new ArrayList<>();
        for(int i = randomIndex1;i<=randomIndex2;i++) {
            selectedSection.add(pathOne.getPathWay().get(i).getNamePoint());
            child.getPathWay().get(i).setNamePoint(pathOne.getPathWay().get(i).getNamePoint());
            //System.out.println(pathOne.getPathWay().get(i).getNamePoint());
            child.getPathWay().get(i).setCoordinateX(pathOne.getPathWay().get(i).getCoordinateX());
            //System.out.println(pathOne.getPathWay().get(i).getCoordinateX());
            child.getPathWay().get(i).setCoordinateY(pathOne.getPathWay().get(i).getCoordinateY());
            //System.out.println(pathOne.getPathWay().get(i).getCoordinateY());

        }
        //System.out.println("PC");
        for(int i = 0 ; i<child.getPathWay().size();i++){
            //System.out.print(", "+child.getPathWay().get(i).getNamePoint());
        }
        //System.out.println("\n");
        //System.out.println("P1");
        for(int i = 0 ; i<pathOne.getPathWay().size();i++){
            //System.out.print(", "+pathOne.getPathWay().get(i).getNamePoint());
        }
        //System.out.println("\n");
        //System.out.println("P2");
        for(int i = 0 ; i<pathOne.getPathWay().size();i++){
            //System.out.print(", "+pathTwo.getPathWay().get(i).getNamePoint());
        }
        //System.out.println("\n");

        for(int i = 0;i<pathOne.getPathWay().size();i++) {
            if(!(i>=randomIndex1&&i<=randomIndex2)){
                if(selectedSection.contains(pathTwo.getPathWay().get(i).getNamePoint())){
                    //System.out.println("\n Problem");
                    //System.out.println("PC");
                    for(int k = 0 ; k<child.getPathWay().size();k++){
                        //System.out.print(", "+child.getPathWay().get(k).getNamePoint());
                    }
                    //System.out.println("\n");
                    //System.out.println("P1");
                    for(int k = 0 ; k<pathOne.getPathWay().size();k++){
                        //System.out.print(", "+pathOne.getPathWay().get(k).getNamePoint());
                    }
                    //System.out.println("\n");
                    //System.out.println("P2");
                    for(int k = 0 ; k<pathOne.getPathWay().size();k++){
                        //System.out.print(", "+pathTwo.getPathWay().get(k).getNamePoint());
                    }
                    //System.out.println("\n");
                    int indexOfRepeatedElement = 0;
                    int getNamePoint = pathTwo.getPathWay().get(i).getNamePoint();
                    boolean condition = true;
                    while(condition){
                        //Thread.sleep(2000);
                        for(int j = 0; j < child.getPathWay().size(); j++) {
                            //System.out.println("getNamePoint "+ getNamePoint);
                            //System.out.println("child.getPathWay().get(j).getNamePoint() "+ child.getPathWay().get(j).getNamePoint());
                            //System.out.println("j "+ j);
                            if(child.getPathWay().get(j).getNamePoint() == getNamePoint) {
                                indexOfRepeatedElement = j;
                                //System.out.println("indexOfRepeatedElement "+ indexOfRepeatedElement);
                                //System.out.println("j "+ j);
                                getNamePoint = pathTwo.getPathWay().get(indexOfRepeatedElement).getNamePoint();
                                condition = true;
                                break;
                            }else{
                                condition = false;
                            }
                        }
                    }

                    for(int k =0;k<pathTwo.getPathWay().size();k++){
                        if(getNamePoint == pathTwo.getPathWay().get(k).getNamePoint()){
                            child.getPathWay().get(i).setNamePoint(getNamePoint);
                            child.getPathWay().get(i).setCoordinateX(pathTwo.getPathWay().get(k).getCoordinateX());
                            child.getPathWay().get(i).setCoordinateY(pathTwo.getPathWay().get(k).getCoordinateY());

                            break;
                        }
                    }
                }else{
                    child.getPathWay().get(i).setNamePoint(pathTwo.getPathWay().get(i).getNamePoint());
                    child.getPathWay().get(i).setCoordinateX(pathTwo.getPathWay().get(i).getCoordinateX());
                    child.getPathWay().get(i).setCoordinateY(pathTwo.getPathWay().get(i).getCoordinateY());

                }
            }
        }
        return child;
    }

    public static ArrayList<Path> OX(ArrayList<Path> listOfPath,double probability,boolean isTrivial){
        Random random = new Random();
        int size = listOfPath.size();
        ArrayList<Integer> listOfRandomIndex = new ArrayList<>();
        ArrayList<Path> children = new ArrayList<>();
        ArrayList<Path> finalListOfCrossing = new ArrayList<>();

        for(int i = 0; i< listOfPath.size(); i++){
            finalListOfCrossing.add(listOfPath.get(i));
        }

        for(int i = 0;i<size;i++){
            double randomizedProbabilities = random.nextDouble();
            if(probability>randomizedProbabilities){
                listOfRandomIndex.add(i);
            }

        }
        if(listOfRandomIndex.size()%2!=0){
            listOfRandomIndex.remove(random.nextInt(listOfRandomIndex.size()));
        }
        Collections.shuffle(listOfRandomIndex);

        for(int i = 0;i<listOfRandomIndex.size();i++){
            //System.out.println(listOfRandomIndex.get(i));
        }

        for(int i =0;i<listOfRandomIndex.size();i+=2){
            //System.out.println();
                //System.out.println(listOfRandomIndex.get(i));
                //System.out.println(listOfRandomIndex.get(i+1));

            for(int j = 0 ; j<listOfPath.size();j++){
                //System.out.println(j+" "+listOfPath.get(j).NumbersOfPath());
                //System.out.println(j+" "+listOfPath.get(j));
            }
            //System.out.println("=================");
            for(int j = 0 ; j<finalListOfCrossing.size();j++){
                //System.out.println(j+" "+finalListOfCrossing.get(j).NumbersOfPath());
                //System.out.println(j+" "+finalListOfCrossing.get(j));
            }

                children.add(functionOX(finalListOfCrossing.get(listOfRandomIndex.get(i)),finalListOfCrossing.get(listOfRandomIndex.get(i+1))));
                children.add(functionOX(finalListOfCrossing.get(listOfRandomIndex.get(i+1)),finalListOfCrossing.get(listOfRandomIndex.get(i))));


        }

        if(isTrivial){
            for(int i = 0;i<finalListOfCrossing.size();i++){
                for(int j =0; j<listOfRandomIndex.size();j++){
                    if(i == listOfRandomIndex.get(j)){
//                        //System.out.println(finalListOfCrossing.size());
//                        //System.out.println(children.size());
//                        //System.out.println(i);
//                        //System.out.println(j);
//                        //System.out.println(listOfRandomIndex.get(j));
                        ////System.out.println(children.get(listOfRandomIndex.get(j)));
                        //finalListOfCrossing.set(listOfRandomIndex.get(j),children.get(listOfRandomIndex.get(j)));
                        finalListOfCrossing.set(listOfRandomIndex.get(j),children.get(j));
                    }
                }
            }
        }else{
            for(int i = 0; i< children.size(); i++){
                finalListOfCrossing.add(children.get(i));
            }

        }
        return finalListOfCrossing;
    }
    public static Path functionOX(Path pathOne, Path pathTwo){
        Random random = new Random();

        //System.out.println("P1");
        for(int i = 0 ; i<pathOne.getPathWay().size();i++){
            //System.out.print(", "+pathOne.getPathWay().get(i).getNamePoint());
        }
        //System.out.println("\n");
        //System.out.println("P2");
        for(int i = 0 ; i<pathOne.getPathWay().size();i++){
            //System.out.print(", "+pathTwo.getPathWay().get(i).getNamePoint());
        }
        //System.out.println("\n");

        int randomIndex1 = random.nextInt((int)(pathOne.getPathWay().size()/2))+(pathOne.getPathWay().size()/4);

        //System.out.println("Srodeczek " +randomIndex1);

        Path child = new Path();
        for(int i = 0;i<pathOne.getPathWay().size();i++) {
            child.addPoint(new Point(100,0,0));
        }
        ArrayList<Integer> selectedSection = new ArrayList<>();
        for(int i = 0;i<=randomIndex1;i++) {
            selectedSection.add(pathOne.getPathWay().get(i).getNamePoint());
            child.getPathWay().get(i).setNamePoint(pathOne.getPathWay().get(i).getNamePoint());
            child.getPathWay().get(i).setCoordinateY(pathOne.getPathWay().get(i).getCoordinateY());
            child.getPathWay().get(i).setCoordinateX(pathOne.getPathWay().get(i).getCoordinateX());
        }
        randomIndex1++;
        for(int i = 0;i<pathOne.getPathWay().size();i++) {
                if(!selectedSection.contains(pathTwo.getPathWay().get(i).getNamePoint())){
                    child.getPathWay().get(randomIndex1).setNamePoint(pathTwo.getPathWay().get(i).getNamePoint());
                    child.getPathWay().get(randomIndex1).setCoordinateX(pathTwo.getPathWay().get(i).getCoordinateX());
                    child.getPathWay().get(randomIndex1).setCoordinateY(pathTwo.getPathWay().get(i).getCoordinateY());

                    randomIndex1++;
                }
        }
        return child;
    }
}
