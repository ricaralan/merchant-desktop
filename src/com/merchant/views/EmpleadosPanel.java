/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.views;

import com.merchant.components.tableModels.EmpresaTableModel;
import com.merchant.components.tableModels.MerchantTableModel;
import com.merchant.controllers.EmpresaController;
import com.merchant.database.MerchantConnection;
import com.merchant.pojos.Empresa;
import com.merchant.utils.ImageJPanel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author alan
 */
public class EmpleadosPanel extends MerchantPanel {

    /**
     * Creates new form EmpresasForm
     */
    private MerchantConnection merchantConnection = null;
    private EmpresaController empresaController = null;
    private boolean crearEmpresa;
    private int idActualizar;
    private ImageJPanel imagePanel;
    private File fotoASubir;
    private String basePathLogo = null, basePathSO = null;

    public EmpleadosPanel() {
        initComponents();
        merchantConnection = new MerchantConnection();
        empresaController = new EmpresaController();
        initDataTable();
        crearEmpresa = true;
        basePathLogo = "/images/empresas/";
        basePathSO = new File("").getAbsolutePath();
    }

    private void initDataTable() {
        ((EmpresaTableModel) tableEmpresas.getModel())
                .initData(merchantConnection.getConnection());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        opcionesEmpresa = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTel1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTel2 = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRegimen = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        txtWebEmpresa = new javax.swing.JTextField();
        panelFoto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEmpresas = new javax.swing.JTable();
        btnOpcionForm = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        Editar.setText("Editar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        opcionesEmpresa.add(Editar);

        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        opcionesEmpresa.add(Eliminar);

        jLabel1.setText("Empresas");

        jLabel2.setText("Nombre:");

        jLabel3.setText("R.F.C.:");

        jLabel4.setText("Regimen:");

        jLabel5.setText("Tel1:");

        jLabel6.setText("Tel2 (OPCIONAL):");

        jLabel7.setText("E-Mail:");

        txtRegimen.setColumns(20);
        txtRegimen.setRows(5);
        jScrollPane1.setViewportView(txtRegimen);

        jLabel8.setText("Web de la empresa:");

        panelFoto.setBorder(javax.swing.BorderFactory.createTitledBorder("Foto"));

        javax.swing.GroupLayout panelFotoLayout = new javax.swing.GroupLayout(panelFoto);
        panelFoto.setLayout(panelFotoLayout);
        panelFotoLayout.setHorizontalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );
        panelFotoLayout.setVerticalGroup(
            panelFotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tableEmpresas.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        tableEmpresas.setModel(new EmpresaTableModel());
        tableEmpresas.setComponentPopupMenu(opcionesEmpresa);
        tableEmpresas.setRowHeight(27);
        tableEmpresas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEmpresasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableEmpresas);

        btnOpcionForm.setText("Crear");
        btnOpcionForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionFormActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Añadir logo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Para más opciones, selecciona una fila y presiona clic derecho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel8)
                                            .addComponent(txtWebEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addComponent(jLabel5)
                                                        .addGap(113, 113, 113))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txtTel1)
                                                        .addGap(6, 6, 6)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(txtTel2)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(txtMail)))))
                            .addComponent(jLabel1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(btnOpcionForm, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(8, 8, 8)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtWebEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnOpcionForm)
                                    .addComponent(jButton2)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(panelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(97, 97, 97)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpcionFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionFormActionPerformed
        Empresa empresa = getDatosEmpresa();
        if (crearEmpresa) {
            if (!new EmpresaController().create(merchantConnection.getConnection(), empresa)) {
                JOptionPane.showMessageDialog(this, "Por favor intente más tarde...", "ERROR AL REGISTRAR", 1);
            } else {
                copyFile(fotoASubir, new File(basePathSO + empresa.logo));
            }
        } else {
            if (!new EmpresaController().update(merchantConnection.getConnection(), empresa, idActualizar)) {
                JOptionPane.showMessageDialog(this, "Por favor intente más tarde...", "ERROR AL ACTUALIZAR", 1);
            } else {
                crearEmpresa = true;
                btnOpcionForm.setText("Crear");
                idActualizar = 0;
                if ( fotoASubir != null ) {
                    copyFile(fotoASubir, new File(basePathSO + empresa.logo));
                }
            }
        }
        initDataTable();
        cleanDatosEmpresaForm();
    }//GEN-LAST:event_btnOpcionFormActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO add your handling code here:
        int row = tableEmpresas.getSelectedRow();
        if (row != -1) {
            Empresa empresa = (Empresa)((MerchantTableModel) tableEmpresas.getModel()).getObjectByRow(row);
            setDatosEmpresaForm(empresa);
            btnOpcionForm.setText("Editar");
            idActualizar = empresa.id;
            crearEmpresa = false;
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
        // TODO add your handling code here:
        int row = tableEmpresas.getSelectedRow();
        if (row != -1) {
            Empresa empresa = (Empresa)((MerchantTableModel) tableEmpresas.getModel()).getObjectByRow(row);
            int res = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar la empresa \"" + empresa.nombre + "\"?");
            if (res == JOptionPane.OK_OPTION) {
                if (empresaController.delete(merchantConnection.getConnection(), empresa.id)) {
                    ((EmpresaTableModel) tableEmpresas.getModel()).initData(merchantConnection.getConnection());
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor intente más tarde...", "ERROR AL ELIMINAR", 1);
                }
            }
        }
    }//GEN-LAST:event_EliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cleanDatosEmpresaForm();
        btnOpcionForm.setText("Crear");
        crearEmpresa = true;
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(this);
        fotoASubir = fileChooser.getSelectedFile();
        if (fotoASubir != null) {
            // Buscar logo y ponerlo en el JPanel para vista previa...
            setFotoLogo(fotoASubir.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableEmpresasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEmpresasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() > 1) {
            int row = tableEmpresas.getSelectedRow();
            if (row != -1) {
                Empresa empresa = (Empresa)((MerchantTableModel) tableEmpresas.getModel()).getObjectByRow(row);
                setDatosEmpresaForm(empresa);
                btnOpcionForm.setText("Editar");
                idActualizar = empresa.id;
                crearEmpresa = false;
            }
        }
    }//GEN-LAST:event_tableEmpresasMouseClicked

    private synchronized Empresa getDatosEmpresa() {
        Empresa empresa = new Empresa();
        empresa.nombre = txtNombre.getText();
        empresa.rfc = txtRFC.getText();
        //empresa.regimen = txtRegimen.getText();
        empresa.tel = txtTel1.getText();
        empresa.tel2 = txtTel2.getText();
        empresa.web = txtWebEmpresa.getText();
        empresa.email = txtMail.getText();
        if (fotoASubir != null) {
            empresa.logo = basePathLogo + fotoASubir.getName();
        } else {
            empresa.logo = "";
        }
        return empresa;
    }

    private synchronized void setDatosEmpresaForm(Empresa empresa) {
        cleanDatosEmpresaForm();
        txtNombre.setText(empresa.nombre);
        txtRFC.setText(empresa.rfc);
        //txtRegimen.setText(empresa.regimen);
        txtTel1.setText(empresa.tel);
        txtTel2.setText(empresa.tel2);
        txtWebEmpresa.setText(empresa.web);
        txtMail.setText(empresa.email);
        if (empresa.logo.length() > 1) {
            setFotoLogo(basePathSO + empresa.logo);
        }
    }

    private void cleanDatosEmpresaForm() {
        txtNombre.setText("");
        txtRFC.setText("");
        txtRegimen.setText("");
        txtTel1.setText("");
        txtTel2.setText("");
        txtWebEmpresa.setText("");
        txtMail.setText("");
        cleanFoto();
    }
    
    private synchronized void setFotoLogo(String path) {
        imagePanel = new ImageJPanel(panelFoto, path);
        panelFoto.add(imagePanel).repaint();
    }
    
    private void cleanFoto() {
        fotoASubir = null;
        panelFoto.removeAll();
        panelFoto.repaint();
    }

    private void copyFile(File from, File to) {
        try {
            FileChannel in = (new FileInputStream(from)).getChannel();
            FileChannel out = (new FileOutputStream(to)).getChannel();
            in.transferTo(0, from.length(), out);
            in.close();
            out.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JMenuItem Eliminar;
    private javax.swing.JButton btnOpcionForm;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu opcionesEmpresa;
    private javax.swing.JPanel panelFoto;
    private javax.swing.JTable tableEmpresas;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRFC;
    private javax.swing.JTextArea txtRegimen;
    private javax.swing.JTextField txtTel1;
    private javax.swing.JTextField txtTel2;
    private javax.swing.JTextField txtWebEmpresa;
    // End of variables declaration//GEN-END:variables
}
