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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Operations for checkout orders", description = "Necessary checkout operations used by the main service")
public class CheckoutController {

	@Autowired
	private OrderService orderService;

	@GetMapping("/bill/{orderId}")
	@ApiOperation(value = "Calculate the total value of the invoice", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Calculate the successful total"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
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
	@ApiOperation(value = "Creates the order", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully order created"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
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
