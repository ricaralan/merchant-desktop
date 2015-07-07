/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.components;

import com.merchant.database.MerchantConnection;
import com.merchant.utils.KeyCode;
import com.merchant.views.EmpleadosPanel;
import com.merchant.views.configuration.ConfigurationPanel;
import com.merchant.views.MerchantPanel;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author alan
 */
public class MerchantMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MerchantMainFrame
     */
    private Dimension screen;
    private GraphicsDevice gd;
    private KeyCode keyCode;
    public MerchantConnection merchantConnection;

    public MerchantMainFrame() {
        initComponents();
        screen = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        backgroundDesktop.setBounds(10, 10, screen.width, screen.height);
        this.setSize(screen);
        setExtendedState(this.MAXIMIZED_BOTH);
        this.setTitle("Merchant desktop");
        setFullScreen();
        merchantConnection = new MerchantConnection();
        keyCode = new KeyCode();
    }
    
    private void setFullScreen () {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gd = env.getDefaultScreenDevice();
        gd.setFullScreenWindow(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopMenu = new javax.swing.JPopupMenu();
        menuConfiguracion = new javax.swing.JMenu();
        itemConfiguracion = new javax.swing.JMenuItem();
        itemEmpleados = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        backgroundDesktop = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        lblInicio = new javax.swing.JLabel();

        desktopMenu.setToolTipText("Menu");

        menuConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/merchant/images/icons/cog.png"))); // NOI18N
        menuConfiguracion.setText("Configuración");

        itemConfiguracion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/merchant/images/icons/cog.png"))); // NOI18N
        itemConfiguracion.setText("Configuración");
        itemConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConfiguracionActionPerformed(evt);
            }
        });
        menuConfiguracion.add(itemConfiguracion);

        itemEmpleados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/merchant/images/icons/empleados.png"))); // NOI18N
        itemEmpleados.setText("Empleados");
        itemEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEmpleadosActionPerformed(evt);
            }
        });
        menuConfiguracion.add(itemEmpleados);
        itemEmpleados.getAccessibleContext().setAccessibleName("Empleados");

        desktopMenu.add(menuConfiguracion);
        desktopMenu.add(jSeparator1);

        itemSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/merchant/images/icons/exit.png"))); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        desktopMenu.add(itemSalir);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        backgroundDesktop.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                backgroundDesktopKeyPressed(evt);
            }
        });

        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("_");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jToolBar2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);
        jToolBar2.setToolTipText("");
        jToolBar2.setBorderPainted(false);

        lblInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/merchant/images/icons/conf.png"))); // NOI18N
        lblInicio.setText("Inicio");
        lblInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInicioMouseClicked(evt);
            }
        });
        jToolBar2.add(lblInicio);

        javax.swing.GroupLayout backgroundDesktopLayout = new javax.swing.GroupLayout(backgroundDesktop);
        backgroundDesktop.setLayout(backgroundDesktopLayout);
        backgroundDesktopLayout.setHorizontalGroup(
            backgroundDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundDesktopLayout.createSequentialGroup()
                .addContainerGap(519, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1))
            .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundDesktopLayout.setVerticalGroup(
            backgroundDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundDesktopLayout.createSequentialGroup()
                .addGroup(backgroundDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        backgroundDesktop.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundDesktop.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        backgroundDesktop.setLayer(jToolBar2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDesktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundDesktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setState(this.ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lblInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInicioMouseClicked
        // TODO add your handling code here:
        toggleShowMenuInicio();
    }//GEN-LAST:event_lblInicioMouseClicked

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        aparecerMenuInicio(evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemSalirActionPerformed

    private void backgroundDesktopKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_backgroundDesktopKeyPressed
        aparecerMenuInicio(evt.getKeyCode());
    }//GEN-LAST:event_backgroundDesktopKeyPressed

    private void itemConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConfiguracionActionPerformed
        ConfigurationPanel form = new ConfigurationPanel(merchantConnection);
        newInternalFrame(form, "Configuraciones");
    }//GEN-LAST:event_itemConfiguracionActionPerformed

    private void itemEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEmpleadosActionPerformed
         newInternalFrame(new EmpleadosPanel(), "Empleados");
    }//GEN-LAST:event_itemEmpleadosActionPerformed

    private void aparecerMenuInicio(int code){
        if (keyCode.codeIsPressed("windows", code)) {
            toggleShowMenuInicio();
        }
    }
    
    private void toggleShowMenuInicio () {
        int x = lblInicio.getBounds().x;
        int y = (lblInicio.getBounds().y - (lblInicio.getHeight()/2)) - (desktopMenu.getComponentCount() * 20);
        if (!desktopMenu.isShowing()){
            desktopMenu.show(lblInicio, x, y);
        } else {
            desktopMenu.setFocusable(false);
            desktopMenu.setVisible(false);
        }
    }
    
    private void newInternalFrame(final MerchantPanel panel, final String internalTitle) {
        final MerchantMainFrame frame = this;
        frame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MerchantInternalFrame internal = new MerchantInternalFrame(internalTitle, panel);
                internal.setVisible(true);
                backgroundDesktop.add(internal);
                panel.setParent(internal);
                frame.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane backgroundDesktop;
    private javax.swing.JPopupMenu desktopMenu;
    private javax.swing.JMenuItem itemConfiguracion;
    private javax.swing.JMenuItem itemEmpleados;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JMenu menuConfiguracion;
    // End of variables declaration//GEN-END:variables
}
