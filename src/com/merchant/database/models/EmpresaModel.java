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
        query = "INSERT INTO empresa(nombreEmpresa, rfcEmpresa,"
                + " logoEmpresa, telEmpresa, tel2Empresa, mailEmpresa, webEmpresa,"
                + "regimenFiscal_idregimenFiscal) VALUES('" + empresa.nombre
                + "', '" + empresa.rfc + "'," + " '" + empresa.logo + "', '"
                + empresa.tel + "', '" + empresa.tel2 + "', '" + empresa.email
                + "', '" + empresa.web + "', " + empresa.regimenFiscal_idregimenFiscal + ")";
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
        query = "UPDATE empresa SET nombreEmpresa='" + empresa.nombre + "', "
                + "rfcEmpresa='" + empresa.rfc + "', logoEmpresa='" + empresa.logo
                + "', telEmpresa='" + empresa.tel + "', tel2Empresa='"
                + empresa.tel2 + "', mailEmpresa='" + empresa.email
                + "', webEmpresa='" + empresa.web + "',"
                + "regimenFiscal_idregimenFiscal=" + empresa.regimenFiscal_idregimenFiscal
                + " WHERE idEmpresa=" + id;
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
        query = "DELETE FROM empresa WHERE idEmpresa=" + id + "";
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    public List<Empresa> getAll(Connection connection) {
        List<Empresa> empresas = new ArrayList<>();
        query = "SELECT * FROM empresa";
        try {
            Statement statement = connection.createStatement();
            ResultSet todasLasEmpresas = statement.executeQuery(query);
            while (todasLasEmpresas.next()) {
                Empresa empresa = new Empresa();
                empresa.id = todasLasEmpresas.getInt("idEmpresa");
                empresa.nombre = todasLasEmpresas.getString("nombreEmpresa");
                empresa.rfc = todasLasEmpresas.getString("rfcEmpresa");
                empresa.logo = todasLasEmpresas.getString("logoEmpresa");
                empresa.tel = todasLasEmpresas.getString("telEmpresa");
                empresa.tel2 = todasLasEmpresas.getString("tel2Empresa");
                empresa.email = todasLasEmpresas.getString("mailEmpresa");
                empresa.web = todasLasEmpresas.getString("webEmpresa");
                empresa.regimenFiscal_idregimenFiscal = todasLasEmpresas.getInt("regimenFiscal_idregimenFiscal");
                empresas.add(empresa);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return empresas;
    }
}
