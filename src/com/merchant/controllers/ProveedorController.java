package com.merchant.controllers;

import com.merchant.database.models.ProveedorModel;
import com.merchant.database.models.DomicilioModel;
import com.merchant.pojos.Domicilio;
import com.merchant.pojos.Proveedor;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class ProveedorController extends MerchantController<Proveedor> {

    ProveedorModel proveedorModel;
    DomicilioModel domicilioModel;
    
    
    public ProveedorController() {
        proveedorModel = new ProveedorModel();
        domicilioModel = new DomicilioModel();
        
    }
    
    public boolean create(Connection connection, Proveedor proveedor, Domicilio dom) {
        proveedor.domicilio_id_domicilio = domicilioModel.create(connection, dom);
        return proveedorModel.create(connection, proveedor) == 1;
    }
    
    public boolean update(Connection connection, Proveedor proveedor, Object id, 
            Domicilio dom,Object id_domicilio) {
        domicilioModel.update(connection, dom, id_domicilio);
        return proveedorModel.update(connection, proveedor, id) == 1;
    }
    
    public boolean delete(Connection connection, Object id,Object id_domicilio) {
        if (domicilioModel.delete(connection, id_domicilio)== 1) {
            proveedorModel.delete(connection, id);
        }
        return true;
    }
    
    @Override
    public boolean delete(Connection connection, Object id) {
        return proveedorModel.delete(connection, id) == 1;
    }

    @Override
    public List<Proveedor> getAll(Connection connection) {
        return proveedorModel.getAll(connection);
    }

    @Override
    public boolean create(Connection connection, Proveedor o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Connection connection, Proveedor o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proveedor getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
