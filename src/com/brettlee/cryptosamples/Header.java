package com.brettlee.cryptosamples;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "header")
public class Header {

    private String header;

    @XmlElement
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
