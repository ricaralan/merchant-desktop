/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.database.models;

import com.merchant.pojos.Regimen;
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
public class RegimenModel extends MerchantModel<Regimen> {

    @Override
    public List<Regimen> getAll(Connection connection) {
        List<Regimen> regimenes = new ArrayList<>();
        String query = "SELECT * FROM regimenFiscal";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosRegimenes = statement.executeQuery(query);
            while (todosLosRegimenes.next()) {
                Regimen regimen = new Regimen();
                regimen.idregimenFiscal = todosLosRegimenes.getInt("idregimenFiscal");
                regimen.descripcionRegimenFiscal = todosLosRegimenes.getString("descripcionRegimenFiscal");
                regimenes.add(regimen);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return regimenes;
    }

    @Override
    public Integer create(Connection connection, Regimen regimen) {
        String query = "INSERT INTO regimenFiscal(descripcionRegimenFiscal)"
                + " VALUES('" + regimen.descripcionRegimenFiscal + "')";
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
    public Integer update(Connection connection, Regimen regimen, Object id) {
        String query = "UPDATE regimenFiscal SET descripcionRegimenFiscal='"
                + regimen.descripcionRegimenFiscal + "' WHERE idregimenFiscal=" + (Integer) id;
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
        String query = "DELETE FROM regimenFiscal WHERE idregimenFiscal=" + (Integer) id;
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
