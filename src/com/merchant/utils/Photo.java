package com.merchant.utils;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

/**
 *
 * @author alan
 */
public class Photo {

    private final String basePathSO;
    private String basePathPhoto;
    private ImageJPanel imagePanel;
    File photoToUpload;

    public Photo() {
        basePathSO = new File("").getAbsolutePath();
    }

    public synchronized void setPhoto(Component parent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(parent);
        photoToUpload = fileChooser.getSelectedFile();
    }

    public synchronized void setPhoto(String path) {
        photoToUpload = new File(basePathSO + path);
    }

    public synchronized void setBasePath(String basePath) {
        basePathPhoto = basePath;
    }

    public synchronized String getPosiblePathPhoto() {
        return (photoToUpload != null) ? basePathPhoto + photoToUpload.getName() : "";
    }

    public synchronized void setPhotoJPanel(JPanel panel) {
        if (photoToUpload != null) {
            imagePanel = new ImageJPanel(panel, photoToUpload.getAbsolutePath());
            panel.add(imagePanel).repaint();
        }
    }

    public void cleanPanelPhoto(JPanel panel) {
        panel.removeAll();
        panel.repaint();
    }

    public void uploadSelectedPhoto() {
        if(photoToUpload != null){
            try {
                FileChannel in = (new FileInputStream(photoToUpload)).getChannel();
                FileChannel out = (new FileOutputStream(new File(basePathSO +basePathPhoto+ photoToUpload.getName()))).getChannel();
                in.transferTo(0, photoToUpload.length(), out);
                in.close();
                out.close();
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }
}
