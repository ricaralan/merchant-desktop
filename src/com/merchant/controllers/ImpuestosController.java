package com.merchant.controllers;

import com.merchant.database.models.ImpuestosModel;
import com.merchant.pojos.Impuesto;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alan
 */
public class ImpuestosController {

    private ImpuestosModel model;
    
    public ImpuestosController() {
        model = new ImpuestosModel();
    }

    public boolean create(Connection connection, Impuesto impuesto) {
        return model.create(connection, impuesto) == 1;
    }

    public boolean update(Connection connection, Impuesto impuesto, int id) {
        return model.update(connection, impuesto, id) == 1;
    }

    public boolean delete(Connection connection, int id) {
        return model.delete(connection, id) == 1;
    }

    public List<Object> getImpuestos(Connection connection) {
        return model.getAll(connection);
    }
}
