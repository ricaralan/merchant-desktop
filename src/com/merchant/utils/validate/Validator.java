package com.merchant.utils.validate;

import com.merchant.utils.validate.annotations.MerchantAnnotation;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description Clase validadora
 * @version 0.0.4
 * @author alan
 */
public class Validator {

    public List<ValidateFieldError> validateFields(Object clase) {
        List<ValidateFieldError> errores = new ArrayList<>();
        Field fields[] = clase.getClass().getDeclaredFields();
        for (Field f : fields) {
            if (f.getAnnotations().length > 0){
                errores.add(validateField(clase, f.getName()));
            }
        }
        return errores;
    }

    public ValidateFieldError validateField(Object clase, String fieldName) {
        FieldToValidate newFieldToValidate = new FieldToValidate();
        try {
            Field field = clase.getClass().getDeclaredField(fieldName);
            // Aquí de guarda el nombre del field
            newFieldToValidate.fieldName = field.getName();
            Annotation[] annotations = field.getAnnotations();
            for (Annotation a : annotations) {
                MerchantAnnotation merchantAnnotation = a.annotationType().getAnnotation(MerchantAnnotation.class);
                if (merchantAnnotation != null) {
                    // Aquí de guarda la clase que valida la anotación
                    newFieldToValidate.classValidateAnnotations
                            .put(a.annotationType().getName(), merchantAnnotation.validatedBy());
                    // Aquí de guardan los parametros que utiliza la clase validadora para validar
                    newFieldToValidate.fieldsToValidate
                            .put(a.annotationType().getName(), merchantAnnotation.fieldsValidatedBy());
                }
                Method methods[] = a.annotationType().getDeclaredMethods();
                Map<String, Object> values = new HashMap<>();
                for (Method m : methods) {
                    // Aqui se guardan todos los valores de la anotación
                    values.put(m.getName(), m.invoke(a));
                }
                // Nombre de la anotacion con sus respectivos valores
                newFieldToValidate.valuesAnnotations.put(a.annotationType().getName(), values);
                // Valor del field
                newFieldToValidate.fieldValue = field.get(clase);
            }
        } catch (NoSuchFieldException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            System.err.println(ex);
        }
        return getErrorFieldToValidate(newFieldToValidate);
    }

    public ValidateFieldError getErrorFieldToValidate(FieldToValidate field) {
        ValidateFieldError errors = new ValidateFieldError();
        errors.fieldName = field.fieldName;
        field.setAnnotationsValuesToValidate();
        for (Map.Entry<String, Class<?>> classValidate : field.classValidateAnnotations.entrySet()) {
            try {
                Method method = classValidate.getValue().newInstance().getClass().getMethod("isValid", Map.class);
                if (!(boolean) method.invoke(classValidate.getValue().newInstance(), field.fieldsValueValidate.get(classValidate.getKey()))) {
                    // Si hay un error se guarda el error para devolverlo...
                    errors.addError(classValidate.getKey(),
                            (String) field.valuesAnnotations.get(classValidate.getKey()).get("message")
                    );
                }
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
                System.err.println("Error - ValidateField: " + ex);
            }
        }
        return errors;
    }

}
