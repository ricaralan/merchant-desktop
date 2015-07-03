package com.merchant.components.tableModels;

import com.merchant.controllers.RegimenesController;
import com.merchant.pojos.Regimen;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan
 */
public class RegimenesTableModel extends MerchantTableModel {

    public List<Object> regimenes;
    private final RegimenesController controller;
    private final String header[];

    public RegimenesTableModel() {
        regimenes = new ArrayList<>();
        controller = new RegimenesController();
        header = new String[]{"Nombre del regimen"};
    }

    @Override
    public void initData(Connection connnection) {
        regimenes = controller.getRegimenes(connnection);
        fireTableDataChanged();
    }

    @Override
    public Object getObjectByRow(int row) {
        return regimenes.get(row);
    }

    @Override
    public void editRowByObject(int row, Object o) {
        regimenes.set(row, o);
    }

    @Override
    public void delRow(int row) {
        regimenes.remove(row);
    }

    @Override
    public int getRowCount() {
        return regimenes.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int row) {
        return header[row];
    }

    @Override
    public Object getValueAt(int row, int column) {
        // Si se agregan más campos a la tabla regimen solo se necesita utilizar un switch de column
        return ((Regimen)regimenes.get(row)).descripcionRegimenFiscal;
    }

}
