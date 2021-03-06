package com.xoriant.delivery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.delivery.dao.BrandDao;
import com.xoriant.delivery.model.Brand;
import com.xoriant.ecart.globalexceptionhandeler.InputUserException;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public Brand addNewBrand(Brand brand) {
		if (brand.getBrandName().length() == 0 || brand.getBrandName().isBlank() || brand.getBrandName().isEmpty()) {
			throw new InputUserException();
		}
		return brandDao.save(brand);
	}

}
