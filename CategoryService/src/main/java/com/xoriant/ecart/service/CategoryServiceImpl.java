package com.xoriant.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xoriant.ecart.dao.CategoryDao;
import com.xoriant.ecart.dto.Brand;
import com.xoriant.ecart.dto.Product;
import com.xoriant.ecart.globalexceptionhandeler.InputUserException;
import com.xoriant.ecart.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private BrandServiceProxy brandServiceProxy;
	
	@Autowired
	private ProductServiceProxy productServiceProxy;

	@Override
	public Category addNewCategory(Category category) {
		if (category.getCategoryName().isEmpty() || category.getCategoryName().isBlank()
				|| category.getCategoryName().length() == 0) {
			throw new InputUserException();
		}
		return categoryDao.save(category);
	}

	@Override
	public String addNewBrand(Brand brand) {

		return brandServiceProxy.addNewBrand(brand);
	}

	@Override
	public String addNewProduct(Product product) {
		return productServiceProxy.addNewProduct(product);
	}

}
