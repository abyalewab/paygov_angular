//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.11 at 02:58:17 PM EAT 
//


package com.mycompany.myapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *                 Information on user selected options
 *             
 * 
 * <p>Java class for UserSelectedOptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserSelectedOptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShippingCalculationMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="InsuranceOptionSelected" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippingOptionIsDefault" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ShippingOptionAmount" type="{urn:ebay:apis:CoreComponentTypes}BasicAmountType" minOccurs="0"/>
 *         &lt;element name="ShippingOptionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ScheduledShippingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ScheduledShippingPeriod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserSelectedOptionType", propOrder = {
    "shippingCalculationMode",
    "insuranceOptionSelected",
    "shippingOptionIsDefault",
    "shippingOptionAmount",
    "shippingOptionName",
    "scheduledShippingDate",
    "scheduledShippingPeriod"
})
public class UserSelectedOptionType {

    @XmlElement(name = "ShippingCalculationMode")
    protected String shippingCalculationMode;
    @XmlElement(name = "InsuranceOptionSelected")
    protected String insuranceOptionSelected;
    @XmlElement(name = "ShippingOptionIsDefault")
    protected String shippingOptionIsDefault;
    @XmlElement(name = "ShippingOptionAmount")
    protected BasicAmountType shippingOptionAmount;
    @XmlElement(name = "ShippingOptionName")
    protected String shippingOptionName;
    @XmlElement(name = "ScheduledShippingDate")
    protected String scheduledShippingDate;
    @XmlElement(name = "ScheduledShippingPeriod")
    protected String scheduledShippingPeriod;

    /**
     * Gets the value of the shippingCalculationMode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingCalculationMode() {
        return shippingCalculationMode;
    }

    /**
     * Sets the value of the shippingCalculationMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingCalculationMode(String value) {
        this.shippingCalculationMode = value;
    }

    /**
     * Gets the value of the insuranceOptionSelected property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsuranceOptionSelected() {
        return insuranceOptionSelected;
    }

    /**
     * Sets the value of the insuranceOptionSelected property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsuranceOptionSelected(String value) {
        this.insuranceOptionSelected = value;
    }

    /**
     * Gets the value of the shippingOptionIsDefault property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingOptionIsDefault() {
        return shippingOptionIsDefault;
    }

    /**
     * Sets the value of the shippingOptionIsDefault property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingOptionIsDefault(String value) {
        this.shippingOptionIsDefault = value;
    }

    /**
     * Gets the value of the shippingOptionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BasicAmountType }
     *     
     */
    public BasicAmountType getShippingOptionAmount() {
        return shippingOptionAmount;
    }

    /**
     * Sets the value of the shippingOptionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BasicAmountType }
     *     
     */
    public void setShippingOptionAmount(BasicAmountType value) {
        this.shippingOptionAmount = value;
    }

    /**
     * Gets the value of the shippingOptionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShippingOptionName() {
        return shippingOptionName;
    }

    /**
     * Sets the value of the shippingOptionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShippingOptionName(String value) {
        this.shippingOptionName = value;
    }

    /**
     * Gets the value of the scheduledShippingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledShippingDate() {
        return scheduledShippingDate;
    }

    /**
     * Sets the value of the scheduledShippingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledShippingDate(String value) {
        this.scheduledShippingDate = value;
    }

    /**
     * Gets the value of the scheduledShippingPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduledShippingPeriod() {
        return scheduledShippingPeriod;
    }

    /**
     * Sets the value of the scheduledShippingPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduledShippingPeriod(String value) {
        this.scheduledShippingPeriod = value;
    }

}
