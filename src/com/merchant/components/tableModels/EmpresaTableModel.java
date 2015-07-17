package com.merchant.components.tableModels;

import com.merchant.controllers.EmpresaController;
import com.merchant.pojos.Empresa;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alan
 */
public class EmpresaTableModel extends MerchantTableModel{

    EmpresaController empresaController;

    public EmpresaTableModel() {
        objects = new ArrayList<>();
        header = new String[]{"Nombre", "R.F.C.", "Email", "Telefono 1", "Web"};
        empresaController = new EmpresaController();
    }
    
    @Override
    public void initData (Connection connection) {
        objects = (List<Object>)(Object)empresaController.getAll(connection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Empresa empresa = (Empresa)objects.get(row);
        switch (column) {
            case 0: value = empresa.emp_nombre;break;
            case 1: value = empresa.emp_rfc;break;
            case 2: value = empresa.emp_email;break;
            case 3: value = empresa.emp_tel;break;
            case 4: value = empresa.emp_web;
        }
        return value;
    }
    
}
