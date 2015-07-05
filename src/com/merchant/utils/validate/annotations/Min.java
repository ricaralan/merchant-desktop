package com.merchant.utils.validate.annotations;

import com.merchant.utils.validate.MinValidator;
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
@MerchantAnnotation(validatedBy = MinValidator.class)
public @interface Min {

    public String message() default "{error.invalid.min.length}";

    public int min();
}
