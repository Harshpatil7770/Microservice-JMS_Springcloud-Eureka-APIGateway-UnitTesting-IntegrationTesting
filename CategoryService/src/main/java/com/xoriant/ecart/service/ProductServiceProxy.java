package com.xoriant.ecart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.ecart.dto.Product;

@FeignClient(name = "product-service")
public interface ProductServiceProxy {

	@PostMapping("/api/product/save")
	public String addNewProduct(@RequestBody Product product);
}
