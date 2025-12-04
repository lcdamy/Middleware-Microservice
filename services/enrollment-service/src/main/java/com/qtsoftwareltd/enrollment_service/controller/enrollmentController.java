package com.qtsoftwareltd.enrollment_service.controller;

import com.qtsoftwareltd.enrollment_service.record.EnrollmentRequest;
import com.qtsoftwareltd.enrollment_service.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/enrollment")
@RestController
public class enrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<Integer> produceToKafka(@RequestBody @Valid EnrollmentRequest enrollmentRequest){
        return ResponseEntity.ok(enrollmentService.packetSentToKafka(enrollmentRequest));
    }
}
