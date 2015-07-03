package com.merchant.views.configuration;

import javax.swing.JPanel;

/**
 *
 * @author alan
 */
public abstract class AbstractConfigurationPanel extends JPanel {

    public abstract void eventEditFromJtable(int row);

    public abstract void eventDelFromJtable(int row);
}
