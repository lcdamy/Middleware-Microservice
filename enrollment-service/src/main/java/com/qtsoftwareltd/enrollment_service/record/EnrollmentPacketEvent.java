package com.qtsoftwareltd.enrollment_service.record;

public record EnrollmentPacketEvent(
        String enrollmentReference,
        String enrollmentPacketName
) {
}
