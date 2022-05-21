package com.xoriant.ecart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/categoryFallback")
	public Mono<String> categoryServiceFallback() {
		return Mono.just(
				"Neither Category Service is taking too long to respond or it might get down." + " Please Try Again");
	}

	@RequestMapping("/brandFallback")
	public Mono<String> brandServiceFallback() {
		return Mono.just("Neither Brand Service taking too long to respond or it might get down " + "Please try again");
	}

	@RequestMapping("/productFallback")
	public Mono<String> productServiceFallback() {
		return Mono
				.just("Neither Product service taking too long to respond or it might get down" + "Please try again");
	}
}
