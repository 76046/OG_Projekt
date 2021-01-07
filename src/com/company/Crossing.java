package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Crossing {
    public static void PMX(ArrayList<Path> listOfPath,double probability,boolean isTrivial){ //ArrayList<Path>
        Random random = new Random();
        int size = listOfPath.size();
        ArrayList<Integer> listOfRandomIndex = new ArrayList<>();

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
            functionPMX(listOfPath.get(i),listOfPath.get(i+1));
        }
    }
    public static ArrayList<Path> functionPMX(Path pathOne, Path pathTwo){
        Random random = new Random();
        int randomIndex1=0, randomIndex2=0;
        while(randomIndex1==randomIndex2 || randomIndex2<randomIndex1){
            randomIndex1 = random.nextInt(pathOne.getPathWay().size());
            randomIndex2 = random.nextInt(pathOne.getPathWay().size());
        }

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

        for(int i = 0;i<pathOne.getPathWay().size();i++) {
            if(!(i>=randomIndex1 && i<=randomIndex2)){
                if(selectedSection.contains(pathTwo.getPathWay().get(i).getNamePoint())){
                    System.out.println("Problem");
                    int indexOfRepeatedElement = 0;
                    int getNamePoint = pathTwo.getPathWay().get(i).getNamePoint();
                    boolean condition = true;
                    while(condition){
                        for(int j = 0; j < child.getPathWay().size(); j++) {
                            if(child.getPathWay().get(j).getNamePoint() == getNamePoint) {
                                indexOfRepeatedElement = j;
                            }else{
                                condition = false;
                                break;
                            }
                        }
                        getNamePoint = pathTwo.getPathWay().get(indexOfRepeatedElement).getNamePoint();
                    }



                }else{
                    child.getPathWay().get(i).setNamePoint(pathTwo.getPathWay().get(i).getNamePoint());
                    child.getPathWay().get(i).setCoordinateY(pathTwo.getPathWay().get(i).getCoordinateY());
                    child.getPathWay().get(i).setCoordinateX(pathTwo.getPathWay().get(i).getCoordinateX());
                }
            }

        }

    }

}
