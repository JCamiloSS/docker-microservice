package com.hiberus.orders.api.dto;

public class ProductDTO {

	private Long id;
	private Integer quantity;
	private Double cost;
	private String name;

	public ProductDTO() {

	}

	public ProductDTO(Long id, Integer quantity, Double cost) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.cost = cost;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
