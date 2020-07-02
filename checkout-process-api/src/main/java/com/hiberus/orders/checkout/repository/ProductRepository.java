package com.hiberus.orders.checkout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.orders.checkout.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

}
