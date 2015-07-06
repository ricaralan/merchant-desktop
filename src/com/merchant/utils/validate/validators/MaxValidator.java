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
public class MaxValidator extends MerchantValidator {

    @Override
    public boolean isValid(Map<String, Object> o) {
        return ((int)o.get("value")) <= ((int)o.get("max"));
    }
    
}
