package com.merchant.pojos;

import com.merchant.utils.validate.annotations.Email;
import com.merchant.utils.validate.annotations.NotEmpty;
import com.merchant.utils.validate.annotations.NotNull;
import com.merchant.utils.validate.annotations.RFC;
/**
 *
 * @author Eleazar
 */
public class Cliente {

    public int id_cliente;
    @RFC
    public String rfc;
    @NotEmpty
    public String nombre;
    public String clte_apellidos;
    public String clte_telefono_celular; 
    public String clte_telefono_casa;
    @Email
    @NotNull
    public String email; 
    public String clte_alta;
    public int clte_status;
    public int domicilio_id_domicilio;
    public String imagen_cliente;
    public String clte_baja;
    /**
     * Estos campos se agregaron por el join que se hizo en la consulta
     * y asi evitar que se hagan mas llamadas a la base de datos
     */
    public String direccion;
    public String status;
    
}
