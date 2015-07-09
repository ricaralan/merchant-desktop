package com.merchant.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author alan
 */
public class Encriptation {

    private final String algorithm = "AES";
    private final String cipherInstance = "AES/ECB/PKCS5Padding";
    private final byte[] key = {
        0xA, 0x1, 0x9, 0x9, 0x4,
        0x13, 0x41, 0x53, 0x65, 0x63,
        0x72, 0x65, 0x74, 0x4b, 0x23, 0x32
    };

    public String encrypt(String messageToEncrypt) {
        String messageEncrypted = null;
        SecretKeySpec secretKey;
        try {
            Cipher cipher = Cipher.getInstance(cipherInstance);
            secretKey = new SecretKeySpec(key, algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            messageEncrypted = Base64.encodeBase64String(cipher.doFinal(messageToEncrypt.getBytes()));
            return messageEncrypted;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.err.println(e);
        }
        return messageEncrypted;
    }

    public String decrypt(String messageToDencrypt) {
        String messageDecrypted = null;
        SecretKeySpec secretKey;
        try {
            Cipher cipher = Cipher.getInstance(cipherInstance);
            secretKey = new SecretKeySpec(key, algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            messageDecrypted = new String(cipher.doFinal(Base64.decodeBase64(messageToDencrypt)));
            return messageDecrypted;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            System.err.println(e);
        }
        return messageDecrypted;
    }
}
