package com.merchant.pojos;

import com.merchant.utils.validate.annotations.NotNull;

/**
 *
 * @author alan
 */
public class Impuesto {

    @NotNull
    public int id_impuesto;
    public String impto_codigo;
    public String impto_descripcion;
    public String impto_valor;
}
