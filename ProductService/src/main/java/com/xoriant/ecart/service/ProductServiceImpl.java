package com.xoriant.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.ProductDao;
import com.xoriant.ecart.globalexceptionhandeler.InputUserException;
import com.xoriant.ecart.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public Product addNewProduct(Product product) {
		if (product.getProductName().isEmpty() || product.getProductName().isBlank()
				|| product.getProductName().length() == 0) {
			throw new InputUserException();
		}

		if (product.getDescription().isEmpty() || product.getDescription().isBlank()
				|| product.getDescription().length() == 0) {
			throw new InputUserException();
		}

		if (product.getPrice() < 0) {
			throw new InputUserException();
		}
		return productDao.save(product);
	}

}
