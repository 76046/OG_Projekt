package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Succession {
    public static ArrayList<Path> eliteFunction(ArrayList<Path> listOfPath,int numberOfPath){
        ArrayList<Path> finalListOfSuccession = new ArrayList<>();

        for(int j = 0; j < numberOfPath;j++){
            Path newPath = new Path();
            for(int k = 0; k < listOfPath.get(j).getPathWay().size();k++){
                newPath.addPoint(new Point(
                        listOfPath.get(j).getPathWay().get(k).getNamePoint(),
                        listOfPath.get(j).getPathWay().get(k).getCoordinateX(),
                        listOfPath.get(j).getPathWay().get(k).getCoordinateY()
                        ));
            }
            newPath.setScorePath(listOfPath.get(j).getScorePath());
            finalListOfSuccession.add(newPath);
        }
        return finalListOfSuccession;
    }

    public static ArrayList<Path> randomFunction(ArrayList<Path> listOfPath,int numberOfPath){
        ArrayList<Path> finalListOfSuccession = new ArrayList<>();

        Collections.shuffle(listOfPath);

        for(int j = 0; j < numberOfPath;j++){
            Path newPath = new Path();
            for(int k = 0; k < listOfPath.get(j).getPathWay().size();k++){
                newPath.addPoint(new Point(
                        listOfPath.get(j).getPathWay().get(k).getNamePoint(),
                        listOfPath.get(j).getPathWay().get(k).getCoordinateX(),
                        listOfPath.get(j).getPathWay().get(k).getCoordinateY()
                        ));
            }
            newPath.setScorePath(listOfPath.get(j).getScorePath());
            finalListOfSuccession.add(newPath);
        }
        return finalListOfSuccession;
    }

    public static ArrayList<Path> withSqueezeFunction(ArrayList<Path> listOfPath,int numberOfPath){
        double wartoscZmniejszajaca = 0.1;
        ArrayList<Path> finalListOfSuccession = new ArrayList<>();

        for(int i = 0 ; i< listOfPath.size();i++){
            finalListOfSuccession.add(listOfPath.get(i));
        }

        System.out.println(listOfPath.size()+" "+numberOfPath);
        if(!(listOfPath.size()==numberOfPath)){
            int counter = 1;
            while(counter!=0){
                counter = 0;
                for(int i = 0;i < finalListOfSuccession.size()-1 && (finalListOfSuccession.size() > numberOfPath);){
                    if(finalListOfSuccession.get(i).getScorePath() == finalListOfSuccession.get(i+1).getScorePath()){
                        finalListOfSuccession.remove(i+1);
                        System.out.println(finalListOfSuccession.size());
                        counter++;
                    }else{
                        i++;
                    }
                }
            }
        }


        while((finalListOfSuccession.size() > numberOfPath)) {
            for (int i = finalListOfSuccession.size()-1; i >= 1; i--) {
                if (((finalListOfSuccession.get(i).getScorePath() - wartoscZmniejszajaca) < finalListOfSuccession.get((i - 1)).getScorePath())
                        && (finalListOfSuccession.get((i - 1)).getScorePath() < finalListOfSuccession.get(i).getScorePath())) {
                    finalListOfSuccession.remove(i - 1);
                }
            }

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //System.out.println(wartoscZmniejszajaca);
            wartoscZmniejszajaca += 0.1;
        }
        return finalListOfSuccession;
    }
}
