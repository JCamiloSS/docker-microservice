package com.hiberus.orders.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7163591923080524804L;
	
	
	private Long id;
	private Long clientId;
	private Date date;
	private String direction;
	private List<ProductDTO> products;

	public OrderDTO() {
	}



	public OrderDTO(Long clientId, Date date, String direction, List<ProductDTO> products) {
		super();
		this.clientId = clientId;
		this.date = date;
		this.direction = direction;
		this.products = products;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	@Override
	public String toString() {
		return "clientId:"+ clientId +" id: "+id;
	}


}
