package com.hiberus.orders.api.dto;

public class ResponseDTO {

	private Object body;
	private String message;
	private boolean error;

	public ResponseDTO() {
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

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
