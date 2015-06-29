package com.merchant.controllers;

import com.merchant.database.models.LoginModel;
import com.merchant.pojos.User;
import java.sql.Connection;

/**
 *
 * @author alan
 */
public class LoginController {

    public User existeUsuario(Connection connection, String user, String password) {
        return new LoginModel().existeUsuario(connection, user, password);
    }

}
