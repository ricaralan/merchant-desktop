package com.merchant.database.models;

import com.merchant.pojos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class UsuarioModel extends MerchantModel<Usuario> {

    public Usuario getById(Connection connection, Object id) {
        Usuario usuario = new Usuario();
        /*En esta consulta se recogen los usuarios creados previamente y cuando 
         se asigne a un empleado se cambiara el estatus a 2 */
        String query = "SELECT * FROM usuario WHERE statusUsuario = 1 and idUsuario="+id;
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosUsuarios = statement.executeQuery(query);
            if (todosLosUsuarios.next()) {
                usuario.idUsuario = todosLosUsuarios.getInt("idUsuario");
                usuario.nombreUsuario = todosLosUsuarios.getString("nombreUsuario");
                usuario.passwordUsuario = todosLosUsuarios.getString("passwordUsuario");
                usuario.statusUsuario = todosLosUsuarios.getInt("statusUsuario");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return usuario;
    }

    @Override
    public List<Usuario> getAll(Connection connection) {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT * FROM usuario ";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosUsuarios = statement.executeQuery(query);
            while (todosLosUsuarios.next()) {
                Usuario usuario = new Usuario();
                usuario.idUsuario = todosLosUsuarios.getInt("idUsuario");
                usuario.nombreUsuario = todosLosUsuarios.getString("nombreUsuario");
                usuario.passwordUsuario = todosLosUsuarios.getString("passwordUsuario");
                usuario.statusUsuario = todosLosUsuarios.getInt("statusUsuario");
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return usuarios;
    }

    @Override
    public Integer create(Connection connection, Usuario o) {
        String query = "INSERT INTO usuario (nombreUsuario,passwordUsuario)"
                + "VALUES ('" + o.nombreUsuario + "','"
                + o.passwordUsuario + "')";
         Integer res = null;
        try {
            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            res = pstm.executeUpdate();
            ResultSet keys = pstm.getGeneratedKeys();
            keys.next();
            res = keys.getInt(1);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    @Override
    public Integer update(Connection connection, Usuario o, Object id) {
        String query = "UPDATE usuario SET"
                + "nombreusuario = '" + o.nombreUsuario + "',"
                + "passwordUsuario = '" + o.passwordUsuario + "',"
                + "statusUsuario = '" + o.statusUsuario + "',"
                + "WHERE idUsuario = " + (Integer) id;
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    public Integer delete(Connection connection, Object id) {
        /*En esta consulta solo se podra borra a los usuarios que esten inactivos 
         * 0 = Inactivo, 1 = Activo(es cuando se crea)
         * 2 = Asignado (Esta ligado a un empleado y no se podra borrar)
         */
        String query = "DELETE FROM usuario WHERE idUsuario AND statusUsuario = 0" + (Integer) id + "";
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

}
