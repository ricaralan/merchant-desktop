package com.merchant.controllers;

import com.merchant.database.models.RegimenModel;
import com.merchant.pojos.Regimen;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alan
 */
public class RegimenesController {

    RegimenModel model;

    public RegimenesController() {
        model = new RegimenModel();
    }

    public List<Object> getRegimenes(Connection connection) {
        return model.getAll(connection);
    }

    public boolean create(Connection connection, Regimen regimen) {
        return model.create(connection, regimen) == 1;
    }

    public boolean update(Connection connection, Regimen regimen, Integer id) {
        return model.update(connection, regimen, id) == 1;
    }

    public boolean delete(Connection connection, Integer id) {
        return model.delete(connection, id) == 1;
    }
}
