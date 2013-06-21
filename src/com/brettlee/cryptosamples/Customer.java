package com.brettlee.cryptosamples;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 
@XmlRootElement(name = "customer")
@XmlType(propOrder = {"name","pin","date","address","header"})
public class Customer {
 
    private String name;
    private int pin;
    private Date date;
    private Address address;
    private Header header;
    //private String addressl;
 
    /**
     * @return the date
     */
    @XmlElement(name = "Date")
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

   /* @XmlElement(name = "Address1")
    public String getAddressl() {
        return addressl;
    }

    public void setAddressl(String addressl) {
        this.addressl = addressl;
    }*/

    @XmlElement(name = "Address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @XmlElement(name="Name")
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @XmlElement(name = "Pin")
    public int getPin() {
        return pin;
    }
 
    public void setPin(int pin) {
        this.pin = pin;
    }
 
}