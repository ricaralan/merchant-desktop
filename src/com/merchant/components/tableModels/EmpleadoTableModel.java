package com.merchant.components.tableModels;

import com.merchant.controllers.EmpleadoController;
import com.merchant.pojos.Empleado;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Eleazar
 */
public class EmpleadoTableModel extends MerchantTableModel{

    EmpleadoController empleadoController;

    public EmpleadoTableModel() {
        objects = new ArrayList<>();
        header = new String[]{"nombreEmpleado","apellidosEmpleado",
                        "telefonoEmpleado","mailEmpleado","salarioDiarioEmpleado",
                        "diasLaboralesEmpleado","altaEmpleado","usuario_idUsuario",
                        "domicilioFiscal_idDomicilioFiscal","sucursal_idSucursal",
                        "bajaEmpleado","statusEmpleado"};
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
            case 0: value = empleado.nombreEmpleado;break;
            case 1: value = empleado.apellidosEmpleado;break;
            case 2: value = empleado.telefonoEmpleado;break;
            case 3: value = empleado.mailEmpleado;break;
            case 4: value = ""+empleado.salarioDiarioEmpleado;break;
            case 5: value = ""+empleado.diasLaboralesEmpleado;break;
            case 6: value = ""+empleado.altaEmpleado;break;
            case 7: value = ""+empleado.usuario_idUsuario;break;
            case 8: value = ""+empleado.domicilioFiscal_idDomicilioFiscal;break;
            case 9: value = ""+empleado.sucursal_idSucursal;break;
            case 10: value = ""+empleado.bajaEmpleado;break;
        }
        return value;
    }
    
}
