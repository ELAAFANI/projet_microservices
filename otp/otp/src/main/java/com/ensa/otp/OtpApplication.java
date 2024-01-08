package com.ensa.otp;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class OtpApplication {

//	private final EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(OtpApplication.class, args);
	}
		@EventListener(ApplicationReadyEvent.class)
	public void sendMail(){
//			emailSenderService.sendEmail(
//					"elyahanaa@gmail.com",
//					"OTP",
//					"Your OTP sent from agent app : $87&45e"
//			);
	}
}
