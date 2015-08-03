package com.merchant.database.models;

import com.merchant.pojos.Cliente;
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
public class ClienteModel extends MerchantModel<Cliente> {

    @Override
    public List<Cliente> getAll(Connection connection) {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT c.*,CONCAT(d.dom_calle,\" \",d.dom_numExt,\", \",d.dom_localidad,\", Col. \",d.dom_colonia,\", Mpio. \",d.dom_municipio,\",\",d.dom_estado) AS direccion,\n"
                + "CASE\n"
                + "WHEN c.clte_status = 1 THEN 'Activo'\n"
                + "WHEN c.clte_status = 0 THEN 'Inactivo'\n"
                + "WHEN c.clte_status = 2 THEN 'Asignado'\n"
                + "ELSE 'Sin status'\n"
                + "END AS 'status'\n"
                + "FROM cliente c INNER JOIN domicilio d ON c.domicilio_id_domicilio = d.id_domicilio";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosClientes = statement.executeQuery(query);
            while (todosLosClientes.next()) {
                Cliente cliente = new Cliente();
                cliente.id_cliente = todosLosClientes.getInt("id_cliente");
                cliente.rfc = todosLosClientes.getString("clte_rfc");
                cliente.nombre = todosLosClientes.getString("clte_nombre");
                cliente.clte_apellidos = todosLosClientes.getString("clte_apellidos");
                cliente.clte_telefono_celular = todosLosClientes.getString("clte_telefono_celular");
                cliente.clte_telefono_casa = todosLosClientes.getString("clte_telefono_casa");
                cliente.email = todosLosClientes.getString("clte_email");
                cliente.clte_alta = todosLosClientes.getString("clte_alta");
                cliente.domicilio_id_domicilio = todosLosClientes.getInt("domicilio_id_domicilio");
                cliente.clte_status = todosLosClientes.getInt("clte_status");           
                cliente.imagen_cliente = todosLosClientes.getString("imagen_cliente");
                cliente.clte_baja = todosLosClientes.getString("clte_baja");
                cliente.direccion = todosLosClientes.getString("direccion");
                cliente.status = todosLosClientes.getString("status");
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return clientes;
    }

    @Override
    public Integer create(Connection connection, Cliente cliente) {
        String query = "INSERT INTO cliente(clte_rfc,clte_nombre,clte_apellidos,"
                + "clte_telefono_celular,clte_telefono_casa,"
                + "clte_email,clte_status,domicilio_id_domicilio,imagen_cliente)"
                + "VALUES ('" + cliente.rfc + "','" + cliente.nombre + "','"
                + cliente.clte_apellidos + "','" + cliente.clte_telefono_casa + "','"
                + cliente.clte_telefono_celular + "','" + cliente.email + "',"
                + cliente.clte_status + "," + cliente.domicilio_id_domicilio + ",'"
                + cliente.imagen_cliente + "')";
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
    public Integer update(Connection connection, Cliente cliente, Object id) {
        String query = "UPDATE cliente SET "
                + "clte_rfc = '" + cliente.rfc + "',"
                + "clte_nombre = '" + cliente.nombre + "',"
                + "clte_apellidos = '" + cliente.clte_apellidos + "',"
                + "clte_telefono_celular = '" + cliente.clte_telefono_celular + "',"
                + "clte_telefono_casa = '" + cliente.clte_telefono_casa + "',"
                + "clte_email = '" + cliente.email + "',"
                + "clte_status = '" + cliente.clte_status + "',"
                + "domicilio_id_domicilio = " + cliente.domicilio_id_domicilio + ","
                + "imagen_cliente = '" + cliente.imagen_cliente + "'"
                + "WHERE id_cliente = " + (Integer) id;
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
        String query = "DELETE FROM cliente WHERE id_cliente =" + (Integer) id + "";
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
    public Cliente getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
