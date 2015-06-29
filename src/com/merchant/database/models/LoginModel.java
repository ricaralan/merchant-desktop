package com.merchant.database.models;

import com.merchant.pojos.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alan
 */
public class LoginModel {
    
    private String query;

    public User existeUsuario(Connection connection, String user, String password) {
        // TODO mejorar la consulta...
        query = "SELECT * FROM usuario WHERE "
                + "nombreUsuario='" + user + "' AND passwordUsuario='" + password + "' ";
        User usuario = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resUsuario = statement.executeQuery(query);
            if (resUsuario.next()) {
                usuario = new User();
                usuario.name = resUsuario.getString("nombreUsuario");
            }
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return usuario;
    }
    
}
