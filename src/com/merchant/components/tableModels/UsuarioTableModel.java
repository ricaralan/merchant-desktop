package com.merchant.components.tableModels;

import com.merchant.controllers.UsuarioController;
import com.merchant.pojos.Usuario;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Eleazar
 */
public class UsuarioTableModel extends MerchantTableModel{

    UsuarioController usuarioController;

    public UsuarioTableModel() {
        objects = new ArrayList<>();
        header = new String[]{"idUsuario","nombreUsuario","passwordUsuario","statusUsuario"};
        usuarioController = new UsuarioController();
    }
    
    @Override
    public void initData (Connection connection) {
        objects = (List<Object>)(Object)usuarioController.getAll(connection);
        fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int row, int column) {
        String value = "";
        Usuario usuario = (Usuario)objects.get(row);
        switch (column) {
            case 0: value = usuario.nombreUsuario;break;
            case 1: value = usuario.passwordUsuario;break;
            case 2: value = String.valueOf(usuario.statusUsuario);break;
        }
        return value;
    }
    
}
