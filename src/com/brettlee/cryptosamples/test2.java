package com.brettlee.cryptosamples;

import java.io.File;

import com.thoughtworks.xstream.XStream;

public class test2 {

    
    private static File file = new File("keyStoreDownload.do");
    private static char[] storPass = "Kess123#$".toCharArray();
    private static String alias = "AGENCY-KESS";
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "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";
        byte[] dec = str1.getBytes();
        Customer customer = new Customer();
        customer.setName("customerrrrr");
        Address address = new Address();
        address.setStreet("123");
        TestKeyStore key =  new TestKeyStore(file, storPass, alias);
        XStream xs = new XStream();
        String str =  xs.toXML(address);
        System.out.println(str);
        System.out.println("\n");
        
        byte[] object =key.doEncrypt(str);
        
       // customer.setAddressl(new String(object));
        
        
        System.out.println(xs.toXML(customer));
        //encrypt
        
        //decrypt
        String decMessage = key.doDecrypt(str1.getBytes());
        System.out.println("\n");
        System.out.println(decMessage);
        

    }
    /*public static void main(String[] args) {
        String str1 = "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000";
        byte[] dec = str1.getBytes();
        
        TestKeyStore key =  new TestKeyStore(file, storPass, alias);
      //  key.doDecrypt(dec);
        
        System.out.println("Decrypted : " + key.doDecrypt(dec));
    }*/

}
