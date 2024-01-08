package com.ensa.agent.otp;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="otp-service", url = "${application.config.otp-url}")
public interface OtpClient {
    @GetMapping
    public String sendOTP();

}
