package com.merchant.utils.validate.annotations;

import com.merchant.utils.validate.validators.NotEmptyValidator;
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
@MerchantAnnotation(validatedBy = NotEmptyValidator.class, fieldsValidatedBy = {"value"})
public @interface NotEmpty {

    public String message() default "{error.invalid.value.empty}";
}
