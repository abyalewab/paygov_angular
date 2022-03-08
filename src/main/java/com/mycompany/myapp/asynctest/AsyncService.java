package com.mycompany.myapp.asynctest;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    private final Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Value("${spring.application.cccValidatorAPI}")
    String cccValidatorAPI;

    @Value("${spring.application.cikValidatorAPI}")
    String cikValidatorAPI;

    @Lazy
    @Async("taskExecutor")
    public CompletableFuture<CccValidator> getValidCcc() throws InterruptedException, IOException {
        logger.info("GetValidCcc Starts");

        ObjectMapper object = new ObjectMapper();

        URL url = new URL(this.cccValidatorAPI);

        CccValidator cccValidator = object.readValue(url, CccValidator.class);

        Thread.sleep(1000L);

        logger.info("CccValidator Service Output : {}", cccValidator);

        Thread.sleep(1000L);

        logger.info("CccValidator Completed !");

        return CompletableFuture.completedFuture(cccValidator);
    }

    @Lazy
    @Async("taskExecutor")
    public CompletableFuture<CikValidator> getValidCik() throws InterruptedException, IOException {
        logger.info("GetValidCik Starts");

        ObjectMapper object = new ObjectMapper();

        URL url = new URL(this.cikValidatorAPI);

        Thread.sleep(1000L);

        CikValidator cikValidator = object.readValue(url, CikValidator.class);

        logger.info("CikValidator Service Output : {}", cikValidator);

        Thread.sleep(1000L);

        logger.info("CikValidator Completed !");

        return CompletableFuture.completedFuture(cikValidator);
    }
}
