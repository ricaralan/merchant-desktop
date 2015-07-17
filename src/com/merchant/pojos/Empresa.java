package com.merchant.pojos;

import com.merchant.utils.validate.annotations.Email;
import com.merchant.utils.validate.annotations.NotNull;
import com.merchant.utils.validate.annotations.RFC;
import java.sql.Date;

/**
 *
 * @author alan
 */
public class Empresa {

    public int id_empresa;
    public String emp_nombre;
    @RFC
    public String emp_rfc;
    public String emp_logo;
    public String emp_tel;
    public String emp_tel2;
    @Email
    @NotNull
    public String emp_email;
    public String emp_web;
    public Date emp_fechaAlta;
    public int regimen_id_regimen;
}
