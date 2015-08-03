package com.merchant.components.tableModels;

import com.merchant.controllers.EmpleadoController;
import com.merchant.pojos.Empleado;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Eleazar
 */
public class EmpleadoTableModel extends MerchantTableModel{

    EmpleadoController empleadoController;

    public EmpleadoTableModel() {
        objects = new ArrayList<>();
        header = new String[]{"Nombre","Cel.","Email","R.F.C.","Tipo Empleado ","Sucursal",
                        "Usuario","Dirección","Persepción","Fecha Alta","Status"};
        empleadoController = new EmpleadoController();
    }
    
    @Override
    public void initData (Connection connection) {
        objects = (List<Object>)(Object)empleadoController.getAll(connection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Empleado empleado = (Empleado)objects.get(row);
        switch (column) {
            case 0: value = empleado.nombre+" "+empleado.emp_apellidos;break;
            case 1: value = empleado.emp_telefono_celular;break;
            case 2: value = empleado.email;break;
            case 3: value = empleado.rfc;break;
            case 4: value = empleado.tipo_empleado;break;
            case 5: value = empleado.suc_nombre;break;
            case 6: value = empleado.usuario;break;
            case 7: value = empleado.direccion;break;
            case 8: value = String.valueOf(empleado.percepcion);break;
            case 9: value = empleado.emp_alta;break;
            case 10: value = empleado.status;break;
        }
        return value;
    }
  
}
