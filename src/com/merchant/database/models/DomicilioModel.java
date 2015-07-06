package com.merchant.database.models;

import com.merchant.pojos.Domicilio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class DomicilioModel extends MerchantModel<Domicilio> {

    @Override
    public List<Domicilio> getAll(Connection connection) {
        List<Domicilio> domicilios = new ArrayList<>();
        String query = "SELECT * FROM domiciliofiscal";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosDomicilios = statement.executeQuery(query);
            while (todosLosDomicilios.next()) {
                Domicilio domicilio = new Domicilio();
                domicilio.idDomicilioFiscal = todosLosDomicilios.getInt("idDomicilioFiscal");
                domicilio.calle = todosLosDomicilios.getString("calle");
                domicilio.numExt = todosLosDomicilios.getString("numExt");
                domicilio.numInt = todosLosDomicilios.getString("numInt");
                domicilio.colonia = todosLosDomicilios.getString("colonia");
                domicilio.codigoPostal = todosLosDomicilios.getString("codigoPostal");
                domicilio.localidad = todosLosDomicilios.getString("localidad");
                domicilio.municipio = todosLosDomicilios.getString("municipio");
                domicilio.estado = todosLosDomicilios.getString("estado");
                domicilio.pais = todosLosDomicilios.getString("pais");
                domicilios.add(domicilio);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return domicilios;
    }

    @Override
    public Integer create(Connection connection, Domicilio domicilio) {
        String query = "INSERT INTO domiciliofiscal(calle,numExt,numInt,colonia,"
                + "codigoPostal,localidad,municipio,estado,pais)"
                + "VALUES ('" + domicilio.calle + "','" + domicilio.numExt + "','"
                + domicilio.numInt + "','" + domicilio.colonia + "','"
                + domicilio.codigoPostal + "','" + domicilio.localidad + "','"
                + domicilio.municipio + "','" + domicilio.estado + "','" + domicilio.pais + "')";
        Integer res = null;
        try {
            PreparedStatement pstm = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            res = pstm.executeUpdate();
            ResultSet keys = pstm.getGeneratedKeys();
            keys.next();
            res = keys.getInt(1);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    @Override
    public Integer update(Connection connection, Domicilio domicilio, Object id) {
        String query = "UPDATE domiciliofiscal SET"
                + "calle = '" + domicilio.calle + "',"
                + "numExt = '" + domicilio.numExt + "',"
                + "numInt = '" + domicilio.numInt + "',"
                + "colonia = '" + domicilio.colonia + "',"
                + "codigoPostal = '" + domicilio.codigoPostal + "',"
                + "localidad = '" + domicilio.localidad + "',"
                + "municipio = '" + domicilio.municipio + "',"
                + "estado = '" + domicilio.estado + "',"
                + "pais = '" + domicilio.pais + "'"
                + "WHERE idDomicilioFiscal = " + (Integer) id;
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
        String query = "DELETE FROM domiciliofiscal WHERE idDomicilioFiscal=" + (Integer) id + "";
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
