package com.ensa.otp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/otp")
public class EmailSenderController {
    @GetMapping
    public void sendOTP(){
        System.out.println("OTP");;
    }
}
