package com.qtsoftwareltd.enrollment_service.kafka;

import com.qtsoftwareltd.enrollment_service.record.EnrollmentPacketEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnrollmentProducer {

    private final KafkaTemplate<String, EnrollmentPacketEvent> kafkaTemplate;

    public void sendMessageToKafka(EnrollmentPacketEvent enrollmentPacketEvent){
        log.info("Start of sending to Kafka");
        kafkaTemplate.send("enrollment-packet",enrollmentPacketEvent);
        log.info("End of sending to Kafka");
    }
}
