package com.merchant.pojos;

import java.sql.Date;

/**
 *
 * @author alan
 */
public class Empleado {

    public int idEmpleado;
    public String rfcEmpleado;
    public int tipoEmpleado_idtipoEmpleado;
    public String nombreEmpleado;
    public String apellidosEmpleado;
    public String telefonoEmpleado;
    public String mailEmpleado;
    public float salarioDiarioEmpleado;
    public int diasLaboralesEmpleado;
    public Date altaEmpleado;
    public int usuario_idUsuario;
    public int domicilioFiscal_idDomicilioFiscal;
    public int sucursal_idSucursal;
    public Date bajaEmpleado;
    public boolean statusEmpleado;
    /*
     * Datos para la tabla de Domicilio Fiscal
     */
    public String calle;
    public String numExt;
    public String numInt;
    public String colonia;
    public String codigoPostal;
    public String localidad;
    public String municipio;
    public String estado;
    public String pais;
}
