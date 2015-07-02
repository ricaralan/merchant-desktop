package com.merchant.components.tableModels;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public abstract class MerchantTableModel extends AbstractTableModel {

    public abstract Object getObjectByRow(int row);

    public abstract void editRowByObject(int row, Object o);

    public abstract void delRow(int row);
}
