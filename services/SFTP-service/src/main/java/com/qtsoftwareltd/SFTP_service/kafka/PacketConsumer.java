package com.qtsoftwareltd.SFTP_service.kafka;

import com.qtsoftwareltd.SFTP_service.record.EnrollmentBody;
import com.qtsoftwareltd.SFTP_service.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class PacketConsumer {

    private final EnrollmentService enrollmentService;

    @KafkaListener(topics = "enrollment-packet", groupId = "enrollment-group")
    public void consumePacket(Map<String,Object> payload) throws MessagingException {
    log.info("Consuming the message from enrollment-packet:: {}", payload);
       String enrollmentReference = (String) payload.get("enrollmentReference");
       String enrollmentPacketName = (String) payload.get("enrollmentPacketName");
    EnrollmentBody body = new EnrollmentBody(enrollmentReference, enrollmentPacketName);
    enrollmentService.createEnrollmentFromKafka(body);
    }
}
