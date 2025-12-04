package com.qtsoftwareltd.SFTP_service.service;

import com.qtsoftwareltd.SFTP_service.model.Enrollment;
import com.qtsoftwareltd.SFTP_service.record.EnrollmentBody;
import com.qtsoftwareltd.SFTP_service.record.EnrollmentResponse;
import com.qtsoftwareltd.SFTP_service.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public String createEnrollmentFromKafka(EnrollmentBody enrollmentBody){
        Enrollment enrollment = new Enrollment();
        enrollment.setEnrollmentReference(enrollmentBody.enrollmentReference());
        enrollment.setEnrollmentPacketName(enrollmentBody.enrollmentPacketName());
        var enrollmentSaved = enrollmentRepository.save(enrollment);
        return enrollmentSaved.getId();
    }

    public List<EnrollmentResponse> findAllEnrollments() {
        return enrollmentRepository.findAll()
                .stream()
                .map(enrollment -> new EnrollmentResponse(
                        enrollment.getId(),
                        enrollment.getEnrollmentReference(),
                        enrollment.getEnrollmentPacketName()
                ))
                .collect(Collectors.toList());
    }
}
