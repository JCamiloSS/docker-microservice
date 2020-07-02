package com.hiberus.orders.api.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hiberus.orders.api.dto.OrderDTO;
import com.hiberus.orders.api.dto.ResponseDTO;
import com.hiberus.orders.api.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Override
	public ResponseDTO createOrder(OrderDTO order) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResponseDTO> response = restTemplate.postForEntity("http://checkout-process-api:8080/logistic", order, ResponseDTO.class);
		if(response.getStatusCode().equals(HttpStatus.OK)) {
			return response.getBody();
		}
		return new ResponseDTO("Error creating the order");
	}

	@Override
	public ResponseDTO getTotalBillValue(Long orderId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ResponseDTO> response = restTemplate.getForEntity("http://checkout-process-api:8080/bill/"+orderId, ResponseDTO.class);
		if(response.getStatusCode().equals(HttpStatus.OK)) {
			return response.getBody();
		}
		return new ResponseDTO("Error calculating the order total");
	}

	
}
