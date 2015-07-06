package com.merchant.utils.validate.validators;

import java.util.Map;

/**
 *
 * @author alan
 */
public class MinValidator extends MerchantValidator {

    @Override
    public boolean isValid(Map<String, Object> o) {
        return (int)o.get("value") >= (int)o.get("min");
    }
    
}
