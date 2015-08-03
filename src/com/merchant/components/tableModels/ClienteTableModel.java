package com.merchant.components.tableModels;

import com.merchant.controllers.ClienteController;
import com.merchant.pojos.Cliente;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Eleazar
 */
public class ClienteTableModel extends MerchantTableModel{

    ClienteController clienteController;

    public ClienteTableModel() {
        objects = new ArrayList<>();
        header = new String[]{"Nombre","Cel.","Email","R.F.C.","Dirección","Fecha Alta","Status"};
        clienteController = new ClienteController();
    }
    
    @Override
    public void initData (Connection connection) {
        objects = (List<Object>)(Object)clienteController.getAll(connection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Cliente cliente = (Cliente)objects.get(row);
        switch (column) {
            case 0: value = cliente.nombre+" "+cliente.clte_apellidos;break;
            case 1: value = cliente.clte_telefono_celular;break;
            case 2: value = cliente.email;break;
            case 3: value = cliente.rfc;break;
            case 4: value = cliente.direccion;break;
            case 5: value = cliente.clte_alta;break;
            case 6: value = cliente.status;break;
            
        }
        return value;
    }
    
}
