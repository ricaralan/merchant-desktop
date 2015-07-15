/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.database.models;

import com.merchant.database.MerchantConnection;
import com.merchant.pojos.TipoEmpleado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class TipoEmpleadoModel extends MerchantModel<TipoEmpleado> {

    @Override
    public List<TipoEmpleado> getAll(Connection connection) {
        List<TipoEmpleado> tipoEmpleados = new ArrayList<>();
        String query = "SELECT * FROM tipoempleado";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosTiposEmpleados = statement.executeQuery(query);
            while (todosLosTiposEmpleados.next()) {
                TipoEmpleado tipoEmpleado = new TipoEmpleado();
                tipoEmpleado.idtipoEmpleado = todosLosTiposEmpleados.getInt("idtipoEmpleado");
                tipoEmpleado.tipoEmpleado = todosLosTiposEmpleados.getString("tipoEmpleado");
                tipoEmpleados.add(tipoEmpleado);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tipoEmpleados;
    }

    @Override
    public Integer create(Connection connection, TipoEmpleado o) {
        String query = "INSERT INTO tipoempleado(tipoEmpleado)"
                + " VALUES('" + o.tipoEmpleado + "')";
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
    public Integer update(Connection connection, TipoEmpleado o, Object id) {
        String query = "UPDATE tipoempleado SET tipoEmpleado='"+
                o.tipoEmpleado+"' WHERE idtipoEmpleado ="+(Integer)id;
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
        String query = "DELETE FROM tipoempleado WHERE idtipoEmpleado="+(Integer)id;
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
