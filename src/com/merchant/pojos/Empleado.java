package com.merchant.pojos;

import com.merchant.utils.validate.annotations.Email;
import com.merchant.utils.validate.annotations.NotNull;
import com.merchant.utils.validate.annotations.RFC;
/**
 *
 * @author Eleazar
 */
public class Empleado {

    public int id_empleado;
    @RFC
    public String emp_rfc;
    public int tipo_empleado_id_tipo_empleado;
    public String emp_nombre;
    public String emp_apellidos;
    public String emp_telefono_celular; 
    public String emp_telefono_casa;
    @Email
    @NotNull
    public String emp_email;
    public float emp_salario_diario;
    public int emp_dias_laborales; 
    public String emp_alta;
    public Integer usuario_id_usuario;
    public int domicilio_id_domicilio;
    public int sucursal_id_sucursal;
    public String emp_baja;
    public int emp_status;
    public String imagen_empleado;
    
}
