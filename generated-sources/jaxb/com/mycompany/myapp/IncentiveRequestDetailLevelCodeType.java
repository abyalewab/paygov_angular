//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.08 at 03:44:17 PM EAT 
//


package com.mycompany.myapp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for IncentiveRequestDetailLevelCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="IncentiveRequestDetailLevelCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="Aggregated"/>
 *     &lt;enumeration value="Detail"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "IncentiveRequestDetailLevelCodeType")
@XmlEnum
public enum IncentiveRequestDetailLevelCodeType {

    @XmlEnumValue("Aggregated")
    AGGREGATED("Aggregated"),
    @XmlEnumValue("Detail")
    DETAIL("Detail");
    private final String value;

    IncentiveRequestDetailLevelCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IncentiveRequestDetailLevelCodeType fromValue(String v) {
        for (IncentiveRequestDetailLevelCodeType c: IncentiveRequestDetailLevelCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
