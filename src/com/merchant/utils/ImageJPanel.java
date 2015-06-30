/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.utils;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author alan
 */
public class ImageJPanel extends JPanel {

    private int x, y;
    private String imagePath;

    public ImageJPanel(JPanel panel, String path) {
        x = panel.getWidth();
        y = panel.getHeight();
        imagePath = path;
        setSize(x, y);
    }

    @Override
    public void paint(Graphics g) {
        try {
            ImageIcon image = new ImageIcon(imagePath);
            g.drawImage(image.getImage(), 0, 0, x, y, null);
        } catch (NullPointerException e) {
            System.err.println(e);
        }
    }
}
