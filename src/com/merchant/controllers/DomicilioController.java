package com.merchant.controllers;

import com.merchant.database.models.DomicilioModel;
import com.merchant.pojos.Domicilio;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class DomicilioController {

    DomicilioModel domicilioModel;

    public DomicilioController() {
        domicilioModel = new DomicilioModel();
    }

    public boolean create(Connection connection, Domicilio domicilio) {
        return domicilioModel.create(connection, domicilio) == 1;
    }
    
    public boolean update(Connection connection, Domicilio domicilio, Integer id) {
        return domicilioModel.update(connection, domicilio, id) == 1;
    }

    public boolean delete(Connection connection, Integer id) {
        return domicilioModel.delete(connection, id) == 1;
    }

    public List<Object> getObjects(Connection connection) {
        return domicilioModel.getAll(connection);
    }
}
