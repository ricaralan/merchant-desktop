package com.merchant.utils.validate.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author alan
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface MerchantAnnotation {

    // Clase validadora de la anotación
    public Class<?> validatedBy();

    // Nombres de los fields que validan
    public String[] fieldsValidatedBy();
    
    // Values (REQUIRED)
    public String value() default "";
}
