/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.utils.validate.validators;

import java.util.Map;

/**
 *
 * @author alan
 */
public class LengthValidator extends MerchantValidator{

    @Override
    public boolean isValid(Map<String, Object> o) {
        String value = (String)o.get("value");
        Integer lengthStr = (Integer) (value!=null?value.length():value);
        return lengthStr != null &&(lengthStr >= (int)o.get("min") && lengthStr <= (int)o.get("max"));
    }
    
}
