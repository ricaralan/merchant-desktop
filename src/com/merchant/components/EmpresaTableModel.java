package com.merchant.components;

import com.merchant.controllers.EmpresaController;
import com.merchant.pojos.Empresa;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alan
 */
public class EmpresaTableModel extends AbstractTableModel{

    List<Empresa> empresas;
    EmpresaController empresaController;
    private final String[] header = {"Nombre", "R.F.C.", "Email", "Telefono 1", "Web"};

    public EmpresaTableModel() {
        empresas = new ArrayList<>();
        empresaController = new EmpresaController();
    }
    
    public void initEmpresas (Connection connection) {
        empresas = empresaController.getEmpresas(connection);
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return empresas.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public Object getValueAt(int i, int y) {
        String value = "";
        switch (y) {
            case 0: value = empresas.get(i).nombre;break;
            case 1: value = empresas.get(i).rfc;break;
            case 2: value = empresas.get(i).email;break;
            case 3: value = empresas.get(i).tel;break;
            case 4: value = empresas.get(i).web;break;
        }
        return value;
    }
    
}
