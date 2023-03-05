package com.customerService.intsv.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    private String senderEmail;
    private String recipientEmail;
    private String subject;
    private String body;
    private List<Attachment> attachments;
}
