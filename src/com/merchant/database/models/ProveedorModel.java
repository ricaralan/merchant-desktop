package com.merchant.database.models;

import com.merchant.pojos.Proveedor;
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
public class ProveedorModel extends MerchantModel<Proveedor> {

    @Override
    public List<Proveedor> getAll(Connection connection) {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT p.*,CONCAT(d.dom_calle,\" \",d.dom_numExt,\", \",d.dom_localidad,\", Col. \",d.dom_colonia,\", Mpio. \",d.dom_municipio,\",\",d.dom_estado) AS direccion,\n"
                + "CASE\n"
                + "WHEN p.prov_status = 1 THEN 'Activo'\n"
                + "WHEN p.prov_status = 0 THEN 'Inactivo'\n"
                + "WHEN p.prov_status = 2 THEN 'Asignado'\n"
                + "ELSE 'Sin status'\n"
                + "END AS 'status'\n"
                + "FROM proveedor p INNER JOIN domicilio d ON p.domicilio_id_domicilio = d.id_domicilio";
        try {
            Statement statement = connection.createStatement();
            ResultSet todosLosProveedores = statement.executeQuery(query);
            while (todosLosProveedores.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.id_proveedor = todosLosProveedores.getInt("id_proveedor");
                proveedor.rfc = todosLosProveedores.getString("prov_rfc");
                proveedor.nombre = todosLosProveedores.getString("prov_nombre");
                proveedor.prov_apellidos = todosLosProveedores.getString("prov_apellidos");
                proveedor.prov_telefono_celular = todosLosProveedores.getString("prov_telefono_celular");
                proveedor.prov_telefono_casa = todosLosProveedores.getString("prov_telefono_casa");
                proveedor.email = todosLosProveedores.getString("prov_email");
                proveedor.prov_alta = todosLosProveedores.getString("prov_alta");
                proveedor.domicilio_id_domicilio = todosLosProveedores.getInt("domicilio_id_domicilio");
                proveedor.prov_status = todosLosProveedores.getInt("prov_status");           
                proveedor.imagen_proveedor = todosLosProveedores.getString("imagen_proveedor");
                proveedor.prov_baja = todosLosProveedores.getString("prov_baja");
                proveedor.direccion = todosLosProveedores.getString("direccion");
                proveedor.status = todosLosProveedores.getString("status");
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return proveedores;
    }
    
    @Override
    public Integer create(Connection connection, Proveedor proveedor) {
        String query = "INSERT INTO proveedor(prov_rfc,prov_nombre,prov_apellidos,"
                + "prov_telefono_celular,prov_telefono_casa,"
                + "prov_email,prov_status,domicilio_id_domicilio,imagen_proveedor)"
                + "VALUES ('" + proveedor.rfc + "','" + proveedor.nombre + "','"
                + proveedor.prov_apellidos + "','" + proveedor.prov_telefono_casa + "','"
                + proveedor.prov_telefono_celular + "','" + proveedor.email + "',"
                + proveedor.prov_status + "," + proveedor.domicilio_id_domicilio + ",'"
                + proveedor.imagen_proveedor + "')";
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
    public Integer update(Connection connection, Proveedor proveedor, Object id) {
        String query = "UPDATE proveedor SET "
                + "prov_rfc = '" + proveedor.rfc + "',"
                + "prov_nombre = '" + proveedor.nombre + "',"
                + "prov_apellidos = '" + proveedor.prov_apellidos + "',"
                + "prov_telefono_celular = '" + proveedor.prov_telefono_celular + "',"
                + "prov_telefono_casa = '" + proveedor.prov_telefono_casa + "',"
                + "prov_email = '" + proveedor.email + "',"
                + "prov_status = '" + proveedor.prov_status + "',"
                + "domicilio_id_domicilio = " + proveedor.domicilio_id_domicilio + ","
                + "imagen_proveedor = '" + proveedor.imagen_proveedor + "'"
                + "WHERE id_proveedor = " + (Integer) id;
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
        String query = "DELETE FROM proveedor WHERE id_proveedor =" + (Integer) id + "";
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
    public Proveedor getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
