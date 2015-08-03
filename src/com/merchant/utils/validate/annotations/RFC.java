/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.utils.validate.annotations;

import com.merchant.utils.validate.validators.PatternValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author alan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@MerchantAnnotation(validatedBy = PatternValidator.class, fieldsValidatedBy = {"pattern", "value"})
public @interface RFC {

    public String message() default "{error.invalid.rfc}";

    // RFC Conformado por 4 letras A-Z y 6 números
    public String pattern() default "^[A-Z]{4}[0-9]{6}";
}
