package com.xoriant.ecart.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xoriant.ecart.dto.Brand;

@FeignClient(name = "brand-service")
public interface BrandServiceProxy {

	@PostMapping("/api/brands/save")
	public String addNewBrand(@RequestBody Brand brand);
}
