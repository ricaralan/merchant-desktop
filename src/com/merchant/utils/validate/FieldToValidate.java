package com.merchant.utils.validate;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alan
 */
public class FieldToValidate {

    /**
     * Nombre del field a validar
     */
    public String fieldName;
    /**
     * Valor del field
     */
    public Object fieldValue;
    /**
     * Como se pueden poner varias anotaciones en todo... Entonces se pueden se
     * guardarán las clases que validan dichas anotaciones
     * MapList<Nombre_anotacion, clase que valida dicha anotación>
     */
    public Map<String, Class<?>> classValidateAnnotations;
    /**
     * Lista de valores de las anotaciones
     * Map<Nombre_anotacion, todos valores toda la anotación>
     */
    public Map<String, Map<String, Object>> valuesAnnotations;
    /**
     * Como ya sabemos donde validaremos y los valores de las anotaciones
     * tenemos que saber especificamente que campos se tiene que validar
     * Map<Nombre_anotacion, campos a validar de la anotación>
     */
    public Map<String, String[]> fieldsToValidate;

    /**
     * Fielfs por validar con sus respendientes valores
     * Map<fielToValidate, value>
     */
    public Map<String, Map<String, Object>> fieldsValueValidate;

    public FieldToValidate() {
        classValidateAnnotations = new HashMap<>();
        valuesAnnotations = new HashMap<>();
        fieldsToValidate = new HashMap<>();
    }

    /**
     * Este método inicializa un Map<annotation ,map<fieldToValidate, Value>>
     */
    public void setAnnotationsValuesToValidate() {
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
