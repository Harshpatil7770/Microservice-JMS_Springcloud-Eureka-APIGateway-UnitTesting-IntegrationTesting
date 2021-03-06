package com.example.demo.listner;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListener {

	@JmsListener(destination = "categoryQ")
	public void categoryInfo(String response) {
		System.out.println("============================================");
		System.out.println(response);
		System.out.println("============================================");
	}

	@JmsListener(destination = "brandQ")
	public void brandInfo(String response) {
		System.out.println("============================================");
		System.out.println(response);
		System.out.println("============================================");
	}

	@JmsListener(destination = "productQ")
	public void productInfo(String response) {
		System.out.println("============================================");
		System.out.println(response);
		System.out.println("============================================");
	}
}
