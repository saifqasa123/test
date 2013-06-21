/**
 * 
 */
package com.brettlee.cryptosamples;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author saif.qasaimeh
 *
 */
@XmlRootElement(name = "address")
public class Address {

    private String street;
    private String zip;
    
    @XmlElement
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    @XmlElement
    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    
}
