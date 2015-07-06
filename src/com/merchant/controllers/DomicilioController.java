package com.merchant.controllers;

import com.merchant.database.models.DomicilioModel;
import com.merchant.pojos.Domicilio;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class DomicilioController extends MerchantController<Domicilio> {

    DomicilioModel domicilioModel;

    public DomicilioController() {
        domicilioModel = new DomicilioModel();
    }

    @Override
    public boolean create(Connection connection, Domicilio domicilio) {
        return domicilioModel.create(connection, domicilio) == 1;
    }

    @Override
    public boolean update(Connection connection, Domicilio domicilio, Object id) {
        return domicilioModel.update(connection, domicilio, id) == 1;
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        return domicilioModel.delete(connection, id) == 1;
    }

    @Override
    public List<Domicilio> getAll(Connection connection) {
        return domicilioModel.getAll(connection);
    }
}
