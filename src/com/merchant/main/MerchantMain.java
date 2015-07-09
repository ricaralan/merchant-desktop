package com.merchant.main;

import com.merchant.utils.VerifyProyect;
import com.merchant.views.Login;

/**
 *
 * @author alan
 */
public class MerchantMain {

    private static Login login;

    public static void main(String args[]) {
        VerifyProyect verify = new VerifyProyect();
        verify.verify();
        login = new Login();
        login.setVisible(true);
    }

}
