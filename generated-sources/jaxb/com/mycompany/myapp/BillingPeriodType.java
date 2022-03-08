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
 * <p>Java class for BillingPeriodType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="BillingPeriodType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="NoBillingPeriodType"/>
 *     &lt;enumeration value="Day"/>
 *     &lt;enumeration value="Week"/>
 *     &lt;enumeration value="SemiMonth"/>
 *     &lt;enumeration value="Month"/>
 *     &lt;enumeration value="Year"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "BillingPeriodType")
@XmlEnum
public enum BillingPeriodType {

    @XmlEnumValue("NoBillingPeriodType")
    NO_BILLING_PERIOD_TYPE("NoBillingPeriodType"),
    @XmlEnumValue("Day")
    DAY("Day"),
    @XmlEnumValue("Week")
    WEEK("Week"),
    @XmlEnumValue("SemiMonth")
    SEMI_MONTH("SemiMonth"),
    @XmlEnumValue("Month")
    MONTH("Month"),
    @XmlEnumValue("Year")
    YEAR("Year");
    private final String value;

    BillingPeriodType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BillingPeriodType fromValue(String v) {
        for (BillingPeriodType c: BillingPeriodType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}