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
public class ImpuestosModel extends MerchantModel<Impuesto> {

    @Override
    public List<Impuesto> getAll(Connection connection) {
        List<Impuesto> impuestos = new ArrayList<>();
        String query = "SELECT * FROM impuesto";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosImpuestos = statement.executeQuery(query);
            while (todosLosImpuestos.next()) {
                Impuesto impuesto = new Impuesto();
                impuesto.id_impuesto = todosLosImpuestos.getInt("id_impuesto");
                impuesto.impto_codigo = todosLosImpuestos.getString("impto_codigo");
                impuesto.impto_descripcion = todosLosImpuestos.getString("impto_descripcion");
                impuesto.impto_valor = todosLosImpuestos.getString("impto_valor");
                impuestos.add(impuesto);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return impuestos;
    }

    @Override
    public Integer create(Connection connection, Impuesto o) {
        Impuesto impuesto = (Impuesto) o;
        String query = "INSERT INTO impuesto(impto_codigo,impto_descripcion,impto_valor)"
                + " VALUES('" + impuesto.impto_codigo + "', '"
                + impuesto.impto_descripcion + "', '" + impuesto.impto_valor + "')";
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
    public Integer update(Connection connection, Impuesto o, Object id) {
        Impuesto impuesto = (Impuesto) o;
        String query = "UPDATE impuesto SET impto_codigo='"
                + impuesto.impto_codigo + "',impto_valor='" + impuesto.impto_valor
                + "',impto_descripcion ='" + impuesto.impto_descripcion
                + "' WHERE id_impuesto=" + (Integer) id;
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
        String query = "DELETE FROM impuesto WHERE id_impuesto=" + (Integer) id;
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
