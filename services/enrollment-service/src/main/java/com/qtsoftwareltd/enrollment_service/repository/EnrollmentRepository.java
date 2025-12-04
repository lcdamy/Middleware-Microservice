package com.qtsoftwareltd.enrollment_service.repository;

import com.qtsoftwareltd.enrollment_service.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
}
