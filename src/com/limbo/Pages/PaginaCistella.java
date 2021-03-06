package com.limbo.Pages;

import com.limbo.DAO.TargetAccess;
import com.limbo.entities.LineaCistella;
import com.limbo.service.TargetaService;
import com.limbo.service.TargetaServiceAccess;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class PaginaCistella extends javax.swing.JPanel {

    /**
     * Creates new form PaginaCistella
     */
    public PaginaCistella() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel1.setText("Cistella de la compra");

        String[] col = {"Producte", "Quantitat", "Iva", "Preu sense iva", "Preu final"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(col, 0);

        if(Main.cistella.getLinies() != null) {
            List<LineaCistella> lineaCistellas = Main.cistella.getLinies();

            for (int i = 0; i < lineaCistellas.size(); i++) {
                String producte = lineaCistellas.get(i).getProducte().getNom();
                int qty = lineaCistellas.get(i).getQuantitat();
                int iva = lineaCistellas.get(i).getProducte().getIva();
                double preuNOIva = qty * lineaCistellas.get(i).getProducte().getPvp();
                double preuIva = preuNOIva + ((preuNOIva * iva) / 100);

                Object[] obj = {
                        producte, qty, iva, preuNOIva, preuIva
                };

                defaultTableModel.addRow(obj);

            }

        }

        jTable1 = new JTable(defaultTableModel);
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Confirmar compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "El client no t?? targetes", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        jButton2.setText("Sortir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(250, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1)))
                                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(42, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(135, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
        Main.showPurchasePage();

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Main.exitDeCistella = 1;
        Main.showFirstPage();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}
