package com.ensa.otp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/otp")
@RequiredArgsConstructor
public class EmailSenderController {
    private final EmailSenderService emailSenderService;
    @PostMapping
    public void sendEmail(SendEmailRequest sendEmailRequest){
        emailSenderService.sendEmail(sendEmailRequest);
    }
}
