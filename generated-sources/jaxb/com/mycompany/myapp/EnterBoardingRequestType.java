//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.10 at 02:27:56 PM EAT 
//


package com.mycompany.myapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EnterBoardingRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnterBoardingRequestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:ebay:apis:eBLBaseComponents}AbstractRequestType">
 *       &lt;sequence>
 *         &lt;element ref="{urn:ebay:apis:eBLBaseComponents}EnterBoardingRequestDetails"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnterBoardingRequestType", namespace = "urn:ebay:api:PayPalAPI", propOrder = {
    "enterBoardingRequestDetails"
})
public class EnterBoardingRequestType
    extends AbstractRequestType
{

    @XmlElement(name = "EnterBoardingRequestDetails", namespace = "urn:ebay:apis:eBLBaseComponents", required = true)
    protected EnterBoardingRequestDetailsType enterBoardingRequestDetails;

    /**
     * Gets the value of the enterBoardingRequestDetails property.
     * 
     * @return
     *     possible object is
     *     {@link EnterBoardingRequestDetailsType }
     *     
     */
    public EnterBoardingRequestDetailsType getEnterBoardingRequestDetails() {
        return enterBoardingRequestDetails;
    }

    /**
     * Sets the value of the enterBoardingRequestDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnterBoardingRequestDetailsType }
     *     
     */
    public void setEnterBoardingRequestDetails(EnterBoardingRequestDetailsType value) {
        this.enterBoardingRequestDetails = value;
    }

}
