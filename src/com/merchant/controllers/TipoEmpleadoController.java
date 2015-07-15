package com.merchant.controllers;

import com.merchant.database.models.RegimenModel;
import com.merchant.database.models.TipoEmpleadoModel;
import com.merchant.pojos.Regimen;
import com.merchant.pojos.TipoEmpleado;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class TipoEmpleadoController extends MerchantController<TipoEmpleado> {

    TipoEmpleadoModel model;

    public TipoEmpleadoController() {
        model = new TipoEmpleadoModel();
    }

    @Override
    public List<TipoEmpleado> getAll(Connection connection) {
        return model.getAll(connection);
    }

    @Override
    public boolean create(Connection connection, TipoEmpleado tipoEmpleado) {
        return model.create(connection, tipoEmpleado) == 1;
    }

    @Override
    public boolean update(Connection connection, TipoEmpleado tipoEmpleado, Object id) {
        return model.update(connection, tipoEmpleado, id) == 1;
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        return model.delete(connection, id) == 1;
    }
}
