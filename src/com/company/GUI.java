package com.company;

import javax.swing.*;

public class GUI {

    private JFrame frame;
    CustomPanel panel;

    public GUI() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    public void initialize(){
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        panel = new CustomPanel();
        panel.setBounds(0, 0, 200, 200);
        frame.getContentPane().add(panel);
    }

}
