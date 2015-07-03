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

    private final RegimenesController controller;

    public RegimenesTableModel() {
        objects = new ArrayList<>();
        controller = new RegimenesController();
        header = new String[]{"Nombre del regimen"};
    }

    @Override
    public void initData(Connection connnection) {
        objects = (List<Object>)(Object) controller.getRegimenes(connnection);
        fireTableDataChanged();
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        // Si se agregan más campos a la tabla regimen solo se necesita utilizar un switch de column
        return ((Regimen)objects.get(row)).descripcionRegimenFiscal;
    }

}
