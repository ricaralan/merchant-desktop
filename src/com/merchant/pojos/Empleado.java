package com.merchant.pojos;

import com.merchant.utils.validate.annotations.Email;
import com.merchant.utils.validate.annotations.NotEmpty;
import com.merchant.utils.validate.annotations.NotNull;
import com.merchant.utils.validate.annotations.RFC;
/**
 *
 * @author Eleazar
 */
public class Empleado {

    public int id_empleado;
    @RFC
    public String rfc;
    public int tipo_empleado_id_tipo_empleado;
    @NotEmpty
    public String nombre;
    public String emp_apellidos;
    public String emp_telefono_celular; 
    public String emp_telefono_casa;
    @Email
    @NotNull
    public String email;
    public float emp_salario_diario;
    public float emp_dias_laborales; 
    public String emp_alta;
    public Integer usuario_id_usuario;
    public int domicilio_id_domicilio;
    public int sucursal_id_sucursal;
    public String emp_baja;
    public int emp_status;
    public String imagen_empleado;
    /**
     * Estos campos se agregaron por el join que se hizo en la consulta
     * y asi evitar que se hagan mas llamadas a la base de datos
     */
    public String tipo_empleado;
    public String suc_nombre;
    public String usuario;
    public String direccion;
    public float percepcion;
    public String status;
    
}
