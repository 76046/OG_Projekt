
package com.company;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import java.io.FileNotFoundException;

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
    
    

    public GUI2() {
        initComponents();
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
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
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 454));
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 390, 370);

        jPanel2.setLayout(null);

        jLabel1.setText("miast");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(50, 50, 40, 14);

        jLabel2.setText("ścieżek");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(140, 50, 50, 14);

        jLabel3.setText("epok");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(230, 50, 40, 14);

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

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(40, 70, 57, 20);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(130, 70, 57, 20);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField3);
        jTextField3.setBounds(220, 70, 57, 20);

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
        jButton1.setText("START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(120, 380, 100, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(390, 0, 360, 460);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 370, 390, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt){//GEN-FIRST:event_jButton1ActionPerformed
        numberOfPoints=Integer.parseInt(jTextField1.getText());
        numberOfPaths=Integer.parseInt(jTextField2.getText());
        numberOfEpochs=Integer.parseInt(jTextField3.getText());
        typeOfSelection=jComboBox1.getSelectedItem().toString();
        typeOfCrossing=jComboBox2.getSelectedItem().toString();
        typeOfSuccession=jComboBox3.getSelectedItem().toString();
        probabilityOfMutation=(double) jSpinner1.getValue();
        probabilityOfCrossing=(double) jSpinner2.getValue();
        probabilityOfInversion=(double) jSpinner3.getValue();
        try {
            Main.run(numberOfPoints,numberOfPaths,numberOfEpochs,typeOfSelection,typeOfCrossing,typeOfSuccession,probabilityOfMutation,probabilityOfCrossing,probabilityOfInversion);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new GUI2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}

