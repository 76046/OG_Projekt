package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CustomPanel extends JPanel {

    ArrayList<Path> paths;
    private Image image;

    public CustomPanel(String fileName) throws IOException {
        image = ImageIO.read(new File(fileName));
    }

    public void setPaths(ArrayList<Path> paths) {
        this.paths = paths;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 23, 12, 370, 370, /*352, 340,*/ this);

        if(this.paths != null){
            Path bestFromGeneticAlgorithm = paths.get(0);
            Path bestOfAll = paths.get(paths.size()-1);

            ArrayList<Point> points = bestFromGeneticAlgorithm.getPathWay();
            ArrayList<Integer> xPoints = new ArrayList<>();
            ArrayList<Integer> yPoints = new ArrayList<>();
            // pobieranie współrzędnych punktów
            for(int i = 0; i < points.size(); i++){
                xPoints.add(points.get(i).getCoordinateX());
                yPoints.add(points.get(i).getCoordinateY());
            }
            // rysowanie punktów i ich nazw
            for(int i = 0; i < xPoints.size(); i++){
//                g.drawOval((yPoints.get(i)/3)+20, (xPoints.get(i)/3)+10, 5, 5);
//                g.drawString(String.valueOf(points.get(i).getNamePoint()), (yPoints.get(i)/3)+20, (xPoints.get(i)/3)+10);
                g.drawOval((yPoints.get(i))+20, (xPoints.get(i))+10, 5, 5);
                g.drawString(String.valueOf(points.get(i).getNamePoint()), (yPoints.get(i))+20, (xPoints.get(i))+10);
            }
            //rysowanie ścieżki najlepszej z algorytmu genetycznego
            for(int i = 0; i < xPoints.size()-1; i++){
                //g.drawLine((yPoints.get(i)/3)+20, (xPoints.get(i)/3)+10, (yPoints.get(i+1)/3)+20, (xPoints.get(i+1)/3)+10);
                g.drawLine((yPoints.get(i))+20, (xPoints.get(i))+10, (yPoints.get(i+1))+20, (xPoints.get(i+1))+10);
            }
            //g.drawLine((yPoints.get(xPoints.size()-1)/3)+20, (xPoints.get(xPoints.size()-1)/3)+10, (yPoints.get(0)/3)+20, (xPoints.get(0)/3)+10);
            g.drawLine((yPoints.get(xPoints.size()-1))+20, (xPoints.get(xPoints.size()-1))+10, (yPoints.get(0))+20, (xPoints.get(0))+10);

            //rysowanie najlepszej ścieżki z algorytmu najbliższego sąsiada
            g.setColor(Color.red);

            ArrayList<Point> newCoordinates = bestOfAll.getPathWay();
            ArrayList<Integer> xNewCoordinates = new ArrayList<>();
            ArrayList<Integer> yNewCoordinates = new ArrayList<>();

            for(int i = 0; i < points.size(); i++){
                xNewCoordinates.add(newCoordinates.get(i).getCoordinateX());
                yNewCoordinates.add(newCoordinates.get(i).getCoordinateY());
            }

            for(int i = 0; i < xNewCoordinates.size()-1; i++){
                //g.drawLine((yNewCoordinates.get(i)/3)+20, (xNewCoordinates.get(i)/3)+10, (yNewCoordinates.get(i+1)/3)+20, (xNewCoordinates.get(i+1)/3)+10);
                g.drawLine((yNewCoordinates.get(i))+20, (xNewCoordinates.get(i))+10, (yNewCoordinates.get(i+1))+20, (xNewCoordinates.get(i+1))+10);
            }
            //g.drawLine((yNewCoordinates.get(xNewCoordinates.size()-1)/3)+20, (xNewCoordinates.get(xNewCoordinates.size()-1)/3)+10, (yNewCoordinates.get(0)/3)+20, (xNewCoordinates.get(0)/3)+10);
            g.drawLine((yNewCoordinates.get(xNewCoordinates.size()-1))+20, (xNewCoordinates.get(xNewCoordinates.size()-1))+10, (yNewCoordinates.get(0))+20, (xNewCoordinates.get(0))+10);
        }
    }
}
