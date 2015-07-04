package com.merchant.controllers;

import com.merchant.database.models.EmpleadoModel;
import com.merchant.pojos.Empleado;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class EmpleadoController {

    EmpleadoModel empleadoModel;

    public EmpleadoController() {
        empleadoModel = new EmpleadoModel();
    }

    public boolean create(Connection connection, Empleado empleado) {
        return empleadoModel.create(connection, empleado) == 1;
    }
    
    public boolean update(Connection connection, Empleado empleado, Integer id) {
        return empleadoModel.update(connection, empleado, id) == 1;
    }

    public boolean delete(Connection connection, Integer id) {
        return empleadoModel.delete(connection, id) == 1;
    }

    public List<Object> getEmpleados(Connection connection) {
        return empleadoModel.getAll(connection);
    }
}
