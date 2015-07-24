package com.merchant.controllers;

import com.merchant.database.models.DomicilioModel;
import com.merchant.database.models.EmpleadoModel;
import com.merchant.database.models.UsuarioModel;
import com.merchant.pojos.Domicilio;
import com.merchant.pojos.Empleado;
import com.merchant.pojos.Usuario;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Eleazar
 */
public class EmpleadoController extends MerchantController<Empleado> {

    EmpleadoModel empleadoModel;
    DomicilioModel domicilioModel;
    UsuarioModel usuarioModel;
    
    public EmpleadoController() {
        empleadoModel = new EmpleadoModel();
        domicilioModel = new DomicilioModel();
        usuarioModel = new UsuarioModel();
    }
    
    public boolean create(Connection connection, Empleado empleado, Domicilio dom, Usuario usu) {
        empleado.domicilio_id_domicilio = domicilioModel.create(connection, dom);
        empleado.usuario_id_usuario = usuarioModel.create(connection, usu);
        return empleadoModel.create(connection, empleado) == 1;
    }
    
    public boolean create(Connection connection, Empleado empleado, Domicilio dom) {
        empleado.domicilio_id_domicilio = domicilioModel.create(connection, dom);
        return empleadoModel.create(connection, empleado) == 1;
    }
    public boolean update(Connection connection, Empleado empleado, Object id, 
            Domicilio dom,Object id_domicilio, Usuario usu, Object id_usuario) {
        domicilioModel.update(connection, dom, id_domicilio);
        usuarioModel.update(connection, usu, id_usuario);
        return empleadoModel.update(connection, empleado, id) == 1;
    }
    
    public boolean update(Connection connection, Empleado empleado, Object id, 
            Domicilio dom, Object id_domicilio) {
        domicilioModel.update(connection, dom, id_domicilio);
        return empleadoModel.update(connection, empleado, id) == 1;
    }

    @Override
    public boolean update(Connection connection, Empleado empleado, Object id) {
        return empleadoModel.update(connection, empleado, id) == 1;
    }
    
    public boolean delete(Connection connection, Object id,Object id_domicilio) {
        if (domicilioModel.delete(connection, id_domicilio)== 1) {
            empleadoModel.delete(connection, id);
        }
        return true;
    }
    
    @Override
    public boolean delete(Connection connection, Object id) {
        return empleadoModel.delete(connection, id) == 1;
    }

    @Override
    public List<Empleado> getAll(Connection connection) {
        return empleadoModel.getAll(connection);
    }

    @Override
    public boolean create(Connection connection, Empleado o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado getById(Connection connection, Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
