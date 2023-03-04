package com.customerService.intsv.service.impl;

import com.customerService.intsv.entity.Attachment;
import com.customerService.intsv.entity.EmailRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Slf4j
@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(EmailRequest emailRequest) throws MessagingException {
        log.info("Preparing to send email to: {}", emailRequest.getRecipientEmail());

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(emailRequest.getSenderEmail());
        helper.setTo(emailRequest.getRecipientEmail());

        helper.setSubject(emailRequest.getSubject());
        helper.setText(emailRequest.getBody(), true);

        if (!CollectionUtils.isEmpty(emailRequest.getAttachments())) {
            for (Attachment attachment : emailRequest.getAttachments()) {
                helper.addAttachment(attachment.getName(), new ByteArrayResource(attachment.getData()), attachment.getMimeType());
            }
        }

        javaMailSender.send(mimeMessage);

        log.info("Email sent to email address: {}", emailRequest.getRecipientEmail());
    }
}





