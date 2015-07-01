/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alan
 */
public class KeyCode {

    private final String numbers[];
    private final String navegationKeys[];
    private Map keys;

    public KeyCode() {
        this.numbers = new String[]{"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve"};
        this.navegationKeys = new String[]{"repag", "avpag", "fin", "inicio", "izquierda", "arriba", "derecha", "abajo"};
        initKeys();
    }
    
    private void initKeys() {
        keys = new HashMap();
        setAlphabetKeys();
        setFunctionKeys();
        setNumberKeys();
        setNavegationKeys();
        setSpecialKeys();
    }
    
    /**
     * Este método inicializa las letras del alfabeto a-z los códigos de estas
     * letras van del 65 al 90
     */
    private void setAlphabetKeys() {
        char key = 'a';
        for (int i = 65; i <= 90; i++) {
            keys.put(String.valueOf(key++), i);
        }
    }

    /**
     * Este método inicializa las letras de funciones f1-12 los códigos de las
     * letras van del 112 al 123
     */
    private void setFunctionKeys() {
        int codigo = 112;
        for (int i = 1; i <= 12; i++) {
            keys.put("f" + i, codigo++);
        }
    }

    /**
     * Este método inicializa los numeros del 0-9 cuyos códigos van del 48-57
     */
    private void setNumberKeys() {
        initKeysWithArray(48, numbers);
    }

    /**
     *  Este método inicializa las teclas de navegación
     *  con ayuda de la variable navegationKeys cuyos códigos van del 33 al 40
     */
    private void setNavegationKeys() {
        initKeysWithArray(33, navegationKeys);
    }
    
    /**
     *  Este método permite inicializar keys
     *  Ejemplo: initKeysWithArray(1, ["uno", "dos"]) inicializa 2 posiciones en la variable keys
     *  resultado: keys.put("uno", 1);keys.put("dos", 2);
     * 
     *  @codigo número con el que inician los códigos de keys
     *  @arrayNames arreglo de nombre que van a coincidir con los códigos
     */
    private void initKeysWithArray(int codigo, String[] arrayNames) {
        for (String name : arrayNames) {
            keys.put(name, codigo++);
        }
    }
    
    /**
     *  Como en estas teclas no hay códigos consecutivos... se inicizalizan manualmente
     */
    private void setSpecialKeys(){
        keys.put("enter", 10);
        keys.put("shift", 16);
        keys.put("ctrl", 17);
        keys.put("alt", 18);
        keys.put("supr", 127);
        keys.put("alt_gr", 65406);
    }
    
}
