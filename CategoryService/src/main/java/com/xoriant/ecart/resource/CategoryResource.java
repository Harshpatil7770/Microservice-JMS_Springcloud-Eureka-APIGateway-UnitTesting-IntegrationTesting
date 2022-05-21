package com.xoriant.ecart.resource;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.dto.Brand;
import com.xoriant.ecart.dto.Product;
import com.xoriant.ecart.model.Category;
import com.xoriant.ecart.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryResource {

	@Autowired
	CategoryService categoryService;

	@Autowired
	JmsTemplate jmsTemplate;

	@PostMapping("/save")
	public String addNewCategory(@RequestBody Category category) {
		categoryService.addNewCategory(category);
		String response = "New Category Added :: " + category.getCategoryId() + " " + category.getCategoryName();
		jmsTemplate.send("categoryQ", new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage(response);
				return objectMessage;
			}
		});
		return response;
	}

	@PostMapping("/save-brand")
	public String addNewBrand(@RequestBody Brand brand) {
		return categoryService.addNewBrand(brand);
	}

	@PostMapping("/save-product")
	public String addNewProduct(@RequestBody Product product) {
		return categoryService.addNewProduct(product);
	}
}
