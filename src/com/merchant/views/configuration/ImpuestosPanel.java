/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.views.configuration;

import com.merchant.components.tableModels.ImpuestosTableModel;
import com.merchant.components.tableModels.MerchantTableModel;
import com.merchant.controllers.ImpuestosController;
import com.merchant.pojos.Impuesto;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author alan
 */
public class ImpuestosPanel extends AbstractConfigurationPanel {

    /**
     * Creates new form ImpuestosPanel
     */
    private Connection connection;
    private JTable tableImpuestos;
    private ImpuestosController controller;
    private boolean crearImpuesto = true;
    private int idActualizar;

    public ImpuestosPanel(Connection connection, JTable table) {
        initComponents();
        tableImpuestos = table;
        tableImpuestos.setModel(new ImpuestosTableModel());
        controller = new ImpuestosController();
        this.connection = connection;
        initDataTable();
        
    }
    
    private void initDataTable() {
        getTableModel().initData(connection);
    }

    private MerchantTableModel getTableModel() {
        return ((MerchantTableModel) tableImpuestos.getModel());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        try{
            MaskFormatter mascara = new MaskFormatter("##.##");
            txtValor = new javax.swing.JFormattedTextField(mascara);
            btnOpcion = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();

            jLabel1.setText("Impuestos panel");

            jLabel2.setText("Código: ");

            jLabel3.setText("Valor(%): ");

            jLabel4.setText("Descripción: ");

            txtDescripcion.setColumns(20);
            txtDescripcion.setRows(5);
            jScrollPane1.setViewportView(txtDescripcion);

        }catch(Exception e){}
        txtValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnOpcion.setText("Crear");
        btnOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtValor)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnOpcion)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionActionPerformed
        Impuesto impuesto= getDatosImpuesto();
        if(crearImpuesto) {
            if(!controller.create(connection, impuesto)){
                JOptionPane.showMessageDialog(this, "Por favor intente más tarde...", "ERROR AL REGISTRAR", 1);
            }
        }else {
            if(!controller.update(connection, impuesto, idActualizar)){
                JOptionPane.showMessageDialog(this, "Por favor intente más tarde...", "ERROR AL REGISTRAR", 1);
            }
        }
        initDataTable();
        clean();
    }//GEN-LAST:event_btnOpcionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clean();
        crearImpuesto = true;
        btnOpcion.setText("Crear");
    }//GEN-LAST:event_jButton2ActionPerformed

    public Impuesto getDatosImpuesto() {
        Impuesto impuesto = new Impuesto();
        impuesto.impto_codigo = txtCodigo.getText();
        impuesto.impto_valor = txtValor.getText();
        impuesto.impto_descripcion = txtDescripcion.getText();
        return impuesto;
    }
    
    public void setDatosImpuesto(Impuesto impuesto) {
        txtCodigo.setText(impuesto.impto_codigo);
        txtValor.setText(impuesto.impto_valor);
        txtDescripcion.setText(impuesto.impto_descripcion);
    }

    public void clean() {
        txtCodigo.setText("");
        txtValor.setText("");
        txtDescripcion.setText("");
        crearImpuesto = true;
        btnOpcion.setText("Crear");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpcion;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void eventEditFromJtable(int row) {
        Impuesto impuesto = ((Impuesto)getTableModel().getObjectByRow(row));
        idActualizar = impuesto.id_impuesto;
        crearImpuesto = false;
        btnOpcion.setText("Editar");
        setDatosImpuesto(impuesto);
    }

    @Override
    public void eventDelFromJtable(int row) {
        Impuesto impuesto = (Impuesto) ((Impuesto)getTableModel().getObjectByRow(row));
        int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar el impuesto \"" + impuesto.impto_codigo + "\"?");
        if (res == JOptionPane.OK_OPTION) {
            if (controller.delete(connection, impuesto.id_impuesto)) {
                initDataTable();
                clean();
            } else {
                JOptionPane.showMessageDialog(null, "Por favor intente más tarde...", "ERROR AL ELIMINAR", 1);
            }
        } 
    }

    @Override
    public boolean validar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eventNewPassFromJtable(int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
