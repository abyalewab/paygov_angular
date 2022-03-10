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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * 
 *                 Base type definition of request payload that can carry any type
 *                 of payload content with optional versioning information and detail level
 *                 requirements.
 *             
 * 
 * <p>Java class for AbstractRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DetailLevel" type="{urn:ebay:apis:eBLBaseComponents}DetailLevelCodeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ErrorLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "AbstractRequestType", propOrder = {
    "detailLevel",
    "errorLanguage",
    "version",
    "any"
})
@XmlSeeAlso({
    CreateMobilePaymentRequestType.class,
    SetExpressCheckoutRequestType.class,
    SetMobileCheckoutRequestType.class,
    GetBalanceRequestType.class,
    AddressVerifyRequestType.class,
    DoAuthorizationRequestType.class,
    BMSetInventoryRequestType.class,
    BAUpdateRequestType.class,
    SetAccessPermissionsRequestType.class,
    DoCancelRequestType.class,
    DoUATPAuthorizationRequestType.class,
    RefundTransactionRequestType.class,
    DoNonReferencedCreditRequestType.class,
    UpdateRecurringPaymentsProfileRequestType.class,
    ManagePendingTransactionStatusRequestType.class,
    BMGetButtonDetailsRequestType.class,
    GetTransactionDetailsRequestType.class,
    DoReferenceTransactionRequestType.class,
    BMCreateButtonRequestType.class,
    DoReauthorizationRequestType.class,
    BillOutstandingAmountRequestType.class,
    GetPalDetailsRequestType.class,
    MassPayRequestType.class,
    GetIncentiveEvaluationRequestType.class,
    UpdateAccessPermissionsRequestType.class,
    UpdateAuthorizationRequestType.class,
    SetAuthFlowParamRequestType.class,
    ReverseTransactionRequestType.class,
    BMGetInventoryRequestType.class,
    GetAuthDetailsRequestType.class,
    DoMobileCheckoutPaymentRequestType.class,
    ExecuteCheckoutOperationsRequestType.class,
    CreateBillingAgreementRequestType.class,
    BMButtonSearchRequestType.class,
    GetRecurringPaymentsProfileDetailsRequestType.class,
    DoExpressCheckoutPaymentRequestType.class,
    GetExpressCheckoutDetailsRequestType.class,
    GetBillingAgreementCustomerDetailsRequestType.class,
    CancelRecoupRequestType.class,
    BMUpdateButtonRequestType.class,
    ManageRecurringPaymentsProfileStatusRequestType.class,
    ExternalRememberMeOptOutRequestType.class,
    InitiateRecoupRequestType.class,
    GetBoardingDetailsRequestType.class,
    DoCaptureRequestType.class,
    SetCustomerBillingAgreementRequestType.class,
    CreateRecurringPaymentsProfileRequestType.class,
    EnterBoardingRequestType.class,
    DoDirectPaymentRequestType.class,
    GetMobileStatusRequestType.class,
    TransactionSearchRequestType.class,
    DoVoidRequestType.class,
    BMManageButtonStatusRequestType.class,
    CompleteRecoupRequestType.class,
    BillUserRequestType.class,
    GetAccessPermissionDetailsRequestType.class
})
public abstract class AbstractRequestType {

    @XmlElement(name = "DetailLevel")
    protected List<DetailLevelCodeType> detailLevel;
    @XmlElement(name = "ErrorLanguage")
    protected String errorLanguage;
    @XmlElement(name = "Version", required = true)
    protected String version;
    @XmlAnyElement(lax = true)
    protected Object any;

    /**
     * Gets the value of the detailLevel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the detailLevel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDetailLevel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DetailLevelCodeType }
     * 
     * 
     */
    public List<DetailLevelCodeType> getDetailLevel() {
        if (detailLevel == null) {
            detailLevel = new ArrayList<DetailLevelCodeType>();
        }
        return this.detailLevel;
    }

    /**
     * Gets the value of the errorLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorLanguage() {
        return errorLanguage;
    }

    /**
     * Sets the value of the errorLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorLanguage(String value) {
        this.errorLanguage = value;
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
