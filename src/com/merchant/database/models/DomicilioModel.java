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
        String query = "SELECT * FROM domicilio";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosDomicilios = statement.executeQuery(query);
            while (todosLosDomicilios.next()) {
                Domicilio domicilio = new Domicilio();
                domicilio.id_domicilio = todosLosDomicilios.getInt("id_domicilio");
                domicilio.dom_calle = todosLosDomicilios.getString("dom_calle");
                domicilio.dom_numExt = todosLosDomicilios.getString("dom_numExt");
                domicilio.dom_numInt = todosLosDomicilios.getString("dom_numInt");
                domicilio.dom_colonia = todosLosDomicilios.getString("dom_colonia");
                domicilio.dom_cod_postal = todosLosDomicilios.getString("dom_cod_postal");
                domicilio.dom_localidad = todosLosDomicilios.getString("dom_localidad");
                domicilio.dom_municipio = todosLosDomicilios.getString("dom_municipio");
                domicilio.dom_estado = todosLosDomicilios.getString("dom_estado");
                domicilio.dom_pais = todosLosDomicilios.getString("dom_pais");
                domicilios.add(domicilio);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return domicilios;
    }

    @Override
    public Integer create(Connection connection, Domicilio domicilio) {
        String query = "INSERT INTO domicilio(dom_calle,dom_numExt,dom_numInt,dom_colonia,"
                + "dom_cod_postal,dom_localidad,dom_municipio,dom_estado,dom_pais)"
                + "VALUES ('" + domicilio.dom_calle + "','" + domicilio.dom_numExt + "','"
                + domicilio.dom_numInt + "','" + domicilio.dom_colonia + "','"
                + domicilio.dom_cod_postal + "','" + domicilio.dom_localidad + "','"
                + domicilio.dom_municipio + "','" + domicilio.dom_estado + "','" + domicilio.dom_pais + "')";
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
        String query = "UPDATE domicilio SET"
                + "dom_calle = '" + domicilio.dom_calle + "',"
                + "dom_numExt = '" + domicilio.dom_numExt + "',"
                + "dom_numInt = '" + domicilio.dom_numInt + "',"
                + "dom_colonia = '" + domicilio.dom_colonia + "',"
                + "dom_cod_postal = '" + domicilio.dom_cod_postal + "',"
                + "dom_localidad = '" + domicilio.dom_localidad + "',"
                + "dom_municipio = '" + domicilio.dom_municipio + "',"
                + "dom_estado = '" + domicilio.dom_estado + "',"
                + "dom_pais = '" + domicilio.dom_pais + "'"
                + "WHERE id_domicilio = " + (Integer) id;
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
        String query = "DELETE FROM domicilio WHERE id_domicilio=" + (Integer) id + "";
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }
    
    public Domicilio getById(Connection connection, Object id) {
        String query = "SELECT * FROM domicilio WHERE id_domicilio="+id;
        Domicilio domicilio = new Domicilio();
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosDomicilios = statement.executeQuery(query);
            while (todosLosDomicilios.next()) {
                
                domicilio.id_domicilio = todosLosDomicilios.getInt("id_domicilio");
                domicilio.dom_calle = todosLosDomicilios.getString("dom_calle");
                domicilio.dom_numExt = todosLosDomicilios.getString("dom_numExt");
                domicilio.dom_numInt = todosLosDomicilios.getString("dom_numInt");
                domicilio.dom_colonia = todosLosDomicilios.getString("dom_colonia");
                domicilio.dom_cod_postal = todosLosDomicilios.getString("dom_cod_postal");
                domicilio.dom_localidad = todosLosDomicilios.getString("dom_localidad");
                domicilio.dom_municipio = todosLosDomicilios.getString("dom_municipio");
                domicilio.dom_estado = todosLosDomicilios.getString("dom_estado");
                domicilio.dom_pais = todosLosDomicilios.getString("dom_pais");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return domicilio;
    }

}
