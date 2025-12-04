package com.qtsoftwareltd.SFTP_service.repository;

import com.qtsoftwareltd.SFTP_service.model.Enrollment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnrollmentRepository extends MongoRepository<Enrollment, String> {
}
