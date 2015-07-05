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

    private List<FieldToValidate> dataToValidate;

    public Validator(T c) {
        claseAValidar = c;
        mapValidate = new HashMap<>();
        dataToValidate = new ArrayList<>();
        init();
    }

    private void init() {
        fields = claseAValidar.getClass().getDeclaredFields();
        // Aquí sabremos por que se tienen que validar lo fields de la clase indicada
        for (Field f : fields) {
            FieldToValidate newFieldToValidate = new FieldToValidate();
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
            dataToValidate.add(newFieldToValidate);
        }
    }

    public void validateAll() {
        for (FieldToValidate f : dataToValidate) {
            validateField(f);
        }
    }

    public void validateField(FieldToValidate field) {
        field.setFieldsValueValidate();
        for (Map.Entry<String, Class<?>> classValidate : field.classValidateAnnotations.entrySet()) {
            try {
                Method method = classValidate.getValue().newInstance().getClass().getMethod("isValid", Map.class);
                if ((boolean) method.invoke(classValidate.getValue().newInstance(), field.fieldsValueValidate.get(classValidate.getKey()))) {
                    System.out.println(field.fieldsValueValidate.get(classValidate.getKey()) + " Valido");
                } else {
                    System.out.println(field.fieldsValueValidate.get(classValidate.getKey()) + " Invalido");
                }
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
                System.err.println("Error - ValidateField: " + ex);
            }
        }
    }

    class FieldToValidate {

        /**
         * Como se pueden poner varias anotaciones en todo... Entonces se pueden
         * se guardarán las clases que validan dichas anotaciones
         * MapList<Nombre_anotacion, clase que valida dicha anotación>
         */
        Map<String, Class<?>> classValidateAnnotations;
        /**
         * Lista de valores de las anotaciones
         * Map<Nombre_anotacion, todos valores toda la anotación>
         *
         */
        Map<String, Map<String, Object>> valuesAnnotations;
        /**
         * Como ya sabemos donde validaremos y los valores de las anotaciones
         * tenemos que saber especificamente que campos se tiene que validar
         * Map<Nombre_anotacion, campos a validar de la anotación>
         */
        Map<String, String[]> fieldsToValidate;

        /**
         * Fielfs por validar con sus respendientes valores
         * Map<fielToValidate, value>
         */
        Map<String, Map<String, Object>> fieldsValueValidate;

        /**
         * fieldValue
         */
        Object fieldValue;

        public FieldToValidate() {
            classValidateAnnotations = new HashMap<>();
            valuesAnnotations = new HashMap<>();
            fieldsToValidate = new HashMap<>();
        }

        /**
         * Este método inicializa un Map<annotation
         * ,map<fieldToValidate, Value>>
         */
        public void setFieldsValueValidate() {
            fieldsValueValidate = new HashMap<>();
            String key = null;
            for (Map.Entry<String, String[]> fields : fieldsToValidate.entrySet()) {
                Map<String, Object> fielfValue = new HashMap();
                for (String f : fields.getValue()) {
                    key = fields.getKey();
                    // Fields que se tienen que validar con sus correspondientes valores
                    fielfValue.put(f, valuesAnnotations.get(key).get(f));
                }
                fielfValue.put("value", fieldValue);
                fieldsValueValidate.put(key, fielfValue);
            }
        }
    }

    /**
     * MINI TEST
     */
    public static void main(String args[]) {
        Validator validator = new Validator(new Persona());
        validator.validateAll();
    }

    static class Persona {

        @NotNull
        @Length(min = 5,max = 18)
        String curp;
        @NotNull
        String nombre;
        String apellidos;
        @Email
        String correo;

        public Persona() {
            curp = "12345";
            nombre = "";
            correo = "gmail@gmail.com";
        }
    }

}
