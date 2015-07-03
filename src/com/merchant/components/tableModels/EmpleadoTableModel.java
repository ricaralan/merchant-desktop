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

    List<Empresa> empresas;
    EmpresaController empresaController;
    private final String[] header = {"Nombre", "R.F.C.", "Email", "Telefono 1", "Web"};

    public EmpleadoTableModel() {
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
    public Object getValueAt(int row, int column) {
        String value = "";
        switch (column) {
            case 0: value = empresas.get(row).nombre;break;
            case 1: value = empresas.get(row).rfc;break;
            case 2: value = empresas.get(row).email;break;
            case 3: value = empresas.get(row).tel;break;
            case 4: value = empresas.get(row).web;break;
        }
        return value;
    }
    
    @Override
    public Object getObjectByRow (int row) {
        return empresas.get(row);
    }
    
    @Override
    public void editRowByObject(int row, Object empresa) {
        empresas.set(row, (Empresa)empresa);
    }
    
    @Override
    public void delRow(int row) {
        empresas.remove(row);
    }
    
}
