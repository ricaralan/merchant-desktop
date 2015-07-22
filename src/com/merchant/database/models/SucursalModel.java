/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.database.models;

import com.merchant.pojos.Sucursal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class SucursalModel extends MerchantModel<Sucursal> {

    @Override
    public List<Sucursal> getAll(Connection connection) {
        List<Sucursal> sucursales = new ArrayList<>();
        String query = "SELECT * FROM sucursal";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLasSucursales = statement.executeQuery(query);
            while (todosLasSucursales.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.id_sucursal = todosLasSucursales.getInt("id_sucursal");
                sucursal.suc_nombre = todosLasSucursales.getString("suc_nombre");
                sucursal.empresa_id_empresa = todosLasSucursales.getInt("empresa_id_empresa");
                sucursal.domicilio_id_domicilio = todosLasSucursales.getInt("domicilio_id_domicilio");
                sucursales.add(sucursal);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return sucursales;
    }

    @Override
    public Integer create(Connection connection, Sucursal o) {
        String query = "INSERT INTO sucursal (suc_nombre,empresa_id_empresa,domicilio_id_domicilio)"
                + " VALUES('" + o.suc_nombre + "'," + o.empresa_id_empresa + ","
                + o.domicilio_id_domicilio + ")";
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
    public Integer update(Connection connection, Sucursal o, Object id) {
        String query = "INSERT INTO sucursal (suc_nombre,"
                + " empresa_id_empresa,domicilio_id_domicilio) "
                + "VALUES('" + o.suc_nombre + "',"
                + o.empresa_id_empresa + ","
                + o.domicilio_id_domicilio + ")";
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
        String query = "DELETE FROM sucursal WHERE idSucursal = " + (Integer) id;
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
    public Sucursal getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
