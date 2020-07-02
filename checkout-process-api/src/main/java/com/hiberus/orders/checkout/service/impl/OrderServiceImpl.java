package com.hiberus.orders.checkout.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiberus.orders.checkout.dto.BillingDTO;
import com.hiberus.orders.checkout.dto.OrderDTO;
import com.hiberus.orders.checkout.dto.ProductDTO;
import com.hiberus.orders.checkout.dto.ResponseDTO;
import com.hiberus.orders.checkout.model.OrderDetail;
import com.hiberus.orders.checkout.model.Orders;
import com.hiberus.orders.checkout.model.Product;
import com.hiberus.orders.checkout.repository.OrderRepository;
import com.hiberus.orders.checkout.service.OrderService;
import com.hiberus.orders.checkout.service.ProductService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductService productService;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public ResponseDTO createOrder(OrderDTO order) {

		Orders orderEntity = new Orders();
		orderEntity.setDate(order.getDate());
		orderEntity.setDirection(order.getDirection());
		orderEntity.setClientId(order.getClientId());
		List<OrderDetail> details = new ArrayList<>();
		for (ProductDTO productDTO : order.getProducts()) {

			Product product = productService.getProductById(productDTO.getId());
			if (product == null) {
				product = new Product();
				product.setId(productDTO.getId());
				product.setCost(productDTO.getCost());
				if (productDTO.getName() == null) {
					product.setName("Product " + productDTO.getId());
				}
				product = productService.save(product);
			}

			OrderDetail detail = new OrderDetail();
			detail.setProduct(product);
			detail.setOrder(orderEntity);
			detail.setQuantity(productDTO.getQuantity());

			details.add(detail);
		}
		orderEntity.setDetails(details);
		orderEntity = orderRepository.save(orderEntity);

		order.setId(orderEntity.getId());

		ResponseDTO response = new ResponseDTO();
		response.setBody(order);
		response.setMessage("Successfully created order");
		return response;
	}

	@Override
	public ResponseDTO getTotalBillValue(Long orderId) {
		ResponseDTO response = new ResponseDTO();
		Optional<Orders> result = orderRepository.findById(orderId);
		Orders order = result.isPresent() ? result.get() : null;

		if (order != null) {
			BillingDTO billingDTO = new BillingDTO();
			billingDTO.setClientId(order.getClientId());
			billingDTO.setOrderId(order.getId());
			billingDTO.setTotal(order.getDetails().stream()
					.mapToDouble(detail -> detail.getQuantity() * detail.getProduct().getCost()).sum());
			response.setBody(billingDTO);
			response.setMessage("order processed successfully");
		} else {
			response.setBody(null);
			response.setMessage("No records found");
		}
		return response;
	}

}
