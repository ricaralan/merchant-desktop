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
        header = new String[]{"Código", "Valor (%)", "Descripción"};
    }

    @Override
    public void initData(Connection connnection) {
        objects = (List<Object>) (Object) controller.getImpuestos(connnection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Impuesto impuesto = (Impuesto) objects.get(row);
        switch (column) {
            case 0:
                value = impuesto.codigoImpuesto;
                break;
            case 1:
                value = impuesto.valorImpuesto;
                break;
            case 2:
                value = impuesto.descripcionImpuesto;
        }
        return value;
    }

}
