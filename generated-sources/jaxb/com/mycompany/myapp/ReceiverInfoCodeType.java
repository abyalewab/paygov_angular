//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.10 at 02:27:56 PM EAT 
//


package com.mycompany.myapp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ReceiverInfoCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReceiverInfoCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="EmailAddress"/>
 *     &lt;enumeration value="UserID"/>
 *     &lt;enumeration value="PhoneNumber"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReceiverInfoCodeType")
@XmlEnum
public enum ReceiverInfoCodeType {

    @XmlEnumValue("EmailAddress")
    EMAIL_ADDRESS("EmailAddress"),
    @XmlEnumValue("UserID")
    USER_ID("UserID"),
    @XmlEnumValue("PhoneNumber")
    PHONE_NUMBER("PhoneNumber");
    private final String value;

    ReceiverInfoCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReceiverInfoCodeType fromValue(String v) {
        for (ReceiverInfoCodeType c: ReceiverInfoCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
