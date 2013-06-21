package com.jaxb.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.brettlee.cryptosamples.Address;
import com.brettlee.cryptosamples.Customer;

public class MainTest {

    /**
     * @param args
     * @throws ParseException 
     */
    public static void main(String[] args) throws ParseException {
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        calendar.set(Calendar.YEAR, 1942);
        calendar.set(Calendar.MONTH, 11); 
        calendar.set(Calendar.DAY_OF_MONTH, 04); // 
       
       Customer customer =  new Customer();
       Address addr = new Address();
       addr.setStreet("asdf");
       customer.setAddress(addr);
       customer.setName("saif");
       System.out.println(sdf.format(calendar.getTime()));
      customer.setDate(sdf.parse( sdf.format(calendar.getTime())));
       XmlUtil xml = new XmlUtil();
       customer.setPin(123);
      System.out.println( xml.convertToXml(customer, customer.getClass()));

    }

}
