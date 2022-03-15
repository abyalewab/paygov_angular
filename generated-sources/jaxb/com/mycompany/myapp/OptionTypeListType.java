//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.11 at 02:58:17 PM EAT 
//


package com.mycompany.myapp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OptionTypeListType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="OptionTypeListType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="NoOptionType"/>
 *     &lt;enumeration value="FULL"/>
 *     &lt;enumeration value="EMI"/>
 *     &lt;enumeration value="VARIABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "OptionTypeListType")
@XmlEnum
public enum OptionTypeListType {

    @XmlEnumValue("NoOptionType")
    NO_OPTION_TYPE("NoOptionType"),
    FULL("FULL"),
    EMI("EMI"),
    VARIABLE("VARIABLE");
    private final String value;

    OptionTypeListType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OptionTypeListType fromValue(String v) {
        for (OptionTypeListType c: OptionTypeListType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
