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

import com.xoriant.ecart.model.Product;
import com.xoriant.ecart.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductResource {

	@Autowired
	private ProductService productService;

	@Autowired
	private JmsTemplate jmsTemplate;

	@PostMapping("/save")
	public String addNewProduct(@RequestBody Product product) {
		productService.addNewProduct(product);
		String response = "New Product Added " + product.getProductId() + " " + product.getProductName();
		jmsTemplate.send("productQ", new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage(response);
				return objectMessage;
			}
		});
		return response;
	}
}
