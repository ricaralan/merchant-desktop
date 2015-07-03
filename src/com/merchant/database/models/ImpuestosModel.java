package com.merchant.database.models;

import com.merchant.pojos.Impuesto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan
 */
public class ImpuestosModel extends MerchantModel {

    @Override
    public List<Object> getAll(Connection connection) {
        List<Object> impuestos = new ArrayList<>();
        String query = "SELECT * FROM impuesto";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosImpuestos = statement.executeQuery(query);
            while (todosLosImpuestos.next()) {
                Impuesto impuesto = new Impuesto();
                impuesto.idImpuesto = todosLosImpuestos.getInt("idImpuesto");
                impuesto.codigoImpuesto = todosLosImpuestos.getString("codigoImpuesto");
                impuesto.valorImpuesto = todosLosImpuestos.getString("valorImpuesto");
                impuesto.descripcionImpuesto = todosLosImpuestos.getString("descripcionImpuesto");
                impuestos.add(impuesto);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return impuestos;
    }

    @Override
    public Integer create(Connection connection, Object o) {
        Impuesto impuesto = (Impuesto) o;
        String query = "INSERT INTO impuesto(codigoImpuesto,valorImpuesto,descripcionImpuesto)"
                + " VALUES('" + impuesto.codigoImpuesto + "', '"
                + impuesto.valorImpuesto + "', '" + impuesto.descripcionImpuesto + "')";
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
    public Integer update(Connection connection, Object o, Object id) {
        Impuesto impuesto = (Impuesto) o;
        String query = "UPDATE impuesto SET codigoImpuesto='"
                + impuesto.codigoImpuesto + "',valorImpuesto='" + impuesto.valorImpuesto
                + "',descripcionImpuesto='" + impuesto.descripcionImpuesto
                + "' WHERE idImpuesto=" + (Integer) id;
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
        String query = "DELETE FROM impuesto WHERE idImpuesto="+(Integer)id;
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
