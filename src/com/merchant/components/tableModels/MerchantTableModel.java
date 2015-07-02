package com.merchant.components.tableModels;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public abstract class MerchantTableModel extends AbstractTableModel {

    public abstract Object getObjectByRow(int row);

    public abstract void editRowByObject(int row, Object o);

    public abstract void delRow(int row);
    
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
