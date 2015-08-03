package com.merchant.components.listModels;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author alan
 */
public final class ConfigurationListModel extends AbstractListModel {

    private List<Configuration> configurations;
    private final String configurationNames[], configurationPathClass[];
    public JPanel panel;
    public JTable table;

    public ConfigurationListModel(JPanel panel, JTable table) {
        this.configurationNames = new String[]{"Empresa", "Regimen", "Sucursal", "Impuestos", "Lineas", "Tipo de comprobante", "Tipo de empleado", "Tipo de unidad", "Álmacen", "Usuario"};
        this.configurationPathClass = new String[]{
            "com.merchant.views.configuration.EmpresasPanel",
            "com.merchant.views.configuration.RegimenPanel",
            "com.merchant.views.configuration.SucursalesPanel",
            "com.merchant.views.configuration.ImpuestosPanel",
            "com.merchant.views.configuration.LineasPanel",
            "com.merchant.views.configuration.TiposDeComprobantesPanel",
            "com.merchant.views.configuration.TiposDeEmpleadosPanel",
            "com.merchant.views.configuration.TiposDeUnidadesPanel",
            "com.merchant.views.configuration.AlmacenesPanel",
            "com.merchant.views.configuration.UsuariosPanel"
        };
        this.panel = panel;
        this.table = table;
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
            configurations.get(i).pathClass = configurationPathClass[i];
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

    public String setConfiguration(int i) {
        return configurationPathClass[i];
    }

    class Configuration {

        public String name;
        public String pathClass;
    }
}
