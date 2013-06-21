package com.brettlee.cryptosamples;

import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EvveKeyStoreMain {

    /**
     * @param args
     */
    private static File file = new File("keyStoreDownload.do");
    private static char[] storPass = "Kess123#$".toCharArray();
    private static String alias = "AGENCY-KESS";
  
    public static void main(String[] args) {
        EvveKeyStore key = new EvveKeyStore(file, storPass, alias);
        //String str = "kRfATLFZIuF8Ow2v8nsBKSmfGEk5XSLxe2IbcEcRoqhV32arrRyvIvUS63ijoIlvSSo4vTGGciN";

        String str1 ="saif is what ever";
        try {
            key.doDecrypt("1lmgMU0lsQt1OipDLNX7iuzdadNk2JG6");
            key.doEncrypt(str1);
        } catch (InvalidKeyException e) {
            
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
          
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
           
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
          
            e.printStackTrace();
        } catch (BadPaddingException e) {
     
            e.printStackTrace();
        } catch (IOException e) {
          
            e.printStackTrace();
        }
    }

}
