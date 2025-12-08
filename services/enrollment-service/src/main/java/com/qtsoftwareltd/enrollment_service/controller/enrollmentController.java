package com.qtsoftwareltd.enrollment_service.controller;

import com.qtsoftwareltd.enrollment_service.record.EnrollmentRequest;
import com.qtsoftwareltd.enrollment_service.service.EnrollmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Enrollment",
        description = "Operations for enrollment and sending packets to Kafka / ABIS"
)
public class enrollmentController {
    private final EnrollmentService enrollmentService;

    @PostMapping
    @Operation(
            summary = "Create enrollment and send packet to Kafka",
            description = "Accepts an enrollment request, validates it, and sends a packet to Kafka."
    )
    public ResponseEntity<Integer> produceToKafka(@RequestBody @Valid EnrollmentRequest enrollmentRequest){
        return ResponseEntity.ok(enrollmentService.packetSentToKafka(enrollmentRequest));
    }
}
