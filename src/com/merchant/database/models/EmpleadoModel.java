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
                empleado.id_empleado = todasLosEmpleados.getInt("id_empleado");
                empleado.tipo_empleado_id_tipo_empleado = todasLosEmpleados.getInt("tipo_empleado_id_tipo_empleado");
                empleado.emp_rfc = todasLosEmpleados.getString("emp_rfc");
                empleado.emp_nombre = todasLosEmpleados.getString("emp_nombre");
                empleado.emp_apellidos = todasLosEmpleados.getString("emp_apellidos");
                empleado.emp_telefono_celular = todasLosEmpleados.getString("emp_telefono_celular");
                empleado.emp_telefono_casa = todasLosEmpleados.getString("emp_telefono_casa");
                empleado.emp_email = todasLosEmpleados.getString("emp_email");
                empleado.emp_salario_diario = todasLosEmpleados.getFloat("emp_salario_diario");
                empleado.emp_dias_laborales = todasLosEmpleados.getInt("emp_dias_laborales");
                empleado.emp_alta = todasLosEmpleados.getString("emp_alta");
                empleado.usuario_id_usuario = todasLosEmpleados.getInt("usuario_id_usuario");
                empleado.domicilio_id_domicilio = todasLosEmpleados.getInt("domicilio_id_domicilio");
                empleado.sucursal_id_sucursal = todasLosEmpleados.getInt("sucursal_id_sucursal");
                empleado.emp_baja = todasLosEmpleados.getString("emp_baja");
                empleado.emp_status = todasLosEmpleados.getInt("emp_status");
                empleado.imagen_empleado = todasLosEmpleados.getString("imagen_empleado");
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return empleados;
    }

    @Override
    public Integer create(Connection connection, Empleado empleado) {
        String query = "INSERT INTO empleado(emp_rfc,tipo_empleado_id_tipo_empleado,"
                + "emp_nombre,emp_apellidos,emp_telefono_celular,emp_telefono_casa,emp_email,"
                + "emp_salario_diario,emp_dias_laborales,"
                + "usuario_id_usuario,domicilio_id_domicilio,"
                + "sucursal_id_sucursal,emp_status,imagen_empleado)"
                + "VALUES ('" + empleado.emp_rfc + "'," + empleado.tipo_empleado_id_tipo_empleado + ",'"
                + empleado.emp_nombre + "','" + empleado.emp_apellidos + "','"
                + empleado.emp_telefono_casa +"','" + empleado.emp_telefono_celular + "','" 
                + empleado.emp_email + "'," + empleado.emp_salario_diario+ "," 
                + empleado.emp_dias_laborales + "," + empleado.usuario_id_usuario + ","
                + empleado.domicilio_id_domicilio + "," +  empleado.sucursal_id_sucursal+","
                + empleado.emp_status+",'"+empleado.imagen_empleado+"')";
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
        /*if (update(connection,empleado.domicilio_id_domicilio) != null) {
            
         }*/
        String query = "UPDATE empleado SET "
                + "emp_rfc = '" + empleado.emp_rfc + "',"
                + "tipo_empleado_id_tipo_empleado = " + empleado.tipo_empleado_id_tipo_empleado + ","
                + "emp_nombre = '" + empleado.emp_nombre + "',"
                + "emp_apellidos = '" + empleado.emp_apellidos + "',"
                + "emp_telefono_celular = '" + empleado.emp_telefono_celular + "',"
                + "emp_telefono_casa = '" + empleado.emp_telefono_casa + "',"
                + "emp_email = '" + empleado.emp_email + "',"
                + "emp_salario_diario = " + empleado.emp_salario_diario + ","
                + "emp_dias_laborales = " + empleado.emp_dias_laborales + ","
                + "usuario_id_usuario = " + empleado.usuario_id_usuario + ","
                + "domicilio_id_domicilio = " + empleado.domicilio_id_domicilio + ","
                + "sucursal_id_sucursal = " + empleado.sucursal_id_sucursal + ","
                + "emp_status = '" + empleado.emp_status + "'"
                + "WHERE id_empleado = " + (Integer) id;
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
        String query = "DELETE FROM empleado WHERE id_empleado =" + (Integer) id + "";
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
    public Empleado getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
