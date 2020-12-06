package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CustomPanel extends JPanel {

    ArrayList<Integer> xPoints;
    ArrayList<Integer> yPoints;

    public ArrayList<Integer> getxPoints() {
        return xPoints;
    }

    public ArrayList<Integer> getyPoints() {
        return yPoints;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.drawLine(100, 0, 100, 200);
        g.drawLine(0, 100, 200, 100);
    }
}
