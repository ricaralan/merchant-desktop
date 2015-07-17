package com.merchant.components.tableModels;

import com.merchant.controllers.EmpleadoController;
import com.merchant.pojos.Empleado;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Eleazar
 */
public class EmpleadoTableModel extends MerchantTableModel{

    EmpleadoController empleadoController;

    public EmpleadoTableModel() {
        objects = new ArrayList<>();
        header = new String[]{"emp_nombre","emp_apellidos","emp_telefono_celular",
                        "emp_telefono_casa","emp_email","emp_salario_diario",
                        "emp_dias_laborales","emp_alta","usuario_id_usuario",
                        "domicilio_id_domicilio","sucursal_id_sucursal",
                        "emp_baja","emp_status"};
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
            case 0: value = empleado.emp_nombre;break;
            case 1: value = empleado.emp_apellidos;break;
            case 2: value = empleado.emp_telefono_celular;break;
            case 3: value = empleado.emp_telefono_casa;break;
            case 4: value = empleado.emp_email;break;
            case 5: value = ""+empleado.emp_salario_diario;break;
            case 6: value = String.valueOf(empleado.emp_dias_laborales);break;
            case 7: value = String.valueOf(empleado.emp_alta);break;
            case 8: value = String.valueOf(empleado.usuario_id_usuario);break;
            case 9: value = String.valueOf(empleado.domicilio_id_domicilio);break;
            case 10: value = String.valueOf(empleado.sucursal_id_sucursal);break;
            case 11: value = String.valueOf(empleado.emp_baja);break;
            case 12: value = String.valueOf(empleado.emp_status);break;
        }
        return value;
    }
    
}
