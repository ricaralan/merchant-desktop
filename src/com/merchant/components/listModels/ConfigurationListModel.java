package com.merchant.components.listModels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author alan
 */
public final class ConfigurationListModel extends AbstractListModel {

    List<Configuration> configurations;
    private final String configurationNames[];

    public ConfigurationListModel() {
        // Primero se inicializan de manera estatica... Despues se recogerán de la DB
        this.configurationNames = new String[]{"Empresa", "Regimen", "Sucursal", "Impuestos", "Lineas", "Tipo de comprobante", "Tipo de empleado", "Tipo de unidad", "Álmacen"};
        configurations = new ArrayList<>();
        fillConfigurations();
    }

    /**
     * Aquí se llenan las configuraciones... de momento se llenan manualmente
     * pero en un futuro se deben llenar con la base de datos
     */
    public void fillConfigurations() {
        for (int i = 0; i < configurationNames.length; i++) {
            configurations.add(new Configuration());
            configurations.get(i).name = configurationNames[i];
        }
    }

    @Override
    public int getSize() {
        return configurations.size();
    }

    @Override
    public Object getElementAt(int i) {
        return configurations.get(i).name;
    }

    class Configuration {

        public String name;
    }
}
