package com.merchant.components.tableModels;

import com.merchant.controllers.ProveedorController;
import com.merchant.pojos.Proveedor;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Eleazar
 */
public class ProveedorTableModel extends MerchantTableModel{

    ProveedorController proveedorController;

    public ProveedorTableModel() {
        objects = new ArrayList<>();
        header = new String[]{"Nombre","Cel.","Email","R.F.C.","Dirección","Fecha Alta","Status"};
        proveedorController = new ProveedorController();
    }
    
    @Override
    public void initData (Connection connection) {
        objects = (List<Object>)(Object)proveedorController.getAll(connection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Proveedor proveedor = (Proveedor)objects.get(row);
        switch (column) {
            case 0: value = proveedor.nombre+" "+proveedor.prov_apellidos;break;
            case 1: value = proveedor.prov_telefono_celular;break;
            case 2: value = proveedor.email;break;
            case 3: value = proveedor.rfc;break;
            case 4: value = proveedor.direccion;break;
            case 5: value = proveedor.prov_alta;break;
            case 6: value = proveedor.status;break;
            
        }
        return value;
    }
    
}
