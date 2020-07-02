package com.hiberus.orders.checkout.dto;

public class ResponseDTO {

	private Object body;
	private String message;

	public ResponseDTO() {
		// TODO Auto-generated constructor stub
	}

	public ResponseDTO(String message) {
		super();
		this.message = message;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
