package com.merchant.database.models;

import com.merchant.pojos.Empresa;
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
public class EmpresaModel extends MerchantModel<Empresa> {

    String query;

    @Override
    public Integer create(Connection connection, Empresa empresa) {
        query = "INSERT INTO empresa(emp_nombre, emp_rfc,"
                + " emp_logo, emp_tel, emp_tel2, emp_email, emp_web,"
                + "regimen_id_regimen) VALUES('" + empresa.emp_nombre
                + "', '" + empresa.emp_rfc + "'," + " '" + empresa.emp_logo + "', '"
                + empresa.emp_tel + "', '" + empresa.emp_tel2 + "', '" + empresa.emp_email
                + "', '" + empresa.emp_web + "', " + empresa.regimen_id_regimen + ")";
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
    public Integer update(Connection connection, Empresa empresa, Object id) {
        query = "UPDATE empresa SET emp_nombre='" + empresa.emp_nombre + "', "
                + "emp_rfc='" + empresa.emp_rfc + "', emp_logo='" + empresa.emp_logo
                + "', emp_tel='" + empresa.emp_tel + "', emp_tel2='"
                + empresa.emp_tel2 + "', emp_email='" + empresa.emp_email
                + "', emp_web='" + empresa.emp_web + "',"
                + "regimen_id_regimen =" + empresa.regimen_id_regimen
                + " WHERE id_empresa=" + id;
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
        query = "DELETE FROM empresa WHERE id_empresa=" + id + "";
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
    public List<Empresa> getAll(Connection connection) {
        List<Empresa> empresas = new ArrayList<>();
        query = "SELECT * FROM empresa";
        try {
            Statement statement = connection.createStatement();
            ResultSet todasLasEmpresas = statement.executeQuery(query);
            while (todasLasEmpresas.next()) {
                Empresa empresa = new Empresa();
                empresa.id_empresa = todasLasEmpresas.getInt("id_empresa");
                empresa.emp_nombre = todasLasEmpresas.getString("emp_nombre");
                empresa.emp_rfc = todasLasEmpresas.getString("emp_rfc");
                empresa.emp_logo = todasLasEmpresas.getString("emp_logo");
                empresa.emp_tel = todasLasEmpresas.getString("emp_tel");
                empresa.emp_tel2 = todasLasEmpresas.getString("emp_tel2");
                empresa.emp_email = todasLasEmpresas.getString("emp_email");
                empresa.emp_web = todasLasEmpresas.getString("emp_web");
                empresa.regimen_id_regimen = todasLasEmpresas.getInt("regimen_id_regimen");
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return empresas;
    }
}
