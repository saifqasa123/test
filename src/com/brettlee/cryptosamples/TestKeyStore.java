package com.brettlee.cryptosamples;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.security.Key;
import java.security.KeyStore;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.thoughtworks.xstream.XStream;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;


public class TestKeyStore {

    private KeyStore keyStore;
    private int aesKeysize = 128;
    private KeyGenerator aesKeyGen;    
    private SecretKeySpec skeySpec1 ;
    private SecretKeySpec skeySpec2 ;
    Key myKey ;
    TestKeyStore(File file, char[] storPass,String alias ){

        try {

            keyStore = KeyStore.getInstance("JCEKS");

            if ( file.exists() ) {  
                final FileInputStream input   = new FileInputStream( file );
                keyStore.load( input, storPass );
                input.close();
            }

            // this.password = storPass.toString();
           // myKey = keyStore.getKey("xx", storPass);//new 
            aesKeyGen = KeyGenerator.getInstance("AES");
            aesKeyGen.init(aesKeysize);             
        } catch (Exception e) {
            e.printStackTrace();
        }             
    }    

    public  byte[] doEncrypt(Object msg) {

        byte[] encrypted = null;

        try {
           // byte[] customer = serialize(msg);
            //Generate random asymmetric key for encryption
           // String message = fromJavaToXML((Serializable) msg);
            SecretKey skey = aesKeyGen.generateKey();
            byte[] rawKey = skey.getEncoded();
            skeySpec1 = new SecretKeySpec(rawKey, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec1);
            encrypted = cipher.doFinal( ((String) msg).getBytes() );
           // encrypted = cipher.doFinal( customer );
           System.out.println("Encrypted (keystore): " + asHex(encrypted));



        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }   



   /* private byte[] serialize(Object msg)throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(msg);
        return b.toByteArray();
        
    }*/
    
    public static String fromJavaToXML(Serializable object) {
        XStream xs = new XStream();
        return xs.toXML(object);
    }

    public String doDecrypt(byte[] encryptedMesg) {
        
        Customer customer = null;
        String originalString = null;
        try {
            SecretKey skey = aesKeyGen.generateKey();
           byte[] rawKey = skey.getEncoded();
          
            skeySpec2 = new SecretKeySpec(rawKey, "AES");
            
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec1);
            byte[] original = cipher.doFinal(encryptedMesg);
            originalString = new String(original);
           customer = (Customer) fromXMLToJava(originalString);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return originalString;

    }
    
    
   
    

    public static Object fromXMLToJava(String xml){
        XStream xs = new XStream();
        return xs.fromXML(xml);
    }
    
    public Object toObject(byte[] dataReceived) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(dataReceived);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {   
            ex.printStackTrace();
        }
        return obj;
    }

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



}

