package com.merchant.utils.validate;

import com.merchant.utils.validate.annotations.Email;
import com.merchant.utils.validate.annotations.Length;
import com.merchant.utils.validate.annotations.MerchantAnnotation;
import com.merchant.utils.validate.annotations.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description Clase validadora
 * @version 0.0.2
 * @author alan
 */
public class Validator<T> {

    private Map<String, List<Class<?>>> mapValidate;
    private final T claseAValidar;
    private Field[] fields;

    public List<FieldToValidate> fieldsToValidate;

    public Validator(T c) {
        claseAValidar = c;
        mapValidate = new HashMap<>();
        fieldsToValidate = new ArrayList<>();
        init();
    }

    private void init() {
        fields = claseAValidar.getClass().getDeclaredFields();
        // Aquí sabremos por que se tienen que validar lo fields de la clase indicada
        for (Field f : fields) {
            if (f.getAnnotations().length > 0){
                FieldToValidate newFieldToValidate = new FieldToValidate();
                newFieldToValidate.fieldName = f.getName();
                Annotation annotations[] = f.getAnnotations();
                for (Annotation a : annotations) {
                    try {
                        MerchantAnnotation merchatAnnotation = a.annotationType()
                                .getAnnotation(MerchantAnnotation.class);
                        if (merchatAnnotation != null) {
                            // Clase que valida la anotación
                            newFieldToValidate.classValidateAnnotations
                                    .put(a.annotationType().getName(), merchatAnnotation.validatedBy());
                            newFieldToValidate.fieldsToValidate
                                    .put(a.annotationType().getName(), merchatAnnotation.fieldsValidatedBy());
                        }
                        Method methods[] = a.annotationType().getDeclaredMethods();
                        Map<String, Object> values = new HashMap<>();
                        for (Method m : methods) {
                            // Aqui se guardan todos los valores de la anotación
                            values.put(m.getName(), m.invoke(a));
                        }
                        // Nombre de la anotacion con sus respectivos valores
                        newFieldToValidate.valuesAnnotations.put(a.annotationType().getName(), values);
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                        System.err.println("ERROR Validator: " + ex);
                    }
                }
                try {
                    newFieldToValidate.fieldValue = f.get(claseAValidar);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    System.out.println("ERROR Validator: " + ex);
                }
                // ADD clases validadoras del field
                fieldsToValidate.add(newFieldToValidate);
            }
        }
    }

    public void validateAll() {
        for (FieldToValidate f : fieldsToValidate) {
            validateField(f);
        }
    }

    public ValidateFieldError validateField(FieldToValidate field) {
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
    
    public ValidateFieldError validateField(String nameField) {
        FieldToValidate field = getFieldByName(nameField);
        field.setAnnotationsValuesToValidate();
        return validateField(field);
    }
    
    private FieldToValidate getFieldByName (String name) {
        FieldToValidate field = null;
        for (FieldToValidate f : fieldsToValidate){
            if (f.fieldName.equals(name)){
                field = f;
            }
        }
        return field;
    }

    /**
     * MINI TEST
     */
    public static void main(String args[]) {
        Validator validator = new Validator(new Persona());
        validator.validateAll();
        for(Object f : validator.fieldsToValidate){
            System.out.println( ((FieldToValidate)f).fieldName + " - " + ((FieldToValidate)f).fieldValue );
        }
        // Validar error por nombre del field
        System.out.println("\n\nERRORES POR FIELD\n"+validator.validateField("curp").getErrors());
        System.out.println(validator.validateField("curp").getErrors().size());
    }

    static class Persona {

        @NotNull
        @Length(min = 18, max = 18)
        String curp;
        @NotNull
        String nombre;
        String apellidos;
        @Email
        String correo;

        public Persona() {
            curp = null;
            nombre = "Alan";
            correo = "gmail@gmail.com";
        }
    }

}
