package com.qtsoftwareltd.SFTP_service.controller;

import com.qtsoftwareltd.SFTP_service.record.EnrollmentResponse;
import com.qtsoftwareltd.SFTP_service.service.EnrollmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sftp")
@Tag(
        name = "Sftp server",
        description = "List packets data sent from Enrollment"
)
public class enrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping
    public ResponseEntity<List<EnrollmentResponse>> findAllEnrollment(){
        return ResponseEntity.ok(enrollmentService.findAllEnrollments());
    }

}
