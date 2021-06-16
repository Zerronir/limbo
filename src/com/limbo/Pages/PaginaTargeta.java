package com.limbo.Pages;

import com.limbo.entities.Targeta;
import com.limbo.service.TargetaService;
import com.limbo.service.TargetaServiceAccess;
import com.mysql.cj.result.SqlDateValueFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PaginaTargeta extends javax.swing.JPanel {
    TargetaService ts = new TargetaServiceAccess();

    /**
     * Creates new form PaginaTargeta
     */
    public PaginaTargeta() {
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
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<String>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        jLabel1.setText("NOVA TARGETA DE CRÈDIT");

        jLabel2.setText("Tipus");

        jLabel3.setText("Número");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        jFormattedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField1ActionPerformed(evt);
            }
        });
        jLabel4.setText("Data de caducitat");

        jLabel5.setText("Número de seguretat");

        jButton1.setBackground(new java.awt.Color(102, 204, 0));
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Número de targeta", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 0, 51));
        jButton2.setText("Sortir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- SELECCIONA UNA TARGETA --", "Visa", "Mastercard", "Maestro" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(164, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(164, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(51, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 21, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(79, 79, 79)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addContainerGap(112, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jFormattedTextField1ActionPerformed(ActionEvent evt) {
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
            try {
                Targeta t = new Targeta();

                if(jComboBox1.getSelectedItem().toString().equals("-- SELECCIONA UNA TARGETA --")) {
                    throw new Exception("Selecciona una targeta per favor");
                }

                t.setTipus(jComboBox1.getSelectedItem().toString());

                Long numero = Long.parseLong(jTextField2.getText());
                if(numero > 0) {
                    t.setNumero(numero);
                } else {
                    throw new Exception("El número de la targeta ha de ser numèric i no pot estar buit");
                }

                if(!jTextField1.equals("")) {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsed = format.parse(jTextField1.getText());
                    java.sql.Date date = new java.sql.Date(parsed.getTime());
                    t.setData_caducitat(date);
                } else {
                    throw new Exception("La data de caducitat no pot estar buida");
                }

                int codi = Integer.parseInt(jTextField3.getText());
                t.setCodi_seguretat(codi);

                t.setClient_id(Main.logedUser.getNumero_client());

                ts.save(t);
                Main.showFirstPage();

            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
            }

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Main.showFirstPage();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration
}
