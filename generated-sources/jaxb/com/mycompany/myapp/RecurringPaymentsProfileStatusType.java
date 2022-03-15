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
 * <p>Java class for RecurringPaymentsProfileStatusType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RecurringPaymentsProfileStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="ActiveProfile"/>
 *     &lt;enumeration value="PendingProfile"/>
 *     &lt;enumeration value="CancelledProfile"/>
 *     &lt;enumeration value="ExpiredProfile"/>
 *     &lt;enumeration value="SuspendedProfile"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RecurringPaymentsProfileStatusType")
@XmlEnum
public enum RecurringPaymentsProfileStatusType {

    @XmlEnumValue("ActiveProfile")
    ACTIVE_PROFILE("ActiveProfile"),
    @XmlEnumValue("PendingProfile")
    PENDING_PROFILE("PendingProfile"),
    @XmlEnumValue("CancelledProfile")
    CANCELLED_PROFILE("CancelledProfile"),
    @XmlEnumValue("ExpiredProfile")
    EXPIRED_PROFILE("ExpiredProfile"),
    @XmlEnumValue("SuspendedProfile")
    SUSPENDED_PROFILE("SuspendedProfile");
    private final String value;

    RecurringPaymentsProfileStatusType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RecurringPaymentsProfileStatusType fromValue(String v) {
        for (RecurringPaymentsProfileStatusType c: RecurringPaymentsProfileStatusType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
