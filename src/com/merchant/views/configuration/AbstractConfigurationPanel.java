package com.merchant.views.configuration;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 *
 * @author alan
 */
public abstract class AbstractConfigurationPanel extends JPanel {

    protected JInternalFrame parent;

    public abstract void eventEditFromJtable(int row);

    public abstract void eventDelFromJtable(int row);

    public void setParent(JInternalFrame f) {
        parent = f;
    }
}
