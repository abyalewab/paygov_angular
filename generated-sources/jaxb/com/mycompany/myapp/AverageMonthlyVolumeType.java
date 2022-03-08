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
 * <p>Java class for AverageMonthlyVolumeType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AverageMonthlyVolumeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *     &lt;enumeration value="AverageMonthlyVolume-Not-Applicable"/>
 *     &lt;enumeration value="AverageMonthlyVolume-Range1"/>
 *     &lt;enumeration value="AverageMonthlyVolume-Range2"/>
 *     &lt;enumeration value="AverageMonthlyVolume-Range3"/>
 *     &lt;enumeration value="AverageMonthlyVolume-Range4"/>
 *     &lt;enumeration value="AverageMonthlyVolume-Range5"/>
 *     &lt;enumeration value="AverageMonthlyVolume-Range6"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "AverageMonthlyVolumeType")
@XmlEnum
public enum AverageMonthlyVolumeType {

    @XmlEnumValue("AverageMonthlyVolume-Not-Applicable")
    AVERAGE_MONTHLY_VOLUME_NOT_APPLICABLE("AverageMonthlyVolume-Not-Applicable"),
    @XmlEnumValue("AverageMonthlyVolume-Range1")
    AVERAGE_MONTHLY_VOLUME_RANGE_1("AverageMonthlyVolume-Range1"),
    @XmlEnumValue("AverageMonthlyVolume-Range2")
    AVERAGE_MONTHLY_VOLUME_RANGE_2("AverageMonthlyVolume-Range2"),
    @XmlEnumValue("AverageMonthlyVolume-Range3")
    AVERAGE_MONTHLY_VOLUME_RANGE_3("AverageMonthlyVolume-Range3"),
    @XmlEnumValue("AverageMonthlyVolume-Range4")
    AVERAGE_MONTHLY_VOLUME_RANGE_4("AverageMonthlyVolume-Range4"),
    @XmlEnumValue("AverageMonthlyVolume-Range5")
    AVERAGE_MONTHLY_VOLUME_RANGE_5("AverageMonthlyVolume-Range5"),
    @XmlEnumValue("AverageMonthlyVolume-Range6")
    AVERAGE_MONTHLY_VOLUME_RANGE_6("AverageMonthlyVolume-Range6");
    private final String value;

    AverageMonthlyVolumeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AverageMonthlyVolumeType fromValue(String v) {
        for (AverageMonthlyVolumeType c: AverageMonthlyVolumeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
