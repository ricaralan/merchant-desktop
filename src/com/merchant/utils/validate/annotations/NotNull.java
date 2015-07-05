package com.merchant.utils.validate.annotations;

import com.merchant.utils.validate.NotNullValidator;
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
@MerchantAnnotation(validatedBy = NotNullValidator.class, fieldsValidatedBy = {"value"})
public @interface NotNull {

    public String message() default "";
}
