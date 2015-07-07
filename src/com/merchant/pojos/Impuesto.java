package com.merchant.pojos;

import com.merchant.utils.validate.annotations.NotNull;

/**
 *
 * @author alan
 */
public class Impuesto {

    @NotNull
    public int idImpuesto;
    public String codigoImpuesto;
    public String descripcionImpuesto;
    public String valorImpuesto;
}
