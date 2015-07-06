package com.merchant.controllers;

import com.merchant.database.models.EmpleadoModel;
import com.merchant.pojos.Empleado;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class EmpleadoController extends MerchantController<Empleado> {

    EmpleadoModel empleadoModel;

    public EmpleadoController() {
        empleadoModel = new EmpleadoModel();
    }

    @Override
    public boolean create(Connection connection, Empleado empleado) {
        return empleadoModel.create(connection, empleado) == 1;
    }

    @Override
    public boolean update(Connection connection, Empleado empleado, Object id) {
        return empleadoModel.update(connection, empleado, id) == 1;
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        return empleadoModel.delete(connection, id) == 1;
    }

    @Override
    public List<Empleado> getAll(Connection connection) {
        return empleadoModel.getAll(connection);
    }
}
