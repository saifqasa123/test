package com.jaxb.test;
/**
 * 
 */


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
/**
 * @author saif.qasaimeh
 *
 */
public class XmlUtil {
    public String convertToXml(Object source, Class... type) {
        String result;
        StringWriter sw = new StringWriter();
        try {
            JAXBContext Context = JAXBContext.newInstance(type);
            Marshaller carMarshaller = Context.createMarshaller();
            carMarshaller.marshal(source, sw);
            result = sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

}
