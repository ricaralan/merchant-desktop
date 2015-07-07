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

    public int id;
    public String nombre;
    @RFC
    public String rfc;
    public String logo;
    public String tel;
    public String tel2;
    @Email
    @NotNull
    public String email;
    public String web;
    public Date fechaAlta;
    public int regimenFiscal_idregimenFiscal;
}
