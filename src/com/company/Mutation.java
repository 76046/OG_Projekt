package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Mutation {

    public static ArrayList<Path> mutation(ArrayList<Path> listOfPath,double probability,boolean isTrivial) {
        Random random = new Random();
        ArrayList<Path> finalListOfMutation = new ArrayList<>();

        finalListOfMutation.addAll(listOfPath);

        int size = listOfPath.size();
        int lenghtPath = listOfPath.get(0).getPathWay().size();

        if(isTrivial){
            for(int i = 0; i < size; i++){
                double randomizedProbabilities = random.nextDouble();
                if(randomizedProbabilities<probability){
                    int randomIndex1=0, randomIndex2=0;
                    Point pointSwap1, pointSwap2,tempPoint;
                    System.out.println("==========================================");
                    while(randomIndex1==randomIndex2){
                        randomIndex1 = random.nextInt(lenghtPath);
                        randomIndex2 = random.nextInt(lenghtPath);
                    }
                    System.out.println(randomIndex1);
                    System.out.println(randomIndex2);
                    System.out.println(finalListOfMutation.get(i));
                    pointSwap1 = finalListOfMutation.get(i).getPathWay().get(randomIndex1);
                    pointSwap2 = finalListOfMutation.get(i).getPathWay().get(randomIndex2);
                    System.out.println(pointSwap1);
                    System.out.println(pointSwap2);
                    finalListOfMutation.get(i).getPathWay().set(randomIndex1,pointSwap2);
                    finalListOfMutation.get(i).getPathWay().set(randomIndex2,pointSwap1);
                    System.out.println(finalListOfMutation.get(i));
                    System.out.println("==========================================");
                }
            }
            return finalListOfMutation;
        }
        else
        {
            for(int i = 0; i < size; i++){
                double randomizedProbabilities = random.nextDouble();
                if(randomizedProbabilities<probability){
                    int randomIndex1=0, randomIndex2=0;
                    Point pointSwap1, pointSwap2,tempPoint;
                    System.out.println("==========================================");
                    while(randomIndex1==randomIndex2) {
                        randomIndex1 = random.nextInt(lenghtPath);
                        randomIndex2 = random.nextInt(lenghtPath);
                    }
                    System.out.println(randomIndex1);
                    System.out.println(randomIndex2);
                    Path addNewPath = finalListOfMutation.get(i);
                    System.out.println(addNewPath);
                    pointSwap1 = addNewPath.getPathWay().get(randomIndex1);
                    pointSwap2 = addNewPath.getPathWay().get(randomIndex2);
                    System.out.println(pointSwap1);
                    System.out.println(pointSwap2);
                    addNewPath.getPathWay().set(randomIndex1,pointSwap2);
                    addNewPath.getPathWay().set(randomIndex2,pointSwap1);
                    System.out.println(addNewPath);
                    finalListOfMutation.add(addNewPath);
                    System.out.println("==========================================");
                }
            }
            return finalListOfMutation;
        }


    }

    public static ArrayList<Path> inversion(ArrayList<Path> listOfPath,double probability,boolean isTrivial) {
        Random random = new Random();
        ArrayList<Path> finalListOfInversion = new ArrayList<>();

        finalListOfInversion.addAll(listOfPath);

        int size = listOfPath.size();
        int lenghtPath = listOfPath.get(0).getPathWay().size();

        if(isTrivial){
            for(int i = 0; i < size; i++){
                double randomizedProbabilities = random.nextDouble();
                if(randomizedProbabilities<probability){
                    int randomIndex1=0, randomIndex2=0;
                    System.out.println("==========================================");
                    System.out.println(i);
                    while(randomIndex1==randomIndex2 || randomIndex2<randomIndex1){
                        randomIndex1 = random.nextInt(lenghtPath);

                        randomIndex2 = random.nextInt(lenghtPath);

                    }
                    System.out.println(randomIndex1);
                    System.out.println(randomIndex2);
                    Path chosenInterval = new Path();
                    for(int j = randomIndex2; j >= randomIndex1; j--){
                        chosenInterval.getPathWay().add(listOfPath.get(i).getPathWay().get(j));
                    }
                    System.out.println(chosenInterval);
                    int counter = 0;
                    for(int j = randomIndex1; j <= randomIndex2; j++){
                        finalListOfInversion.get(i).getPathWay().set(j,chosenInterval.getPathWay().get(counter++));
                    }
                    System.out.println("==========================================");
                }
            }
            return finalListOfInversion;
        }
        else
        {
            for(int i = 0; i < size; i++){
                double randomizedProbabilities = random.nextDouble();
                if(randomizedProbabilities<probability){
                    int randomIndex1=0, randomIndex2=0;
                    Point pointSwap1, pointSwap2,tempPoint;
                    System.out.println("==========================================");
                    System.out.println(i);
                    while(randomIndex1==randomIndex2 || randomIndex2<randomIndex1) {
                        randomIndex1 = random.nextInt(lenghtPath);
                        randomIndex2 = random.nextInt(lenghtPath);
                    }
                    System.out.println(randomIndex1);
                    System.out.println(randomIndex2);

                    Path chosenInterval = new Path();
                    int counter = randomIndex2;
                    for(int j = 0; j < lenghtPath; j++){
                        if(j>=randomIndex1 && j<=randomIndex2){
                            chosenInterval.getPathWay().add(listOfPath.get(i).getPathWay().get(counter--));
                            System.out.println("IF:"+listOfPath.get(i).getPathWay().get(j));
                        }else{
                            chosenInterval.getPathWay().add(listOfPath.get(i).getPathWay().get(j));
                            System.out.println("Else:"+listOfPath.get(i).getPathWay().get(j));
                        }
                    }
                    finalListOfInversion.add(chosenInterval);
                    System.out.println("==========================================");
                }
            }
            return finalListOfInversion;
        }
    }

}