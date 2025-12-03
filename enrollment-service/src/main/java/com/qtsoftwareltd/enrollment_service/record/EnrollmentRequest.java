package com.qtsoftwareltd.enrollment_service.record;

import jakarta.validation.constraints.NotNull;

public record EnrollmentRequest(
        @NotNull(message = "Packet name can't be empty")
        String packetName,
        @NotNull(message = "Packet type can't be empty")
        String packetType
) {
}
