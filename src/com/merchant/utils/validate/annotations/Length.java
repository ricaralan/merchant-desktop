package com.merchant.utils.validate.annotations;

import com.merchant.utils.validate.validators.LengthValidator;
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
@MerchantAnnotation(validatedBy = LengthValidator.class, fieldsValidatedBy = {"value", "min", "max"})
public @interface Length {

    public String message() default "{error.invalid.length}";
    public int min();
    public int max();
}
