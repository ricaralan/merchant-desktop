package com.merchant.controllers;

import com.merchant.database.models.ClienteModel;
import com.merchant.database.models.DomicilioModel;
import com.merchant.pojos.Cliente;
import com.merchant.pojos.Domicilio;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class ClienteController extends MerchantController<Cliente> {

    ClienteModel clienteModel;
    DomicilioModel domicilioModel;
    
    
    public ClienteController() {
        clienteModel = new ClienteModel();
        domicilioModel = new DomicilioModel();
        
    }
    
    public boolean create(Connection connection, Cliente cliente, Domicilio dom) {
        cliente.domicilio_id_domicilio = domicilioModel.create(connection, dom);
        return clienteModel.create(connection, cliente) == 1;
    }
    
    public boolean update(Connection connection, Cliente cliente, Object id, 
            Domicilio dom,Object id_domicilio) {
        domicilioModel.update(connection, dom, id_domicilio);
        return clienteModel.update(connection, cliente, id) == 1;
    }
    
    public boolean delete(Connection connection, Object id,Object id_domicilio) {
        if (domicilioModel.delete(connection, id_domicilio)== 1) {
            clienteModel.delete(connection, id);
        }
        return true;
    }
    
    @Override
    public boolean delete(Connection connection, Object id) {
        return clienteModel.delete(connection, id) == 1;
    }

    @Override
    public List<Cliente> getAll(Connection connection) {
        return clienteModel.getAll(connection);
    }

    @Override
    public boolean create(Connection connection, Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Connection connection, Cliente o, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
