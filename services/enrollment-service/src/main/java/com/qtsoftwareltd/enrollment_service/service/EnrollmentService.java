package com.qtsoftwareltd.enrollment_service.service;

import com.qtsoftwareltd.enrollment_service.kafka.EnrollmentProducer;
import com.qtsoftwareltd.enrollment_service.model.Enrollment;
import com.qtsoftwareltd.enrollment_service.record.EnrollmentPacketEvent;
import com.qtsoftwareltd.enrollment_service.record.EnrollmentRequest;
import com.qtsoftwareltd.enrollment_service.repository.EnrollmentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentProducer enrollmentProducer;

    public Integer packetSentToKafka(@Valid EnrollmentRequest enrollmentRequest) {
        Enrollment enrollment = new Enrollment();
        enrollment.setPacketName(enrollmentRequest.packetName());
        enrollment.setPacketType(enrollmentRequest.packetType());

        var savedEnrollment = this.enrollmentRepository.save(enrollment);

        enrollmentProducer.sendMessageToKafka(
                new EnrollmentPacketEvent(
                        UUID.randomUUID().toString(),
                        enrollmentRequest.packetName()
                   )
                );

      return savedEnrollment.getId();
    }
}
