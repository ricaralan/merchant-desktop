package com.merchant.utils.validate;

import com.merchant.utils.validate.annotations.Email;
import com.merchant.utils.validate.annotations.MerchantAnnotation;
import com.merchant.utils.validate.annotations.Min;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Description Clase validadora
 * @version 0.0.1
 * @author alan
 */
public class Validator<T> {

    private Map<String, List<Class<?>>> mapValidate;
    private final T claseAValidar;
    private Field[] fields;

    public Validator(T c) {
        claseAValidar = c;
        mapValidate = new HashMap<>();
        init();
    }

    private void init() {
        fields = claseAValidar.getClass().getDeclaredFields();
        // Aquí sabremos por que se tienen que validar lo fields de la clase indicada
        for (Field f : fields) {
            //System.out.println(Arrays.toString(fields));
            Annotation annotations[] = f.getAnnotations();
            List<Class<?>> clasesValidadoras = new ArrayList<>();
            for (Annotation a : annotations) {
                MerchantAnnotation merchatAnnotation = a.annotationType().getAnnotation(MerchantAnnotation.class);
                if (merchatAnnotation != null) {
                    clasesValidadoras.add(merchatAnnotation.validatedBy());
                }
            }
            // Se guarda el nombre del fiel junto con las clases que lo validan
            mapValidate.put(f.getName(), clasesValidadoras);
        }
    }

    public void validateAll() {
        for (Map.Entry<String, List<Class<?>>> s : mapValidate.entrySet()) {
            validateField(s.getKey());
        }
    }

    public void validateField(String field) {
        List<Class<?>> clasesValidadoras = mapValidate.get(field);
        for (Class<?> c : clasesValidadoras) {
            try {
                Method method = c.newInstance().getClass().getMethod("isValid", Object.class);
                Object fieldValue = claseAValidar.getClass().getDeclaredField(field).get(claseAValidar);
                if ((boolean) method.invoke(c.newInstance(), fieldValue)) {
                    System.out.println("Valido");
                } else {
                    System.out.println("Invalido");
                }
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | NoSuchFieldException e) {
                System.err.println("ERROR validateField: " + e.getCause());
            } catch (IllegalArgumentException | InvocationTargetException e) {
                System.err.println("ERROR validateField: " + e.getCause());
            }
        }
    }

    static class Persona {

        @Email(message = "Email invalido")
        String email;
        @Min(message = "Longitud minima de 5", min = 5)
        String name;

        public Persona(String email, String name) {
            this.email = email;
            this.name = name;
        }
    }

    public static void main(String args[]) {
        Validator<Persona> validator = new Validator<>(new Persona("ricardalan@gmail.com", ""));
        validator.validateAll();
    }

}
