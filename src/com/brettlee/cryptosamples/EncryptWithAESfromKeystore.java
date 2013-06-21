package com.brettlee.cryptosamples;

import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
public class EncryptWithAESfromKeystore {

    /**
     * Turns array of bytes into string
     *
     * @param buf   Array of bytes to convert to hex string
     * @return  Generated hex string
     */
    public static String asHex (byte buf[]) {
        StringBuffer strbuf = new StringBuffer(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    /**
     * Writes a keystore to a filesystem
     *
     */
  
    /**
     * Encrypts a string
     *
     * @param s     String
     * @return      Array of bytes containing encrypted string
     */
    public byte[] encrypt2( 
            String s, 
            File file, 
            char[] storPass, 
            String alias ) {
        
        Key aeskey = getKeyFromStore(file, storPass, alias);
        byte[] encrypted = null;
        
        try {
            // Instantiate the cipher
            Cipher cipher = Cipher.getInstance("AES");
            
            // Generate the secret key spec
            byte[] raw = aeskey.getEncoded();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            
            // Encrypt
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            encrypted = cipher.doFinal( s.getBytes() );
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }
    
    /**
     * Decrypts an array of bytes into a string
     *
     * @param encrypted     Encrypted bytes 
     * @return              Array of bytes containing encrypted string
     */
    public String decrypt2( 
            byte[] encrypted, 
            File file, 
            char[] storPass, 
            String alias ) {
        
        Key aeskey = getKeyFromStore(file, storPass, alias);
        String originalString = null;
        
        try {           
            // Instantiate the cipher
            Cipher cipher = Cipher.getInstance("AES");
            
            // Generate the secret key spec
            byte[] raw = aeskey.getEncoded();
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
  
            // Decrypt
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] original = cipher.doFinal(encrypted);
            originalString = new String(original);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return originalString;
    }
    
  
    /**
     * Reads key from keystore on a filesystem
     *
     */
    private static Key getKeyFromStore( 
            File file, 
            char[] storPass, 
            String alias ) {
        
        Key keyFromStore = null;
        
        try {
          
           // final KeyStore keyStore = KeyStore.getInstance("JCEKS");
            final KeyStore keyStore = KeyStore.getInstance("jceks");
            
            if ( file.exists() ) {   // don't buffer keystore; it's tiny anyway
                final FileInputStream input   = new FileInputStream( file );
                keyStore.load( input, storPass );
                input.close();
            }
        
            // Get key from KeyStore on disk 
            keyFromStore = keyStore.getKey( alias, storPass);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return keyFromStore;
    }

    
    /**
     * Get going
     *
     * @param cipher        Cipher
     * @param encrypted     Encrypted bytes 
     * @return  Array of bytes containing encrypted string
     */
    public void go( String[] args ) {
        
        String message = new String("saif is my school");
        File file = new File("keyStoreDownload.do");
        char[] storPass = "Kess123#$".toCharArray();
        String alias = "sss";
        
      //  SecretKeySpec skeySpec = genKeystore( file, storPass );
        
        try {

           
           
         // Encrypt using "filesystem" (keystore) key info
            byte[] encrypted2 = encrypt2( message, file, storPass, alias );
            System.out.println("Encrypted (keystore): " + asHex(encrypted2));

            
            // Decrypt using "filesystem" (keystore) key info
            String originalString2 = decrypt2( encrypted2, file, storPass, alias );
            System.out.println("Decrypted (keystore): " + originalString2 );
                    
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static void main(String[] args) throws Exception {
        new EncryptWithAESfromKeystore().go( args );
    }
}
