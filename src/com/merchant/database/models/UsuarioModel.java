package com.merchant.database.models;

import com.merchant.pojos.Usuario;
import com.merchant.utils.Encriptation;
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
    Encriptation encriptation = new Encriptation();
    public Usuario getById(Connection connection, Object id) {
        Usuario usuario = new Usuario();
        /*En esta consulta se recogen los usuarios creados previamente y cuando 
         se asigne a un empleado se cambiara el estatus a 2 */
        String query = "SELECT * FROM usuario WHERE usu_status = 1 AND id_usuario = " + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosUsuarios = statement.executeQuery(query);
            if (todosLosUsuarios.next()) {
                usuario.id_usuario = todosLosUsuarios.getInt("id_usuario");
                usuario.nombre = todosLosUsuarios.getString("usu_nombre");
                usuario.password = todosLosUsuarios.getString("usu_password");
                usuario.usu_status = todosLosUsuarios.getInt("usu_status");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return usuario;
    }

    @Override
    public List<Usuario> getAll(Connection connection) {
        List<Usuario> usuarios = new ArrayList<>();
        String query = "SELECT u.*, CASE \n"
                + "WHEN u.usu_status = 0 THEN 'Inactivo'\n"
                + "WHEN u.usu_status = 1 THEN 'Sin Asignar'\n"
                + "WHEN u.usu_status = 2 THEN 'Asignado'\n"
                + "ELSE 'Sin status'\n"
                + "END AS status\n"
                + "FROM usuario u\n"
                + "WHERE u.usu_nombre <> 'admin' ";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosUsuarios = statement.executeQuery(query);
            while (todosLosUsuarios.next()) {
                Usuario usuario = new Usuario();
                usuario.id_usuario = todosLosUsuarios.getInt("id_usuario");
                usuario.nombre = todosLosUsuarios.getString("usu_nombre");
                usuario.password = todosLosUsuarios.getString("usu_password");
                usuario.usu_status = todosLosUsuarios.getInt("usu_status");
                usuario.status = todosLosUsuarios.getString("status");
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return usuarios;
    }

    @Override
    public Integer create(Connection connection, Usuario o) {
        String query = "INSERT INTO usuario (usu_nombre,usu_password,usu_status)"
                + "VALUES ('" + o.nombre +"','"
                + encriptation.encrypt(o.password)+ "',"
                + o.usu_status+")";
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    @Override
    public Integer update(Connection connection, Usuario o, Object id) {
        String query = "UPDATE usuario SET "
                + "usu_nombre = '" + o.nombre + "',"
                + "usu_password = '" + encriptation.encrypt(o.password) + "'"
                + "WHERE id_usuario = " + (Integer) id;
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }
    
    public Integer updatePassword(Connection connection, Usuario o, Object id) {
        String query = "UPDATE usuario SET "
                + "usu_password = '" + encriptation.encrypt(o.new_password) + "'"
                + "WHERE id_usuario = " + (Integer) id;
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }
    
    @Override
    public Integer delete(Connection connection, Object id) {
        /*En esta consulta solo se podra borra a los usuarios que esten inactivos 
         * 0 = Inactivo, 1 = Activo(es cuando se crea)
         * 2 = Asignado (Esta ligado a un empleado y no se podra borrar)
         */
        String query = "DELETE FROM usuario WHERE id_usuario ="+ (Integer) id +" AND usu_status <> 2";
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
