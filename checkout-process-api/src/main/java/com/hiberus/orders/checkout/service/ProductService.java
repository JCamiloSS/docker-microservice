package com.hiberus.orders.checkout.service;

import com.hiberus.orders.checkout.model.Product;

public interface ProductService {

	public Product getProductById(Long id);

	public Product save(Product product);
}
