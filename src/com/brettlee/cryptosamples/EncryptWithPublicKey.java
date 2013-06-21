package com.brettlee.cryptosamples;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;


public class EncryptWithPublicKey {
    
    public void go( String storename, String storetype, String storepasswd, String alias ) {

        try {
            
            // Load the keystore
            File file = new File( storename );
            FileInputStream is = new FileInputStream(file);
            KeyStore keystore = KeyStore.getInstance( storetype );
            keystore.load(is, storepasswd.toCharArray());
            is.close();
        
            // Get private key from keystore
            System.out.println("About to get private key...");
            PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, storepasswd.toCharArray() );
            System.out.println(privateKey.toString());    
            // Get corresponding certificate from keystore
            System.out.println("About to get certificate...");
            Certificate cert = keystore.getCertificate( alias );
              System.out.println(cert.toString());                                  
            // Get public key from certificate
            System.out.println("About to get public key...");
            PublicKey publicKey = cert.getPublicKey();
            
         } catch (Exception e) {
            System.out.println("Failed...");
            e.printStackTrace();
         }
         System.out.println("Success with go(get keys)...");
         
         
         
    }
                
    public static void main ( String[] args ) {
        // go( String storename, String storetype, String storepasswd, String alias ) 
        new EncryptWithPublicKey().go( "keyStoreDownload.do", "JCEKS", "Kess123#$", "mykey" );
    }

}
