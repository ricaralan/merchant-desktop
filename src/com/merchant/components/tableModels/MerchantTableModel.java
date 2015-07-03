package com.merchant.components.tableModels;

import java.sql.Connection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public abstract class MerchantTableModel extends AbstractTableModel {
    
    protected List<Object> objects;
    protected String[] header;
    
    @Override
    public int getRowCount() {
        return objects.size();
    }
    
    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    public Object getObjectByRow (int row) {
        return objects.get(row);
    }
    
    public void editRowByObject(int row, Object o) {
        objects.set(row, o);
    }
    
    public void delRow(int row) {
        objects.remove(row);
    }
    
    public abstract void initData(Connection connnection);
    
    public List<Object> getFilteredList(List<Object> list, int row, int colum, String value){
        for (int i = list.size() - 1; i >= 0; i--){
            String fieldValue = ((String)getValueAt(row, colum)).toLowerCase();
            // Si no tiene el valor solicitado entonces se remueve la fila
            if (!fieldValue.contains(value.toLowerCase())){
                list.remove(i);
            }
        }
        return list;
    }
}
