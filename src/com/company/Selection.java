package com.company;

import java.util.*;

public class Selection {
    public static ArrayList<Path> tournamentMethod(ArrayList<Path> listOfPath) {

        int size = listOfPath.size();
        Random random = new Random();
        int sizeOfGroup = random.nextInt(size-2)+2;
        comparator newConfrontation = new comparator();

        ArrayList<Path> finalListOfSelection = new ArrayList<>();
        for(int k = 0;k<size;k++){
            ArrayList<Path> newListOfSelection = new ArrayList<>();
            for (int i = 0; i < sizeOfGroup;i++){
                int randomIndex = random.nextInt(size);
                newListOfSelection.add(listOfPath.get(randomIndex));
            }
            Collections.sort(newListOfSelection,newConfrontation);
            finalListOfSelection.add(newListOfSelection.get(0));
            newListOfSelection.clear();
        }
        return finalListOfSelection;
    }

    public static class comparator implements Comparator<Path> {
        @Override
        public int compare(Path row1, Path row2) {
            if(row1.getScorePath() > row2.getScorePath()){
                return 1;
            } else if(row1.getScorePath() < row2.getScorePath()) {
                return -1;
            }else{
                return -1;
            }
        }
    }

    public static ArrayList<Path> rankingMethod(ArrayList<Path> listOfPath) {
        int size = listOfPath.size();
        Random random = new Random();
        int sizeOfGroup = random.nextInt(size-2)+2;
        comparator newComparator = new comparator();

        ArrayList<Path> finalListOfSelection = new ArrayList<>();
        for(int k = 0;k<size;k++){
            Collections.sort(listOfPath,newComparator);
            int randomIndex = random.nextInt(random.nextInt(size-1)+1);
            finalListOfSelection.add(listOfPath.get(randomIndex));
        }
        return finalListOfSelection;
    }

    public static ArrayList<Path> rouletteMethod(ArrayList<Path> listOfPath) {
        ArrayList<Path> finalListOfSelection = new ArrayList<>();
        Random random = new Random();

        int size = listOfPath.size();
        double sumALL = 0;
        for(int i = 0;i < size; i++){
            sumALL += listOfPath.get(i).getScorePath();
        }
        double[] reversedProbability = new double[size];
        for(int i = 0;i < size; i++){
            reversedProbability[i] = sumALL/listOfPath.get(i).getScorePath();
        }
        sumALL = 0;
        for(int i = 0;i < size; i++){
            sumALL += reversedProbability[i];
        }
        double[] minProbability = new double[size];
        for(int i = 0;i < size; i++){
            minProbability[i] = reversedProbability[i]/sumALL;
        }

        Double[] distributor = new Double[size];
        distributor[0] = minProbability[0];
        for(int i = 1; i < size; i++) {
            distributor[i] = distributor[i - 1] + minProbability[i];
        }

        for(int i = 0; i < size; i++){
            double indicatorRoulette = random.nextDouble();
            if(indicatorRoulette>0&&indicatorRoulette<=distributor[0]){
                finalListOfSelection.add(listOfPath.get(0));
            }
            else
            {
                for(int k = 0;k<distributor.length-1;k++){
                    if(indicatorRoulette>distributor[k] && indicatorRoulette<=distributor[k+1]){
                        finalListOfSelection.add(listOfPath.get(k+1));
                    }
                }
            }
        }
        return finalListOfSelection;
    }

}
