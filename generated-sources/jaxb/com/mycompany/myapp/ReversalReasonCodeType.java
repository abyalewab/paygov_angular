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
 * <p>Java class for ReversalReasonCodeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ReversalReasonCodeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="none"/>
 *     &lt;enumeration value="chargeback"/>
 *     &lt;enumeration value="guarantee"/>
 *     &lt;enumeration value="buyer-complaint"/>
 *     &lt;enumeration value="refund"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ReversalReasonCodeType")
@XmlEnum
public enum ReversalReasonCodeType {

    @XmlEnumValue("none")
    NONE("none"),
    @XmlEnumValue("chargeback")
    CHARGEBACK("chargeback"),
    @XmlEnumValue("guarantee")
    GUARANTEE("guarantee"),
    @XmlEnumValue("buyer-complaint")
    BUYER_COMPLAINT("buyer-complaint"),
    @XmlEnumValue("refund")
    REFUND("refund"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    ReversalReasonCodeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ReversalReasonCodeType fromValue(String v) {
        for (ReversalReasonCodeType c: ReversalReasonCodeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
