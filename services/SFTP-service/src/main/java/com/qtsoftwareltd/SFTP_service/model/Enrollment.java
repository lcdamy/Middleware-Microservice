package com.qtsoftwareltd.SFTP_service.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Validated
@Document
public class Enrollment {
    @Id
    private String id;
    private String enrollmentReference;
    private String enrollmentPacketName;
}
