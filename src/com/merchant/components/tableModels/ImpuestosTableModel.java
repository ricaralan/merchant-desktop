package com.merchant.components.tableModels;

import com.merchant.controllers.ImpuestosController;
import com.merchant.pojos.Impuesto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan
 */
public class ImpuestosTableModel extends MerchantTableModel {

    ImpuestosController controller;

    public ImpuestosTableModel() {
        objects = new ArrayList<>();
        controller = new ImpuestosController();
        header = new String[]{"ID", "Código", "Descripción", "Valor (%)"};
    }

    @Override
    public void initData(Connection connnection) {
        objects = (List<Object>) (Object) controller.getAll(connnection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Impuesto impuesto = (Impuesto) objects.get(row);
        switch (column) {
            case 0:
                value = String.valueOf(impuesto.id_impuesto);
                break;
            case 1:
                value = impuesto.impto_codigo;
                break;
            case 2:
                value = impuesto.impto_descripcion;
            case 3: 
                value = impuesto.impto_valor;
        }
        return value;
    }

}
