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
public abstract class MerchantModel<T> {

    public abstract Integer create(Connection connection, T o);

    public abstract Integer update(Connection connection, T o, Object id);

    public abstract Integer delete(Connection connection, Object id);

    public abstract List<T> getAll(Connection connection);
}
