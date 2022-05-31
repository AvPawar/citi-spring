package com.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	@Autowired
	OrderService service;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping("order") //end point
	void createOrder(@Valid @RequestBody OrderVO order) {
		service.saveOrder(order);
		restTemplate.getForEntity("http://EmailService/email", String.class);
		System.out.println(order.getItem());
		System.out.println(order.getQuantity());
	}
	
	@GetMapping("getData")
	public List<OrderVO> getData() {
		return service.getData();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String>handleException(MethodArgumentNotValidException exct){
		Map<String, String> errorMessages = new HashMap<>();
		exct.getAllErrors().forEach(error -> {
			String field = ((FieldError) error).getField();
			String message = ((FieldError) error).getDefaultMessage();
			errorMessages.put(field, message);
		});
		
		return errorMessages;
	}
}
