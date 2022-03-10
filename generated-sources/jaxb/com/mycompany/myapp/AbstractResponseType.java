//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.03.10 at 02:27:56 PM EAT 
//


package com.mycompany.myapp;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.w3c.dom.Element;


/**
 * 
 *                 Base type definition of a response payload that can carry any
 *                 type of payload content with following optional elements:
 *                 - timestamp of response message,
 *                 - application level acknowledgement, and
 *                 - application-level errors and warnings.
 *             
 * 
 * <p>Java class for AbstractResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Timestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="Ack" type="{urn:ebay:apis:eBLBaseComponents}AckCodeType"/>
 *         &lt;element name="CorrelationID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Errors" type="{urn:ebay:apis:eBLBaseComponents}ErrorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Build" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;any/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractResponseType", propOrder = {
    "timestamp",
    "ack",
    "correlationID",
    "errors",
    "version",
    "build",
    "any"
})
@XmlSeeAlso({
    BMGetButtonDetailsResponseType.class,
    UpdateRecurringPaymentsProfileResponseType.class,
    BMManageButtonStatusResponseType.class,
    DoCaptureResponseType.class,
    ManageRecurringPaymentsProfileStatusResponseType.class,
    BillOutstandingAmountResponseType.class,
    GetTransactionDetailsResponseType.class,
    DoReferenceTransactionResponseType.class,
    UpdateAccessPermissionsResponseType.class,
    GetBalanceResponseType.class,
    AddressVerifyResponseType.class,
    GetAccessPermissionDetailsResponseType.class,
    ReverseTransactionResponseType.class,
    ExecuteCheckoutOperationsResponseType.class,
    CreateBillingAgreementResponseType.class,
    CancelRecoupResponseType.class,
    EnterBoardingResponseType.class,
    BMUpdateButtonResponseType.class,
    BAUpdateResponseType.class,
    UpdateAuthorizationResponseType.class,
    CreateMobilePaymentResponseType.class,
    CompleteRecoupResponseType.class,
    ManagePendingTransactionStatusResponseType.class,
    DoExpressCheckoutPaymentResponseType.class,
    DoCancelResponseType.class,
    GetIncentiveEvaluationResponseType.class,
    MassPayResponseType.class,
    RefundTransactionResponseType.class,
    DoDirectPaymentResponseType.class,
    GetAuthDetailsResponseType.class,
    SetAuthFlowParamResponseType.class,
    DoVoidResponseType.class,
    GetExpressCheckoutDetailsResponseType.class,
    GetRecurringPaymentsProfileDetailsResponseType.class,
    DoReauthorizationResponseType.class,
    GetBoardingDetailsResponseType.class,
    SetExpressCheckoutResponseType.class,
    InitiateRecoupResponseType.class,
    ExternalRememberMeOptOutResponseType.class,
    DoMobileCheckoutPaymentResponseType.class,
    BMCreateButtonResponseType.class,
    DoNonReferencedCreditResponseType.class,
    GetPalDetailsResponseType.class,
    BillUserResponseType.class,
    SetAccessPermissionsResponseType.class,
    SetCustomerBillingAgreementResponseType.class,
    TransactionSearchResponseType.class,
    SetMobileCheckoutResponseType.class,
    BMButtonSearchResponseType.class,
    GetMobileStatusResponseType.class,
    BMGetInventoryResponseType.class,
    GetBillingAgreementCustomerDetailsResponseType.class,
    CreateRecurringPaymentsProfileResponseType.class,
    BMSetInventoryResponseType.class,
    DoAuthorizationResponseType.class
})
public abstract class AbstractResponseType {

    @XmlElement(name = "Timestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar timestamp;
    @XmlElement(name = "Ack", required = true)
    protected AckCodeType ack;
    @XmlElement(name = "CorrelationID")
    protected String correlationID;
    @XmlElement(name = "Errors")
    protected List<ErrorType> errors;
    @XmlElement(name = "Version", required = true)
    protected String version;
    @XmlElement(name = "Build", required = true)
    protected String build;
    @XmlAnyElement(lax = true)
    protected Object any;

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimestamp(XMLGregorianCalendar value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the ack property.
     * 
     * @return
     *     possible object is
     *     {@link AckCodeType }
     *     
     */
    public AckCodeType getAck() {
        return ack;
    }

    /**
     * Sets the value of the ack property.
     * 
     * @param value
     *     allowed object is
     *     {@link AckCodeType }
     *     
     */
    public void setAck(AckCodeType value) {
        this.ack = value;
    }

    /**
     * Gets the value of the correlationID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorrelationID() {
        return correlationID;
    }

    /**
     * Sets the value of the correlationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorrelationID(String value) {
        this.correlationID = value;
    }

    /**
     * Gets the value of the errors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorType }
     * 
     * 
     */
    public List<ErrorType> getErrors() {
        if (errors == null) {
            errors = new ArrayList<ErrorType>();
        }
        return this.errors;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the build property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuild() {
        return build;
    }

    /**
     * Sets the value of the build property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuild(String value) {
        this.build = value;
    }

    /**
     * Gets the value of the any property.
     * 
     * @return
     *     possible object is
     *     {@link Element }
     *     {@link Object }
     *     
     */
    public Object getAny() {
        return any;
    }

    /**
     * Sets the value of the any property.
     * 
     * @param value
     *     allowed object is
     *     {@link Element }
     *     {@link Object }
     *     
     */
    public void setAny(Object value) {
        this.any = value;
    }

}
