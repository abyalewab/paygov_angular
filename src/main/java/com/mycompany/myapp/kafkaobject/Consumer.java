package com.mycompany.myapp.kafkaobject;

import com.mycompany.myapp.domain.Pay;
import com.mycompany.myapp.web.rest.Kafka;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    Kafka kafka;

    private final Logger log = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "user-create", groupId = "user")
    public void receive(ConsumerRecord<String, LinkedHashMap<String, Object>> obj)
        throws IOException, ExecutionException, InterruptedException {
        log.info("Received / consumed object is : {}", obj);

        Pay pay = new Pay();

        pay.setCik(obj.value().get("cik").toString());
        pay.setCcc(obj.value().get("ccc").toString());
        pay.setPaymentAmount((Double) obj.value().get("paymentAmount"));
        pay.setName((obj.value().get("name").toString()));
        pay.setEmail((obj.value().get("email").toString()));
        pay.setPhone(obj.value().get("phone").toString());

        kafka.getMessage(pay);
        kafka.kafkaAdminMessage();
        kafka.paymentApproval(pay);
    }
}
