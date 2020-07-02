package com.hiberus.orders.checkout.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hiberus.orders.checkout.model.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long>{

}
