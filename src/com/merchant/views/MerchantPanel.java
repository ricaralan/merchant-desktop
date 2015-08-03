package com.merchant.views;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author alan
 */ 
public class MerchantPanel extends JPanel {
    
    protected JInternalFrame parent;
    
    public void setParent(JInternalFrame f) {
        parent = f;
    }
}
