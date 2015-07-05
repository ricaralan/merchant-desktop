package com.merchant.utils.validate;

import java.util.Map;

/**
 *
 * @author alan
 */
public class NotEmpty extends MerchantValidator{

    @Override
    public boolean isValid(Map<String, Object> o) {
        return !((String)o.get("value")).isEmpty();
    }
    
}
