/**
 * 
 */
package com.brettlee.cryptosamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author saif.qasaimeh
 *
 */
public class EvveKeyStore {

    private KeyStore keyStore;
    private Key key;
    private Cipher cipher;
    
    /**
     * Create a keyStore and place the key in it
     * We're using a jceks keyStore, which is provided by Sun's JCE.
     * If you don't have the JCE installed, you can use "JKS",
     * which is the default keyStore. It doesn't provide
     * the same level of protection however.
     */
    EvveKeyStore(File file, char[] storPass,String alias){
        // Create a keyStore and load it from the fileSystem,
        try {
             keyStore = KeyStore.getInstance("JCEKS");
            if ( file.exists() ){
                final FileInputStream input   = new FileInputStream( file ); 
                keyStore.load(input, storPass);
                input.close();
                
            }
            key = (Key)keyStore.getKey("xx",storPass);
         // Create a cipher using that key to initialize it
             cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }
    
    /**
     *    Decrypts the ciphertext passes in and prints the plaintext
     *    . Pulls a key from a KeyStore in the filesystem,
     *    using the password given.
     */
    public  String doDecrypt(String encryptedMesg) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException{
        
        
        cipher.init(Cipher.DECRYPT_MODE, key);
       
        // Perform the decryption, first BASE64 decoding the ciphertext
        byte[] ciphertextBytes = new BASE64Decoder().decodeBuffer(encryptedMesg);
        byte[] decryptedText = cipher.doFinal(ciphertextBytes);
        
        String output = new String (decryptedText);
        
        System.out.println("Plaintext: "+ output);
        
        return output;
    }
    
    /**
     *    Encrypts the xnlText passed in and outputs
     *    
     */
    public String  doEncrypt(String xmlText) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        // Perform the actual encryption
        byte[] plaintextBytes = xmlText.getBytes();
        byte[] cipherText = cipher.doFinal(plaintextBytes);

        // Now we need to Base64-encode it for ascii display
        BASE64Encoder encoder = new BASE64Encoder();
        String output = encoder.encode(cipherText);

        System.out.println("Ciphertext: "+output);
        
        return output;
    }
    
}
