package com.merchant.components.tableModels;

import com.merchant.controllers.EmpresaController;
import com.merchant.pojos.Empresa;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author alan
 */
public class EmpleadoTableModel extends MerchantTableModel{

    EmpresaController empresaController;

    public EmpleadoTableModel() {
        objects = new ArrayList<>();
        empresaController = new EmpresaController();
        header = new String[] {"Nombre", "R.F.C.", "Email", "Telefono 1", "Web"};
    }
    
    @Override
    public void initData (Connection connection) {
        objects = (List<Object>)(Object) empresaController.getEmpresas(connection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Empresa empresa = (Empresa)objects.get(row);
        switch (column) {
            case 0: value = empresa.nombre;break;
            case 1: value = empresa.rfc;break;
            case 2: value = empresa.email;break;
            case 3: value = empresa.tel;break;
            case 4: value = empresa.web;break;
        }
        return value;
    }
    
}
