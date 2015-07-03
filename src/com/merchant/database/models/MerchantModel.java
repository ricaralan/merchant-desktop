/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.merchant.database.models;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public abstract class MerchantModel {
    
    public abstract List<Object> getAll(Connection connection);

    public abstract Integer create(Connection conection, Object o);

    public abstract Integer update(Connection connection, Object o, Object id);

    public abstract Integer delete(Connection connection, Object id);
}
