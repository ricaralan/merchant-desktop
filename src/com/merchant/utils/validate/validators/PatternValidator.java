/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.utils.validate.validators;

import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author alan
 */
public class PatternValidator extends MerchantValidator {

    private Pattern pattern;

    @Override
    public boolean isValid(Map<String, Object> o) {
        pattern = Pattern.compile((String) o.get("pattern"));
        return pattern.matcher((String) o.get("value")).matches();
    }

}
