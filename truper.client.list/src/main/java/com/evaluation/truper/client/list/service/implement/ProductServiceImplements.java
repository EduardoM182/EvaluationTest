package com.evaluation.truper.client.list.service.implement;

import org.springframework.beans.factory.annotation.Autowired;

import com.evaluation.truper.client.list.dto.Product;
import com.evaluation.truper.client.list.repository.ProductRepository;
import com.evaluation.truper.client.list.service.ProductService;

public class ProductServiceImplements implements ProductService{
	
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public void saveProduct(Product product) {
		productRepo.save(product);
	}

}
