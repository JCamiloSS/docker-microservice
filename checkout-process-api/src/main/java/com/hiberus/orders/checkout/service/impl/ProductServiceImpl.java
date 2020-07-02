package com.hiberus.orders.checkout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.orders.checkout.model.Product;
import com.hiberus.orders.checkout.repository.ProductRepository;
import com.hiberus.orders.checkout.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;


	@Override
	public Product getProductById(Long id) {
		try {
			return productRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

}
