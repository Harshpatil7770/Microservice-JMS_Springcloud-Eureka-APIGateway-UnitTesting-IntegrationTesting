package com.xoriant.delivery.resource;

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

import com.xoriant.delivery.model.Brand;
import com.xoriant.delivery.service.BrandService;

@RequestMapping("/api/brands")
@RestController
public class BrandResource {

	@Autowired
	private BrandService brandService;

	@Autowired
	JmsTemplate jmsTemplate;

	@PostMapping("/save")
	public String addNewBrand(@RequestBody Brand brand) {
		brandService.addNewBrand(brand);
		String resposne = "New Brand Added :: " + brand.getBrandId() + " " + brand.getBrandName();
		jmsTemplate.send("brandQ", new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage(resposne);
				return objectMessage;
			}
		});
		return resposne;
	}

}
