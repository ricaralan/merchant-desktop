package com.merchant.utils.validate;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alan
 */
public class ValidateFieldError {

    public String fieldName;
    private Map<String, String> errors;
    
    public ValidateFieldError(){
        errors = new HashMap<>();
    }
    
    public Map<String, String> getErrors() {
        return errors;
    }
    
    public void addError(String err, String description){
        errors.put(err, description);
    }
}
