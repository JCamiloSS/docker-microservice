package com.hiberus.orders.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.orders.checkout.dto.OrderDTO;
import com.hiberus.orders.checkout.dto.ResponseDTO;
import com.hiberus.orders.checkout.service.OrderService;

@RestController
public class CheckoutController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/bill/{orderId}")
	public ResponseEntity<ResponseDTO> bill(@PathVariable("orderId") Long orderId) {
		try {
			ResponseDTO response = orderService.getTotalBillValue(orderId);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseDTO>(new ResponseDTO("An error occurred calculating the total"),
					HttpStatus.EXPECTATION_FAILED);
		}

	}

	@PostMapping("/logistic")
	public ResponseEntity<ResponseDTO> logistic(@RequestBody OrderDTO order) {
		try {
			ResponseDTO response = orderService.createOrder(order);
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResponseDTO>(new ResponseDTO("An error occurred creating the order"),
					HttpStatus.EXPECTATION_FAILED);
		}

	}

}
