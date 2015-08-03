/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.pojos;

import com.merchant.utils.validate.annotations.NotEmpty;

/**
 *
 * @author Eleazar
 */
public class Usuario {

    public int id_usuario;
    @NotEmpty
    public String nombre;
    @NotEmpty
    public String password;
    public int usu_status;
    
    public String status;
   
    public String old_password;
    public String new_password;
    public String conf_password;
}
