package com.merchant.controllers;

import com.merchant.database.models.EmpresaModel;
import com.merchant.pojos.Empresa;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alan
 */
public class EmpresaController extends MerchantController<Empresa> {

    private final EmpresaModel empresaModel;

    public EmpresaController() {
        empresaModel = new EmpresaModel();
    }

    @Override
    public boolean create(Connection connection, Empresa empresa) {
        return empresaModel.create(connection, empresa) == 1;
    }

    @Override
    public boolean update(Connection connection, Empresa empresa, Object id) {
        return empresaModel.update(connection, (Empresa) empresa, (int) id) == 1;
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        return empresaModel.delete(connection, (int) id) == 1;
    }

    @Override
    public List<Empresa> getAll(Connection connection) {
        return empresaModel.getAll(connection);
    }
}
