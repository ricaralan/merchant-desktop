package com.merchant.controllers;

import com.merchant.database.models.UsuarioModel;
import com.merchant.pojos.Usuario;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class UsuarioController extends MerchantController<Usuario> {

    UsuarioModel usuarioModel;

    public UsuarioController() {
        usuarioModel = new UsuarioModel();
    }

    @Override
    public boolean create(Connection connection, Usuario usuario) {
        return usuarioModel.create(connection, usuario) == 1;
    }

    @Override
    public boolean update(Connection connection, Usuario domicilio, Object id) {
        return usuarioModel.update(connection, domicilio, id) == 1;
    }

    @Override
    public boolean delete(Connection connection, Object id) {
        return usuarioModel.delete(connection, id) == 1;
    }

    @Override
    public List<Usuario> getAll(Connection connection) {
        return usuarioModel.getAll(connection);
    }

    @Override
    public Usuario getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
