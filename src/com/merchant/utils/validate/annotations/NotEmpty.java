package com.merchant.utils.validate.annotations;

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
@MerchantAnnotation(validatedBy = NotEmpty.class, fieldsValidatedBy = {"value"})
public @interface NotEmpty {

    public String message() default "error.invalid.empty";
}
