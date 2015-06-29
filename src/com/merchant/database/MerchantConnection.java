package com.merchant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alan
 */
public class MerchantConnection {

    private Connection connection = null;
    private String database, userDB, passwordDB;

    public MerchantConnection() {
        database = "merchant";
        userDB = "root";
        passwordDB = "RAOR940203";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + database, userDB, passwordDB);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
