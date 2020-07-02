package com.hiberus.orders.checkout.service;

import com.hiberus.orders.checkout.dto.OrderDTO;
import com.hiberus.orders.checkout.dto.ResponseDTO;

public interface OrderService {

	public ResponseDTO createOrder(OrderDTO order);

	public ResponseDTO getTotalBillValue(Long orderId);
}
