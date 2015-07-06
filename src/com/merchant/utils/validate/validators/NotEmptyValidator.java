package com.merchant.utils.validate.validators;

import java.util.Map;

/**
 *
 * @author alan
 */
public class NotEmptyValidator extends MerchantValidator{

    @Override
    public boolean isValid(Map<String, Object> o) {
        return !((String)o.get("value")).isEmpty();
    }
    
}
