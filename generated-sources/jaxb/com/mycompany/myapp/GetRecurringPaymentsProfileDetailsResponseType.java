//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.08 at 03:44:17 PM EAT 
//


package com.mycompany.myapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetRecurringPaymentsProfileDetailsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetRecurringPaymentsProfileDetailsResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:ebay:apis:eBLBaseComponents}AbstractResponseType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:ebay:apis:eBLBaseComponents}GetRecurringPaymentsProfileDetailsResponseDetails"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetRecurringPaymentsProfileDetailsResponseType", namespace = "urn:ebay:api:PayPalAPI", propOrder = {
    "getRecurringPaymentsProfileDetailsResponseDetails"
})
public class GetRecurringPaymentsProfileDetailsResponseType
    extends AbstractResponseType
{

    @XmlElement(name = "GetRecurringPaymentsProfileDetailsResponseDetails", namespace = "urn:ebay:apis:eBLBaseComponents", required = true)
    protected GetRecurringPaymentsProfileDetailsResponseDetailsType getRecurringPaymentsProfileDetailsResponseDetails;

    /**
     * Gets the value of the getRecurringPaymentsProfileDetailsResponseDetails property.
     * 
     * @return
     *     possible object is
     *     {@link GetRecurringPaymentsProfileDetailsResponseDetailsType }
     *     
     */
    public GetRecurringPaymentsProfileDetailsResponseDetailsType getGetRecurringPaymentsProfileDetailsResponseDetails() {
        return getRecurringPaymentsProfileDetailsResponseDetails;
    }

    /**
     * Sets the value of the getRecurringPaymentsProfileDetailsResponseDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRecurringPaymentsProfileDetailsResponseDetailsType }
     *     
     */
    public void setGetRecurringPaymentsProfileDetailsResponseDetails(GetRecurringPaymentsProfileDetailsResponseDetailsType value) {
        this.getRecurringPaymentsProfileDetailsResponseDetails = value;
    }

}
