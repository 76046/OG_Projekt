
package com.company;

import java.awt.*;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GUI2 extends javax.swing.JFrame {

    private int numberOfPoints;
    private int numberOfPaths;
    private int numberOfEpochs;
    private String typeOfSelection;
    private String typeOfCrossing;
    private String typeOfSuccession;
    private double probabilityOfMutation;
    private double probabilityOfCrossing;
    private double probabilityOfInversion;
    public static int next=0;
    private String fileName=null;

    public static int getNext() {
        return next;
    }
    private ArrayList<Path> paths = new ArrayList<>();



    public GUI2() throws IOException {
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws IOException {

        jPanel1 = new CustomPanel("src/MapaPolski2.png");
        //jPanel1 = new CustomPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(770, 570));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 390, 370);

        jPanel2.setLayout(null);

        jLabel2.setText("ścieżek");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(100, 50, 50, 14);

        jLabel3.setText("epok");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(190, 50, 40, 14);

        jLabel4.setText("selekcji");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(30, 180, 60, 14);

        jLabel5.setText("krzyżowania");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(120, 180, 90, 14);

        jLabel6.setText("sukcesji");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(240, 180, 50, 14);

        jLabel7.setText("mutacji");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(50, 320, 60, 14);

        jLabel8.setText("krzyżowania ");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(130, 320, 100, 14);

        jLabel9.setText("inwersji");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(230, 320, 60, 14);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(90, 70, 57, 20);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField3);
        jTextField3.setBounds(180, 70, 57, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PMX", "OX" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox2);
        jComboBox2.setBounds(110, 200, 90, 20);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turniejowa", "Rankingowa", "Ruletki" }));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(7, 200, 90, 20);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trywialna", "Elitarna", "Losowa", "Ze ściskiem" }));
        jPanel2.add(jComboBox3);
        jComboBox3.setBounds(220, 200, 90, 20);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0.1d, 0.0d, 1.0d, 0.1d));
        jSpinner1.setOpaque(false);
        jPanel2.add(jSpinner1);
        jSpinner1.setBounds(40, 340, 60, 20);

        jSpinner2.setModel(new javax.swing.SpinnerNumberModel(0.1d, 0.0d, 1.0d, 0.1d));
        jPanel2.add(jSpinner2);
        jSpinner2.setBounds(130, 340, 60, 20);

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0.1d, 0.0d, 1.0d, 0.1d));
        jPanel2.add(jSpinner3);
        jSpinner3.setBounds(220, 340, 60, 20);

        jLabel10.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel10.setText("Liczba");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(140, 10, 45, 17);

        jLabel11.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel11.setText("Rodzaj");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(140, 140, 50, 17);

        jLabel12.setFont(new java.awt.Font("Century", 1, 14)); // NOI18N
        jLabel12.setText("Prawdopodobieństwo");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(90, 270, 170, 30);

        jButton1.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jButton1.setText("OBLICZ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(130, 380, 100, 30);

        jButton4.setText("Wczytaj");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try{
                    jButton4ActionPerformed(evt);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(280, 10, 80, 20);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(390, 0, 380, 420);

        jPanel3.setLayout(null);

        jLabel13.setText("Wynik 1:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(20, 40, 80, 14);

        jLabel14.setForeground(Color.red);
        jLabel14.setText("Wynik 2:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(20, 80, 60, 14);
        jPanel3.add(jLabel15);
        jLabel15.setBounds(70, 40, 660, 20);
        jLabel16.setForeground(Color.red);
        jPanel3.add(jLabel16);
        jLabel16.setBounds(70, 80, 670, 20);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 420, 750, 150);

        jButton3.setText("POPRZEDNI");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(20, 380, 120, 30);

        jButton2.setText("NASTĘPNY");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(260, 380, 120, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_jButton1ActionPerformed
        //numberOfPoints=Integer.parseInt(jTextField1.getText());
        numberOfPaths=Integer.parseInt(jTextField2.getText());
        numberOfEpochs=Integer.parseInt(jTextField3.getText());
        typeOfSelection=jComboBox1.getSelectedItem().toString();
        typeOfCrossing=jComboBox2.getSelectedItem().toString();
        typeOfSuccession=jComboBox3.getSelectedItem().toString();
        probabilityOfMutation=(double) jSpinner1.getValue();
        probabilityOfCrossing=(double) jSpinner2.getValue();
        probabilityOfInversion=(double) jSpinner3.getValue();
        next=0;
        try {
            paths = Main.run(/*numberOfPoints,*/numberOfPaths,numberOfEpochs,typeOfSelection,typeOfCrossing,typeOfSuccession,probabilityOfMutation,probabilityOfCrossing,probabilityOfInversion,fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        jPanel1.setPaths(paths);
        jLabel15.setText(paths.get(paths.size()-1).NumbersOfPath()+" "+paths.get(paths.size()-1).getScorePath());
        jLabel16.setText(paths.get(paths.size()-1).NumbersOfPath()+" "+paths.get(paths.size()-1).getScorePath());
        getContentPane().validate();
        getContentPane().repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(next<paths.size()-1)
        {
            next++;
        }
        jLabel15.setText(paths.get(paths.size()-1-next).NumbersOfPath()+" "+paths.get(paths.size()-1-next).getScorePath());
        getContentPane().validate();
        getContentPane().repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(next>0)
        {
            next--;
        }
        jLabel15.setText(paths.get(paths.size()-1-next).NumbersOfPath()+" "+paths.get(paths.size()-1-next).getScorePath());
        getContentPane().validate();
        getContentPane().repaint();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            fileName = f.getAbsolutePath();
        } catch (Exception ex) {
            fileName=null;
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//
//
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//
//                new GUI2().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    /*
    private javax.swing.JPanel jPanel1;
    */
    private CustomPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

