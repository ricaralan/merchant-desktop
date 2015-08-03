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
        String query = "SELECT\n"
                + "	e.*, te.tipo_empleado, s.suc_nombre,IFNULL(u.usu_nombre,'Sin asignar') AS usuario,\n"
                + "CONCAT(d.dom_calle,\" \",d.dom_numExt,\", \",d.dom_localidad,\", Col. \",d.dom_colonia,\", Mpio. \",d.dom_municipio,\", \",d.dom_estado) AS direccion,\n"
                + "(e.emp_dias_laborales * e.emp_salario_diario) AS percepcion,\n"
                + "CASE\n"
                + "WHEN e.emp_status = 1 THEN 'Activo'\n"
                + "WHEN e.emp_status = 0 THEN 'Inactivo'\n"
                + "WHEN e.emp_status = 2 THEN 'Asignado'\n"
                + "ELSE 'Sin status'\n"
                + "END AS 'status'\n"
                + "FROM (((empleado e \n"
                + "		LEFT JOIN tipo_empleado te ON e.tipo_empleado_id_tipo_empleado = te.id_tipo_empleado )\n"
                + "		LEFT JOIN sucursal s ON e.sucursal_id_sucursal = s.id_sucursal)\n"
                + "		LEFT JOIN usuario u ON e.usuario_id_usuario = u.id_usuario)\n"
                + "		LEFT JOIN domicilio d ON e.domicilio_id_domicilio = d.id_domicilio\n"
                + "WHERE e.emp_nombre <> 'Administrador'";
        try {
            Statement statement = connection.createStatement();
            ResultSet todasLosEmpleados = statement.executeQuery(query);
            while (todasLosEmpleados.next()) {
                Empleado empleado = new Empleado();
                empleado.id_empleado = todasLosEmpleados.getInt("id_empleado");
                empleado.tipo_empleado_id_tipo_empleado = todasLosEmpleados.getInt("tipo_empleado_id_tipo_empleado");
                empleado.rfc = todasLosEmpleados.getString("emp_rfc");
                empleado.nombre = todasLosEmpleados.getString("emp_nombre");
                empleado.emp_apellidos = todasLosEmpleados.getString("emp_apellidos");
                empleado.emp_telefono_celular = todasLosEmpleados.getString("emp_telefono_celular");
                empleado.emp_telefono_casa = todasLosEmpleados.getString("emp_telefono_casa");
                empleado.email = todasLosEmpleados.getString("emp_email");
                empleado.emp_salario_diario = todasLosEmpleados.getFloat("emp_salario_diario");
                empleado.emp_dias_laborales = todasLosEmpleados.getInt("emp_dias_laborales");
                empleado.emp_alta = todasLosEmpleados.getString("emp_alta");
                empleado.usuario_id_usuario = todasLosEmpleados.getInt("usuario_id_usuario");
                empleado.domicilio_id_domicilio = todasLosEmpleados.getInt("domicilio_id_domicilio");
                empleado.sucursal_id_sucursal = todasLosEmpleados.getInt("sucursal_id_sucursal");
                empleado.emp_baja = todasLosEmpleados.getString("emp_baja");
                empleado.emp_status = todasLosEmpleados.getInt("emp_status");
                empleado.imagen_empleado = todasLosEmpleados.getString("imagen_empleado");
                empleado.tipo_empleado = todasLosEmpleados.getString("tipo_empleado");
                empleado.suc_nombre = todasLosEmpleados.getString("suc_nombre");
                empleado.usuario = todasLosEmpleados.getString("usuario");
                empleado.direccion = todasLosEmpleados.getString("direccion");
                empleado.percepcion = todasLosEmpleados.getFloat("percepcion");
                empleado.status = todasLosEmpleados.getString("status");
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
                + "VALUES ('" + empleado.rfc + "'," + empleado.tipo_empleado_id_tipo_empleado + ",'"
                + empleado.nombre + "','" + empleado.emp_apellidos + "','"
                + empleado.emp_telefono_casa + "','" + empleado.emp_telefono_celular + "','"
                + empleado.email + "'," + empleado.emp_salario_diario + ","
                + empleado.emp_dias_laborales + "," + empleado.usuario_id_usuario + ","
                + empleado.domicilio_id_domicilio + "," + empleado.sucursal_id_sucursal + ","
                + empleado.emp_status + ",'" + empleado.imagen_empleado + "')";
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
        String query = "UPDATE empleado SET "
                + "emp_rfc = '" + empleado.rfc + "',"
                + "tipo_empleado_id_tipo_empleado = " + empleado.tipo_empleado_id_tipo_empleado + ","
                + "emp_nombre = '" + empleado.nombre + "',"
                + "emp_apellidos = '" + empleado.emp_apellidos + "',"
                + "emp_telefono_celular = '" + empleado.emp_telefono_celular + "',"
                + "emp_telefono_casa = '" + empleado.emp_telefono_casa + "',"
                + "emp_email = '" + empleado.email + "',"
                + "emp_salario_diario = " + empleado.emp_salario_diario + ","
                + "emp_dias_laborales = " + empleado.emp_dias_laborales + ","
                + "usuario_id_usuario = " + empleado.usuario_id_usuario + ","
                + "domicilio_id_domicilio = " + empleado.domicilio_id_domicilio + ","
                + "sucursal_id_sucursal = " + empleado.sucursal_id_sucursal + ","
                + "emp_status = '" + empleado.emp_status + "',"
                + "imagen_empleado = '" + empleado.imagen_empleado + "'"
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
