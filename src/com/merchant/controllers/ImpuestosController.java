package com.merchant.controllers;

import com.merchant.database.models.ImpuestosModel;
import com.merchant.pojos.Impuesto;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alan
 */
public class ImpuestosController extends MerchantController<Impuesto> {

    private final ImpuestosModel model;

    public ImpuestosController() {
        model = new ImpuestosModel();
    }

    @Override
    public boolean create(Connection connection, Impuesto impuesto) {
        return model.create(connection, impuesto) == 1;
    }

    @Override
    public boolean update(Connection connection, Impuesto impuesto, Object id) {
        return model.update(connection, impuesto, id) == 1;
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        return model.delete(connection, id) == 1;
    }

    @Override
    public List<Impuesto> getAll(Connection connection) {
        return model.getAll(connection);
    }

    @Override
    public Impuesto getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
