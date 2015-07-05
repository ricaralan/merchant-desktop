/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.utils.validate;

import java.util.Map;

/**
 *
 * @author alan
 */
public class MinLengthValidator extends MerchantValidator{

    @Override
    public boolean isValid(Map<String, Object> o) {
        return ((String)o.get("value")).length() >= (int)o.get("min");
    }
    
}
