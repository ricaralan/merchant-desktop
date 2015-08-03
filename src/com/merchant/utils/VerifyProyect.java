package com.merchant.utils;

import java.io.File;

/**
 *
 * @author alan
 */
public class VerifyProyect {

    /**
     * Verificar si el proyecto esta correcto en cuanto a recursos... como las
     * carpetas de las que dependen algunos modulos...
     *
     */
    File folders[];

    public VerifyProyect() {
        folders = new File[4];
        folders[0] = new File("images/empresas");
        folders[1] = new File("images/empleados");
        folders[2] = new File("images/clientes");
        folders[3] = new File("images/proveedores");
    }

    public void verify() {
        VerifyProyect.Verify v = new VerifyProyect.Verify();
        v.start();
    }

    public void verifyFolderStructure() {
        for (File f : folders) {
            if (!f.exists()) {
                System.out.println("Creating folder: " + f.getAbsolutePath());
                try {
                    f.mkdirs();
                } catch (SecurityException e) {
                    System.err.println("ERROR CREATING FORLDER: " + e);
                }
            }
        }
    }

    static class Verify extends Thread {

        @Override
        public void run() {
            new VerifyProyect().verifyFolderStructure();
        }
    }

}
