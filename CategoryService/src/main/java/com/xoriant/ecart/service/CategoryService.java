package com.xoriant.ecart.service;

import com.xoriant.ecart.dto.Brand;
import com.xoriant.ecart.dto.Product;
import com.xoriant.ecart.model.Category;

public interface CategoryService {

	Category addNewCategory(Category category);

	String addNewBrand(Brand brand);

	String addNewProduct(Product product);
}
