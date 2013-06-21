package com.brettlee.cryptosamples;

import java.io.File;

import com.thoughtworks.xstream.XStream;

public class testnig {

    
    private static File file = new File("keyStoreDownload.do");
    private static char[] storPass = "Kess123#$".toCharArray();
    private static String alias = "AGENCY-KESS";
    /**
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "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0000";
        byte[] dec = str1.getBytes();
        Customer customer = new Customer();
        customer.setName("customerrrrr");
        Address address = new Address();
        address.setStreet("123");
        customer.setAddress(address);
        TestKeyStore key =  new TestKeyStore(file, storPass, alias);
        XStream xs = new XStream();
        String str =  xs.toXML(customer);
        System.out.println(str);
        System.out.println("\n");
        
        byte[] object =key.doEncrypt(str);
        //encrypt
        
        //decrypt
        String decMessage = key.doDecrypt(object);
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
