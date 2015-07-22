package com.merchant.controllers;

import com.merchant.database.models.RegimenModel;
import com.merchant.pojos.Regimen;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alan
 */
public class RegimenesController extends MerchantController<Regimen> {

    RegimenModel model;

    public RegimenesController() {
        model = new RegimenModel();
    }

    @Override
    public List<Regimen> getAll(Connection connection) {
        return model.getAll(connection);
    }

    @Override
    public boolean create(Connection connection, Regimen regimen) {
        return model.create(connection, regimen) == 1;
    }

    @Override
    public boolean update(Connection connection, Regimen regimen, Object id) {
        return model.update(connection, regimen, id) == 1;
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        return model.delete(connection, id) == 1;
    }

    @Override
    public Regimen getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
