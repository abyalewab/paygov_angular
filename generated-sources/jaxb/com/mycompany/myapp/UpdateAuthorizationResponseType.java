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
 * <p>Java class for UpdateAuthorizationResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateAuthorizationResponseType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:ebay:apis:eBLBaseComponents}AbstractResponseType">
 *       &lt;sequence>
 *         &lt;element name="TransactionID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{urn:ebay:apis:eBLBaseComponents}AuthorizationInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateAuthorizationResponseType", namespace = "urn:ebay:api:PayPalAPI", propOrder = {
    "transactionID",
    "authorizationInfo"
})
public class UpdateAuthorizationResponseType
    extends AbstractResponseType
{

    @XmlElement(name = "TransactionID")
    protected String transactionID;
    @XmlElement(name = "AuthorizationInfo", namespace = "urn:ebay:apis:eBLBaseComponents")
    protected AuthorizationInfoType authorizationInfo;

    /**
     * Gets the value of the transactionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionID() {
        return transactionID;
    }

    /**
     * Sets the value of the transactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionID(String value) {
        this.transactionID = value;
    }

    /**
     * Gets the value of the authorizationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link AuthorizationInfoType }
     *     
     */
    public AuthorizationInfoType getAuthorizationInfo() {
        return authorizationInfo;
    }

    /**
     * Sets the value of the authorizationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link AuthorizationInfoType }
     *     
     */
    public void setAuthorizationInfo(AuthorizationInfoType value) {
        this.authorizationInfo = value;
    }

}
