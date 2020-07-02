package com.hiberus.orders.api.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hiberus.orders.api.dto.OrderDTO;

public class Utilities {
	
	public static OrderDTO orderResponseToDto(Object object) {
		ObjectMapper objectMapper = new ObjectMapper();
	     
		OrderDTO copy=null;
		try {
			copy = objectMapper
			  .readValue(objectMapper.writeValueAsString(object), OrderDTO.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return copy;
	}

}
