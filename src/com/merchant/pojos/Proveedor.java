package com.merchant.pojos;

import com.merchant.utils.validate.annotations.Email;
import com.merchant.utils.validate.annotations.NotEmpty;
import com.merchant.utils.validate.annotations.NotNull;
import com.merchant.utils.validate.annotations.RFC;
/**
 *
 * @author Eleazar
 */
public class Proveedor {

    public int id_proveedor;
    @RFC
    public String rfc;
    @NotEmpty
    public String nombre;
    public String prov_apellidos;
    public String prov_telefono_celular; 
    public String prov_telefono_casa;
    @Email
    @NotNull
    public String email; 
    public String prov_alta;
    public int prov_status;
    public int domicilio_id_domicilio;
    public String imagen_proveedor;
    public String prov_baja;
    /**
     * Estos campos se agregaron por el join que se hizo en la consulta
     * y asi evitar que se hagan mas llamadas a la base de datos
     */
    public String direccion;
    public String status;
    
}
