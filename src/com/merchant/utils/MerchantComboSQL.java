package com.merchant.utils;

import com.merchant.database.models.MerchantModel;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alan
 */
public class MerchantComboSQL extends AbstractListModel implements ComboBoxModel {

    private List<Object> items;
    private Object itemSelected = null;
    private String mainField;

    public MerchantComboSQL(Connection connection, MerchantModel model, String field) {
        items = new ArrayList<>();
        mainField = field;
        items = model.getAll(connection);
        if (items.size() > 0) {initSelected();}
    }
    
    private void initSelected(){
        itemSelected = getMainFieldValue(items.get(0));
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public Object getElementAt(int i) {
        return getMainFieldValue(items.get(i));
    }

    @Override
    public void setSelectedItem(Object o) {
        itemSelected = getMainFieldValue(findByMainField((String) o));
    }

    @Override
    public Object getSelectedItem() {
        return itemSelected;
    }
    
    public void setSelectedItemByFieldValue(String field, String value) {
        setSelectedItem(getMainFieldValue(findByFielNameAndValue(field, value)));
    }

    /**
     *  Este método busca un objeto en la lista mediante el valor del mainField
     *  establecido en el constructor
     */
    public Object findByMainField(String text) {
        Object findResult = null;
        for (int i = 0; i < items.size(); i++) {
            try {
                if (getElementAt(i).equals(text)) {
                    findResult = items.get(i);
                }
            } catch (SecurityException ex) {
                System.err.println("MerchantComboSQL - findByMainField: " + ex.getMessage());
            }
        }
        return findResult;
    }

    /**
     *  Este método devuelve el objeto que tenga un atributo con el nombre del
     *  nameFiel y con el valor establecido
     */
    public Object findByFielNameAndValue(String nameField, Object value) {
        Object findObject = null;
        for (Object item : items) {
            try {
                if (getObjectByFielValue(item, nameField).equals(value)) {
                    findObject = item;
                }
            }catch (SecurityException ex) {
                System.err.println("MerchantComboSQL - findByMainField: " + ex.getMessage());
            }
        }
        return findObject;
    }

    /**
     *  Regresa el valor del atributo del objeto que corresponda al mainFiel
     */
    private Object getMainFieldValue(Object o) {
        return getObjectByFielValue(o, mainField);
    }

    /**
     *  Regresa el valor de un objeto mediante el un fiel escogido
     */
    private Object getObjectByFielValue(Object o, String field) {
        Object value = null;
        try {
            value = o.getClass().getDeclaredField(field).get(o);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
            System.err.println("MerchantComboSQL - getMainFieldValue: " + ex.getMessage());
        }
        return value;
    }
    
}
