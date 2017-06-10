/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.desarrollo.multicentro_mascotas.configuracion;

/**
 *
 * @author mpluas
 */
import java.io.*;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class UtilCryptography {
    private static int ITERATION_COUNT = 19;
    private static final String CLAVE = "CONFI_CONECEL%198210_2012";

    public static String encriptar(String str)
            throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
        {
            return encriptar(CLAVE, str);
        }

        public static String encriptar(String passPhrase, String str)
            throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException
        {
            Cipher ecipher = null;
            Cipher dcipher = null;
            java.security.spec.KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), SALT_BYTES, ITERATION_COUNT);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());
            java.security.spec.AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);
            ecipher.init(1, key, paramSpec);
            dcipher.init(2, key, paramSpec);
            byte utf8[] = str.getBytes("UTF8");
            byte enc[] = ecipher.doFinal(utf8);
            return (new BASE64Encoder()).encode(enc);
        }

        public static String desencriptar(String passPhrase, String str)
            throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IOException, IllegalBlockSizeException, BadPaddingException
        {
            Cipher ecipher = null;
            Cipher dcipher = null;
            java.security.spec.KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), SALT_BYTES, ITERATION_COUNT);
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);
            ecipher = Cipher.getInstance(key.getAlgorithm());
            dcipher = Cipher.getInstance(key.getAlgorithm());
            java.security.spec.AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT);
            ecipher.init(1, key, paramSpec);
            dcipher.init(2, key, paramSpec);
            byte dec[] = (new BASE64Decoder()).decodeBuffer(str);
            byte utf8[] = dcipher.doFinal(dec);
            return new String(utf8, "UTF8");
        }

        public static String desencriptar(String str)
            throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException
        {
            return desencriptar(CLAVE, str);
        }

        public static void main(String arg[])
            throws Exception
        {
                System.out.println(encriptar("mpluas"));

        }

        private static byte SALT_BYTES[] = {
            -87, -101, -56, 50, 86, 53, -29, 3
        };
        //pari1212    
}
