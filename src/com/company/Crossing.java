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
        finalListOfCrossing.addAll(listOfPath);

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
            System.out.println(listOfRandomIndex.get(i));
        }

        for(int i =0;i<listOfRandomIndex.size();i+=2){
            children.add(functionPMX(listOfPath.get(i),listOfPath.get(i+1)));
            children.add(functionPMX(listOfPath.get(i+1),listOfPath.get(i)));
        }

        if(isTrivial){
            for(int i = 0;i<finalListOfCrossing.size();i++){
                for(int j =0; j<listOfRandomIndex.size();j++){
                    if(i == listOfRandomIndex.get(j)){
                        finalListOfCrossing.set(listOfRandomIndex.get(j),children.get(listOfRandomIndex.get(j)));
                    }
                }
            }
        }else{
            finalListOfCrossing.addAll(children);
        }
        return finalListOfCrossing;

    }
    public static Path functionPMX(Path pathOne, Path pathTwo){
        Random random = new Random();
        int randomIndex1=0, randomIndex2=0;
        while(randomIndex1==randomIndex2 || randomIndex2<randomIndex1){
            randomIndex1 = random.nextInt(pathOne.getPathWay().size());
            randomIndex2 = random.nextInt(pathOne.getPathWay().size());
        }
        System.out.println("Przedzial A " +randomIndex1);
        System.out.println("Przedzial B " +randomIndex2);

        Path child = new Path();
        for(int i = 0;i<pathOne.getPathWay().size();i++) {
            child.addPoint(new Point(0,0,0));
        }
        ArrayList<Integer> selectedSection = new ArrayList<>();
        for(int i = randomIndex1;i<=randomIndex2;i++) {
            selectedSection.add(pathOne.getPathWay().get(i).getNamePoint());
            child.getPathWay().get(i).setNamePoint(pathOne.getPathWay().get(i).getNamePoint());
            child.getPathWay().get(i).setCoordinateY(pathOne.getPathWay().get(i).getCoordinateY());
            child.getPathWay().get(i).setCoordinateX(pathOne.getPathWay().get(i).getCoordinateX());
        }
        System.out.println("PC");
        for(int i = 0 ; i<child.getPathWay().size();i++){
            System.out.print(", "+child.getPathWay().get(i).getNamePoint());
        }
        System.out.println("\n");
        System.out.println("P1");
        for(int i = 0 ; i<pathOne.getPathWay().size();i++){
            System.out.print(", "+pathOne.getPathWay().get(i).getNamePoint());
        }
        System.out.println("\n");
        System.out.println("P2");
        for(int i = 0 ; i<pathOne.getPathWay().size();i++){
            System.out.print(", "+pathTwo.getPathWay().get(i).getNamePoint());
        }
        System.out.println("\n");

        for(int i = 0;i<pathOne.getPathWay().size();i++) {
            if(!(i>=randomIndex1 && i<=randomIndex2)){
                if(selectedSection.contains(pathTwo.getPathWay().get(i).getNamePoint())){
                    System.out.println("\n Problem");
                    System.out.println("PC");
                    for(int k = 0 ; k<child.getPathWay().size();k++){
                        System.out.print(", "+child.getPathWay().get(k).getNamePoint());
                    }
                    System.out.println("\n");
                    int indexOfRepeatedElement = 0;
                    int getNamePoint = pathTwo.getPathWay().get(i).getNamePoint();
                    boolean condition = true;
                    while(condition){
                        for(int j = 0; j < child.getPathWay().size(); j++) {
                            System.out.println("getNamePoint "+ getNamePoint);
                            System.out.println("child.getPathWay().get(j).getNamePoint() "+ child.getPathWay().get(j).getNamePoint());
                            System.out.println("j "+ j);
                            if(child.getPathWay().get(j).getNamePoint() == getNamePoint) {
                                indexOfRepeatedElement = j;
                                System.out.println("indexOfRepeatedElement "+ indexOfRepeatedElement);
                                System.out.println("j "+ j);
                                getNamePoint = pathTwo.getPathWay().get(indexOfRepeatedElement).getNamePoint();
                                condition = true;
                            }else{
                                condition = false;
                            }
                        }

                    }

                    for(int k =0;k<pathTwo.getPathWay().size();k++){
                        if(getNamePoint == pathTwo.getPathWay().get(k).getNamePoint()){
                            child.getPathWay().get(i).setNamePoint(getNamePoint);
                            child.getPathWay().get(i).setCoordinateY(pathTwo.getPathWay().get(i).getCoordinateY());
                            child.getPathWay().get(i).setCoordinateX(pathTwo.getPathWay().get(i).getCoordinateX());
                            break;
                        }
                    }

                }else{
                    child.getPathWay().get(i).setNamePoint(pathTwo.getPathWay().get(i).getNamePoint());
                    child.getPathWay().get(i).setCoordinateY(pathTwo.getPathWay().get(i).getCoordinateY());
                    child.getPathWay().get(i).setCoordinateX(pathTwo.getPathWay().get(i).getCoordinateX());
                }
            }

        }
        return child;

    }

}
