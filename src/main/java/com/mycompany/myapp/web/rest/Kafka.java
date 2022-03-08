package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.asynctest.AsyncService;
import com.mycompany.myapp.asynctest.CccValidator;
import com.mycompany.myapp.asynctest.CikValidator;
import com.mycompany.myapp.domain.Pay;
import com.mycompany.myapp.kafkaobject.Producer;
import com.mycompany.myapp.kafkaobject.Storage;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Transactional(timeout = 60)
public class Kafka {

    private final Logger logger = LoggerFactory.getLogger(Kafka.class);

    @Autowired
    Producer producer;

    @Autowired
    private Storage messageStorage;

    @Autowired
    private KieSession session;

    @Autowired
    private AsyncService service;

    Pay payment;

    @PostMapping("/kafka")
    public void sendMessage(@RequestBody Object pay) {
        producer.publishToTopic(pay);
    }

    public void getMessage(@RequestBody Pay pay) {
        this.payment = pay;
    }

    @GetMapping("/kafkadmin")
    public List<Pay> kafkaAdminMessage() {
        logger.info("Kafka-Admin : getting all message");
        return messageStorage.getAll();
    }

    @PostMapping("/kafkaPaymentApproval")
    public Pay paymentApproval(@RequestBody Pay pay) throws InterruptedException, ExecutionException, IOException {
        logger.info("Kafka : Payment Approval Started ");

        CompletableFuture<CccValidator> cccValidator = service.getValidCcc();
        CompletableFuture<CikValidator> cikValidator = service.getValidCik();

        logger.info("CccValidator : {}", cccValidator.get());
        logger.info("CikValidator : {}", cikValidator.get());

        CompletableFuture.allOf(cccValidator, cikValidator).join();

        logger.info("CustomerDataController");
        logger.info("CccValidator : {}", cccValidator.get());
        logger.info("CikValidator : {}", cikValidator.get());

        session.insert(pay);
        session.insert(cccValidator.get());
        session.insert(cikValidator.get());
        session.fireAllRules();

        messageStorage.add(pay);
        logger.info("LIST OF PAYMENT STORED : {}", messageStorage.getAll());

        return pay;
    }
}
