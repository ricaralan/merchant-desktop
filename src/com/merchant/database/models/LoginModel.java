package com.merchant.database.models;

import com.merchant.pojos.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.merchant.utils.Encriptation;

/**
 *
 * @author alan
 */
public class LoginModel {
    
    private String query;
    Encriptation encriptation = new Encriptation();
    public User existeUsuario(Connection connection, String user, String password) {
        // TODO mejorar la consulta...
        query = "SELECT * FROM usuario WHERE "
                + "usu_nombre = '" + user + "' AND usu_password = '" 
                + encriptation.encrypt(password) + "' ";
        User usuario = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resUsuario = statement.executeQuery(query);
            if (resUsuario.next()) {
                usuario = new User();
                usuario.usu_nombre = resUsuario.getString("usu_nombre");
            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return usuario;
    }
    
}
