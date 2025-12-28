package com.github.aayushjoshi2709.internalworkingofspringbootapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InternalworkingofspringbootapplicationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InternalworkingofspringbootapplicationApplication.class, args);
	}

	// @Autowired
	private final PaymentService paymentService;

	public InternalworkingofspringbootapplicationApplication(
			PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@Override
	public void run(String... args) {
		String payment = paymentService.pay();
		System.out.println("payment done: " + payment);
	}

}
