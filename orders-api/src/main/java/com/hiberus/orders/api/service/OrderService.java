package com.hiberus.orders.api.service;

import com.hiberus.orders.api.dto.OrderDTO;
import com.hiberus.orders.api.dto.ResponseDTO;

public interface OrderService {
	ResponseDTO createOrder(OrderDTO order);

	ResponseDTO getTotalBillValue(Long orderId);
}
