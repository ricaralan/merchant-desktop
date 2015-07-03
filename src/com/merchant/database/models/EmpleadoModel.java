package com.merchant.database.models;

import com.merchant.pojos.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alan
 */
public class EmpleadoModel extends MerchantModel {

    String query;
    String queryDomicilio;
    Empleado empleado;
    /*public EmpleadoModel(){
     empleado = new Empleado();
     }*/

    @Override
    public Integer create(Connection connection, Object obj) {
        empleado = (Empleado) obj;
        query = "INSERT INTO empleado(rfcEmpleado,tipoEmpleado_idtipoEmpleado,"
                + "nombreEmpleado,apellidosEmpleado,telefonoEmpleado,mailEmpleado,"
                + "salarioDiarioEmpleado,diasLaboralesEmpleado,altaEmpleado,"
                + "usuario_idUsuario,domicilioFiscal_idDomicilioFiscal,"
                + "sucursal_idSucursal)"
                + "VALUES ('" + empleado.rfcEmpleado + "'," + empleado.tipoEmpleado_idtipoEmpleado + ",'"
                + empleado.nombreEmpleado + "','" + empleado.apellidosEmpleado + "','"
                + empleado.telefonoEmpleado + "','" + empleado.mailEmpleado + "',"
                + empleado.salarioDiarioEmpleado + "," + empleado.diasLaboralesEmpleado + ",'"
                + empleado.altaEmpleado + "'," + empleado.usuario_idUsuario + ","
                + empleado.sucursal_idSucursal + "," + createAddress(connection) + ")";
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    public Integer createAddress(Connection connection) {
        queryDomicilio = "INSERT INTO domiciliofiscal(calle,numExt,numInt,colonia,"
                + "codigoPostal,localidad,municipio,estado,pais)"
                + "VALUES ('" + empleado.calle + "','" + empleado.numExt + "','"
                + empleado.numInt + "','" + empleado.colonia + "','"
                + empleado.codigoPostal + "','" + empleado.localidad + "','"
                + empleado.municipio + "','" + empleado.estado + "','" + empleado.pais + "')";
        Integer res = null;
        try {
            PreparedStatement pstm = connection.prepareStatement(queryDomicilio, Statement.RETURN_GENERATED_KEYS);
            res = pstm.executeUpdate();
            ResultSet keys = pstm.getGeneratedKeys();
            keys.next();
            res = keys.getInt(1);
        } catch (SQLException e) {
            System.err.println(query + "\n" + e.getMessage());
        }
        return res;
    }

    public Integer updateAddress(Connection connection,int id) {
        queryDomicilio = "UPDATE domiciliofiscal SET"
                + "calle = '" + empleado.calle + "',"
                + "numExt = '" + empleado.numExt + "',"
                + "numInt = '" + empleado.numInt + "',"
                + "colonia = '" + empleado.colonia + "',"
                + "codigoPostal = '" + empleado.codigoPostal + "',"
                + "localidad = '" + empleado.localidad + "',"
                + "municipio = '" + empleado.municipio + "',"
                + "estado = '" + empleado.estado + "',"
                + "pais = '" + empleado.pais + "'"
                + "WHERE idDomicilioFiscal = " + id;
        Integer res = null;
        try {
            Statement statement = connection.createStatement();
            res = statement.executeUpdate(queryDomicilio);
        } catch (SQLException e) {
            System.err.println(queryDomicilio + "\n" + e.getMessage());
        }
        return res;
    }

    /*public static void main(String ar[]) {
     MerchantConnection connection = new MerchantConnection();
     EmpleadoModel empModel = new EmpleadoModel();
     empModel.empleado.calle = "kjaskfasdf";
        
     System.out.println(empModel.createAddress(connection.getConnection()));
     }*/
    public Integer update(Connection connection, Empleado obj, int id) {
        empleado = (Empleado) obj;
        
        if (updateAddress(connection,empleado.domicilioFiscal_idDomicilioFiscal) != null) {
            
        }
        query = "UPDATE empleado SET "
                + "rfcEmpleado = '" + empleado.rfcEmpleado + "',"
                + "tipoEmpleado_idtipoEmpleado = " + empleado.tipoEmpleado_idtipoEmpleado + ","
                + "nombreEmpleado = '" + empleado.nombreEmpleado + "',"
                + "apellidosEmpleado = '" + empleado.apellidosEmpleado + "',"
                + "telefonoEmpleado = '" + empleado.telefonoEmpleado + "',"
                + "mailEmpleado = '" + empleado.mailEmpleado + "',"
                + "salarioDiarioEmpleado = " + empleado.salarioDiarioEmpleado + ","
                + "diasLaboralesEmpleado = " + empleado.diasLaboralesEmpleado + ","
                + "altaEmpleado = '" + empleado.altaEmpleado + "',"
                + "usuario_idUsuario = " + empleado.usuario_idUsuario + ","
                + "domicilioFiscal_idDomicilioFiscal = " + empleado.domicilioFiscal_idDomicilioFiscal + ","
                + "sucursal_idSucursal = " + empleado.sucursal_idSucursal + ","
                + "statusEmpleado = '" + empleado.statusEmpleado + "'"
                + "WHERE idEmpleado = " + id+" AND dimicilioFiscal_idDomicialioFiscal = "+empleado.domicilioFiscal_idDomicilioFiscal;
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
        query = "DELETE FROM empleado WHERE idEmpleado=" + id + "";
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
    public List<Object> getAll(Connection connection) {
        List<Object> empleados = new ArrayList<>();
        query = "SELECT * FROM empleado";
        try {
            Statement statement = connection.createStatement();
            ResultSet todasLosEmpleados = statement.executeQuery(query);
            while (todasLosEmpleados.next()) {
                Empleado empleado = new Empleado();
                empleado.idEmpleado = todasLosEmpleados.getInt("idEmpleado");
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return empleados;
    }

    @Override
    public Integer update(Connection connection, Object o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
