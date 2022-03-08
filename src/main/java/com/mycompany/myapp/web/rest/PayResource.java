package com.mycompany.myapp.web.rest;

import com.ingenico.connect.gateway.sdk.java.Client;
import com.ingenico.connect.gateway.sdk.java.CommunicatorConfiguration;
import com.ingenico.connect.gateway.sdk.java.Factory;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.Address;
import com.ingenico.connect.gateway.sdk.java.domain.definitions.AmountOfMoney;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.CreateHostedCheckoutRequest;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.CreateHostedCheckoutResponse;
import com.ingenico.connect.gateway.sdk.java.domain.hostedcheckout.definitions.HostedCheckoutSpecificInput;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.Customer;
import com.ingenico.connect.gateway.sdk.java.domain.payment.definitions.Order;
import com.mycompany.myapp.asynctest.SendMail;
import com.mycompany.myapp.domain.Pay;
import com.mycompany.myapp.repository.PayRepository;
import com.mycompany.myapp.util.Configuration;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.paypal.exception.*;
import com.paypal.sdk.exceptions.PayPalException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import tech.jhipster.web.util.HeaderUtil;
import urn.ebay.api.PayPalAPI.*;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.*;

@RestController
@RequestMapping("/api")
@Transactional
public class PayResource {

    private final Logger log = LoggerFactory.getLogger(PayResource.class);

    SetExpressCheckoutResponseType setExpressCheckoutResponse;

    private static final String ENTITY_NAME = "pay";
    Pay payAmount;

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PayRepository payRepository;

    public PayResource(PayRepository payRepository) {
        this.payRepository = payRepository;
    }

    @PostMapping("/pays")
    public ResponseEntity<Pay> createPay(@RequestBody Pay pay) throws URISyntaxException {
        log.debug("REST request to save Pay : {}", pay);
        if (pay.getId() != null) {
            throw new BadRequestAlertException("A new pay cannot already have an ID", ENTITY_NAME, "idexists");
        }

        Pay result = payRepository.save(pay);
        SendMail mail = new SendMail();
        mail.sendMail(pay.getEmail(), pay.getApprovalStatus(), pay.getName());

        return ResponseEntity
            .created(new URI("/api/pays/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @PostMapping("/amountOfMoney")
    public String getPayment(@Valid @RequestBody Pay pay) {
        this.payAmount = pay;
        return "payAmount";
    }

    @GetMapping("/paymentSB")
    public CreateHostedCheckoutResponse getRedirectUrl() throws URISyntaxException, IOException {
        try (Client client = getClient()) {
            HostedCheckoutSpecificInput hostedCheckoutSpecificInput = new HostedCheckoutSpecificInput();

            hostedCheckoutSpecificInput.setLocale("en_GB");
            hostedCheckoutSpecificInput.setVariant("100");
            hostedCheckoutSpecificInput.setReturnUrl(this.returnUrl);
            hostedCheckoutSpecificInput.setShowResultPage(false);

            AmountOfMoney amountOfMoney = new AmountOfMoney();
            amountOfMoney.setAmount(payAmount.getPaymentAmount().longValue());
            amountOfMoney.setCurrencyCode("USD");

            Address billingAddress = new Address();
            billingAddress.setCountryCode("US");

            Customer customer = new Customer();
            customer.setBillingAddress(billingAddress);
            customer.setMerchantCustomerId("1234");

            Order order = new Order();
            order.setAmountOfMoney(amountOfMoney);
            order.setCustomer(customer);

            CreateHostedCheckoutRequest body = new CreateHostedCheckoutRequest();
            body.setHostedCheckoutSpecificInput(hostedCheckoutSpecificInput);
            body.setOrder(order);

            CreateHostedCheckoutResponse response = client.merchant("1089").hostedcheckouts().create(body);
            log.info("Worldline partial redirect url : {}", response.getPartialRedirectUrl());

            return response;
        }
    }

    @Value("${spring.application.apiKeyId}")
    String apiKeyId;

    @Value("${spring.application.secretApiKey}")
    String secretApiKey;

    private com.ingenico.connect.gateway.sdk.java.Client getClient() throws URISyntaxException {
        String apiKey = System.getProperty("apiKeyId", this.apiKeyId);
        String secretApi = System.getProperty("secretApiKey", this.secretApiKey);

        URL propertiesUrl = getClass().getResource("/hostedpaymentpage.properties");
        assert propertiesUrl != null;
        CommunicatorConfiguration configuration = Factory.createConfiguration(propertiesUrl.toURI(), apiKey, secretApi);
        return Factory.createClient(configuration);
    }

    @Value("${spring.application.paypalUrl}")
    String paypalUrl;

    @Value("${spring.application.returnUrl}")
    String returnUrl;

    @Value("${spring.application.cancelUrl}")
    String cancelUrl;

    @GetMapping("/paypal")
    public String setExpressCheckout()
        throws PayPalException, ClientActionRequiredException, SSLConfigurationException, MissingCredentialException, InvalidResponseDataException, InvalidCredentialException, IOException, HttpErrorException, InterruptedException, SAXException, ParserConfigurationException {
        Long payerId = 5L;
        String paymentAmount = payAmount.getPaymentAmount().toString();

        String returnURL = this.returnUrl;
        String cancelURL = this.cancelUrl;

        PaymentActionCodeType paymentAction = PaymentActionCodeType.SALE;
        CurrencyCodeType currencyCode = CurrencyCodeType.EUR;

        Map<String, String> configurationMap = Configuration.getAcctAndConfig();
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configurationMap);

        SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
        setExpressCheckoutReq.setVersion("63.0");

        SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

        PaymentDetailsType paymentDetails = new PaymentDetailsType();
        paymentDetails.setOrderDescription("PayGov integration with paypal");
        paymentDetails.setInvoiceID("INVOICE-" + Math.random());
        BasicAmountType orderTotal = new BasicAmountType();
        orderTotal.setValue(paymentAmount);
        orderTotal.setCurrencyID(currencyCode);
        paymentDetails.setOrderTotal(orderTotal);
        paymentDetails.setPaymentAction(paymentAction);
        details.setPaymentDetails(Arrays.asList(new PaymentDetailsType[] { paymentDetails }));
        details.setReturnURL(returnURL);
        details.setCancelURL(cancelURL);
        details.setCustom(payerId.toString());

        setExpressCheckoutReq.setSetExpressCheckoutRequestDetails(details);

        SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();

        expressCheckoutReq.setSetExpressCheckoutRequest(setExpressCheckoutReq);

        setExpressCheckoutResponse = service.setExpressCheckout(expressCheckoutReq);

        getExpressCheckoutDetails(setExpressCheckoutResponse.getToken());

        String redirectURL = (this.paypalUrl + setExpressCheckoutResponse.getToken());

        log.info("Paypal returned url : {}", redirectURL);

        return JSONObject.quote(redirectURL);
    }

    AckCodeType doExpressResponse;

    @GetMapping("/paypalDoEC")
    public String startDoExpressResponse()
        throws ClientActionRequiredException, SSLConfigurationException, MissingCredentialException, InvalidResponseDataException, InvalidCredentialException, IOException, ParserConfigurationException, HttpErrorException, InterruptedException, SAXException {
        try {
            doExpressResponse(getExpressCheckoutDetails(setExpressCheckoutResponse.getToken()));
        } catch (PayPalException e) {
            e.printStackTrace();
        }
        return "DoExpressCheckoutPaymentResponseType : " + doExpressResponse;
    }

    public GetExpressCheckoutDetailsResponseDetailsType getExpressCheckoutDetails(String token)
        throws PayPalException, SAXException, ParserConfigurationException, SSLConfigurationException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, IOException, InterruptedException, InvalidCredentialException {
        Map<String, String> configurationMap = Configuration.getAcctAndConfig();
        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configurationMap);

        GetExpressCheckoutDetailsReq getExpressCheckoutDetailsReq = new GetExpressCheckoutDetailsReq();
        GetExpressCheckoutDetailsRequestType getExpressCheckoutDetailsRequestType = new GetExpressCheckoutDetailsRequestType();
        getExpressCheckoutDetailsRequestType.setVersion("63.0");

        getExpressCheckoutDetailsReq.setGetExpressCheckoutDetailsRequest(new GetExpressCheckoutDetailsRequestType(token));
        GetExpressCheckoutDetailsResponseType getExpressCheckoutDetailsResponseType = service.getExpressCheckoutDetails(
            getExpressCheckoutDetailsReq
        );

        log.info("GetExpressCheckoutDetailsResponseDetailsType");
        log.info(
            "PayerID         : {}",
            getExpressCheckoutDetailsResponseType.getGetExpressCheckoutDetailsResponseDetails().getPayerInfo().getPayerID()
        );
        log.info("Ack             : {}", getExpressCheckoutDetailsResponseType.getAck());
        log.info("Token           : {}", getExpressCheckoutDetailsResponseType.getGetExpressCheckoutDetailsResponseDetails().getToken());
        log.info(
            "Payment Details : {}",
            getExpressCheckoutDetailsResponseType.getGetExpressCheckoutDetailsResponseDetails().getPaymentDetails()
        );
        log.info(
            "Payment Info    : {}",
            getExpressCheckoutDetailsResponseType.getGetExpressCheckoutDetailsResponseDetails().getPaymentInfo()
        );
        log.info(
            "Billing Address : {}",
            getExpressCheckoutDetailsResponseType.getGetExpressCheckoutDetailsResponseDetails().getBillingAddress()
        );
        log.info(
            "Checkout Status : {}",
            getExpressCheckoutDetailsResponseType.getGetExpressCheckoutDetailsResponseDetails().getCheckoutStatus()
        );

        return getExpressCheckoutDetailsResponseType.getGetExpressCheckoutDetailsResponseDetails();
    }

    public void doExpressResponse(GetExpressCheckoutDetailsResponseDetailsType response)
        throws PayPalException, SAXException, ParserConfigurationException, SSLConfigurationException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, IOException, InterruptedException, InvalidCredentialException {
        Map<String, String> configurationMap = Configuration.getAcctAndConfig();

        PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configurationMap);

        DoExpressCheckoutPaymentRequestType doExpressCheckoutPaymentRequestType = new DoExpressCheckoutPaymentRequestType();

        doExpressCheckoutPaymentRequestType.setVersion("63.0");

        DoExpressCheckoutPaymentRequestDetailsType paymentDetailsRequestType = new DoExpressCheckoutPaymentRequestDetailsType();

        paymentDetailsRequestType.setPaymentDetails(response.getPaymentDetails());

        paymentDetailsRequestType.setToken(response.getToken());

        paymentDetailsRequestType.setPayerID(response.getPayerInfo().getPayerID());

        paymentDetailsRequestType.setPaymentAction(PaymentActionCodeType.SALE);

        doExpressCheckoutPaymentRequestType.setDoExpressCheckoutPaymentRequestDetails(paymentDetailsRequestType);

        DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq = new DoExpressCheckoutPaymentReq();

        doExpressCheckoutPaymentReq.setDoExpressCheckoutPaymentRequest(doExpressCheckoutPaymentRequestType);

        DoExpressCheckoutPaymentResponseType doExpressCheckoutPaymentResponseType = service.doExpressCheckoutPayment(
            doExpressCheckoutPaymentReq
        );

        this.doExpressResponse = doExpressCheckoutPaymentResponseType.getAck();
        log.info("DoExpressCheckoutPayment : {}", doExpressCheckoutPaymentResponseType.getAck());
    }
}
