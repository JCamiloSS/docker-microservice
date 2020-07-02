package com.hiberus.orders.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hiberus.orders.api.dto.OrderDTO;
import com.hiberus.orders.api.dto.ResponseDTO;
import com.hiberus.orders.api.service.OrderService;
import com.hiberus.orders.api.utils.Utilities;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Checkout orders", description = "Check the order and validate the total invoice")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/")
	@ApiOperation(value = "Orchestrate the checkout of the order", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully checkout order"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<ResponseDTO> sendOrder(@RequestBody OrderDTO order) {
		ResponseDTO response;
		ResponseDTO reponseCreateOrder = orderService.createOrder(order);
		if (!reponseCreateOrder.isError()) {
			OrderDTO orderResponse = Utilities.orderResponseToDto(reponseCreateOrder.getBody());
			response = orderService.getTotalBillValue(orderResponse.getId());
			return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseDTO>(reponseCreateOrder, HttpStatus.EXPECTATION_FAILED);
		}
	}
}