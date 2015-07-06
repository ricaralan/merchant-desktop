package com.merchant.database.models;

import com.merchant.pojos.Empleado;
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
public class EmpleadoModel extends MerchantModel<Empleado> {

    @Override
    public List<Empleado> getAll(Connection connection) {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM empleado";
        try {
            Statement statement = connection.createStatement();
            ResultSet todasLosEmpleados = statement.executeQuery(query);
            while (todasLosEmpleados.next()) {
                Empleado empleado = new Empleado();
                empleado.idEmpleado = todasLosEmpleados.getInt("idEmpleado");
                empleado.nombreEmpleado = todasLosEmpleados.getString("nombreEmpleado");
                empleado.apellidosEmpleado = todasLosEmpleados.getString("apellidosEmpleado");
                empleado.telefonoEmpleado = todasLosEmpleados.getString("telefonoEmpleado");
                empleado.mailEmpleado = todasLosEmpleados.getString("mailEmpleado");
                empleado.salarioDiarioEmpleado = todasLosEmpleados.getFloat("salarioDiarioEmpleado");
                empleado.diasLaboralesEmpleado = todasLosEmpleados.getInt("diasLaboralesEmpleado");
                empleado.altaEmpleado = todasLosEmpleados.getDate("altaEmpleado");
                empleado.usuario_idUsuario = todasLosEmpleados.getInt("usuario_idUsuario");
                empleado.domicilioFiscal_idDomicilioFiscal = todasLosEmpleados.getInt("domicilioFiscal_idDomicilioFiscal");
                empleado.sucursal_idSucursal = todasLosEmpleados.getInt("sucursal_idSucursal");
                empleado.bajaEmpleado = todasLosEmpleados.getDate("bajaEmpleado");
                empleado.statusEmpleado = todasLosEmpleados.getBoolean("statusEmpleado");
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return empleados;
    }

    @Override
    public Integer create(Connection connection, Empleado empleado) {
        String query = "INSERT INTO empleado(rfcEmpleado,tipoEmpleado_idtipoEmpleado,"
                + "nombreEmpleado,apellidosEmpleado,telefonoEmpleado,mailEmpleado,"
                + "salarioDiarioEmpleado,diasLaboralesEmpleado,altaEmpleado,"
                + "usuario_idUsuario,domicilioFiscal_idDomicilioFiscal,"
                + "sucursal_idSucursal)"
                + "VALUES ('" + empleado.rfcEmpleado + "'," + empleado.tipoEmpleado_idtipoEmpleado + ",'"
                + empleado.nombreEmpleado + "','" + empleado.apellidosEmpleado + "','"
                + empleado.telefonoEmpleado + "','" + empleado.mailEmpleado + "',"
                + empleado.salarioDiarioEmpleado + "," + empleado.diasLaboralesEmpleado + ",'"
                + empleado.altaEmpleado + "'," + empleado.usuario_idUsuario + ","
                + empleado.sucursal_idSucursal + "," + /*create(connection)*/ 3 + ")";
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
    public Integer update(Connection connection, Empleado empleado, Object id) {
        /*if (update(connection,empleado.domicilioFiscal_idDomicilioFiscal) != null) {
            
         }*/
        String query = "UPDATE empleado SET "
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
                + "WHERE idEmpleado = " + (Integer) id + " AND dimicilioFiscal_idDomicialioFiscal = " + empleado.domicilioFiscal_idDomicilioFiscal;
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
        String query = "DELETE FROM empleado WHERE idEmpleado=" + (Integer) id + "";
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
