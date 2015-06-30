package com.merchant.controllers;

import com.merchant.database.models.EmpresaModel;
import com.merchant.pojos.Empresa;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alan
 */
public class EmpresaController {

    EmpresaModel empresaModel;

    public EmpresaController() {
        empresaModel = new EmpresaModel();
    }

    public boolean create(Connection connection, Empresa empresa) {
        return empresaModel.create(connection, empresa) == 1;
    }

    public boolean delete(Connection connection, int id) {
        return empresaModel.delete(connection, id) == 1;
    }

    public List<Empresa> getEmpresas(Connection connection) {
        return empresaModel.getEmpresas(connection);
    }
}
