package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@GetMapping("email")
	String sendEmail() {
		System.out.println("Email Sent");
		return "ok";
	}
}
