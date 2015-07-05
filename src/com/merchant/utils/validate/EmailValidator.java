/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.utils.validate;

import java.util.regex.Pattern;

/**
 *
 * @author alan
 */
public class EmailValidator extends MerchantValidator {

    private Pattern emailPatern;
    String mail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public boolean isValid(Object emailRecibido) {
        System.out.println("Validando..." + emailRecibido);
        emailPatern = Pattern.compile(mail);
        return emailPatern.matcher((String) emailRecibido).matches();
    }

}
