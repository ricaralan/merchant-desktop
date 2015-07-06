package com.merchant.controllers;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author alan
 */
public abstract class MerchantController<T> {

    public abstract boolean create(Connection connection, T o);

    public abstract boolean update(Connection connection, T o, Object id);

    public abstract boolean delete(Connection connection, Object id);

    public abstract List<T> getAll(Connection connection);
}
