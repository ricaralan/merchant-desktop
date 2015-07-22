/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.database.models;

import com.merchant.pojos.TipoEmpleado;
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
public class TipoEmpleadoModel extends MerchantModel<TipoEmpleado> {

    @Override
    public List<TipoEmpleado> getAll(Connection connection) {
        List<TipoEmpleado> tipoEmpleados = new ArrayList<>();
        String query = "SELECT * FROM tipo_empleado";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosTiposEmpleados = statement.executeQuery(query);
            while (todosLosTiposEmpleados.next()) {
                TipoEmpleado tipoEmpleado = new TipoEmpleado();
                tipoEmpleado.id_tipo_empleado = todosLosTiposEmpleados.getInt("id_tipo_empleado");
                tipoEmpleado.tipo_empleado = todosLosTiposEmpleados.getString("tipo_empleado");
                tipoEmpleados.add(tipoEmpleado);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return tipoEmpleados;
    }

    @Override
    public Integer create(Connection connection, TipoEmpleado o) {
        String query = "INSERT INTO tipo_empleado(tipo_empleado)"
                + " VALUES('" + o.tipo_empleado + "')";
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
        String query = "UPDATE tipo_empleado SET tipo_empleado='"+
                o.tipo_empleado+"' WHERE id_tipo_empleado ="+(Integer)id;
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
        String query = "DELETE FROM tipo_empleado WHERE id_tipo_empleado = "+(Integer)id;
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
    public TipoEmpleado getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
