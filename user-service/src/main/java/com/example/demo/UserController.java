package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService;
import com.example.UserVO;

@RestController
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("order") //end point
	void createUser(@Valid @RequestBody UserVO user) {
		service.saveUser(user);
		
		System.out.println(user.getName());
		System.out.println(user.getCity());
	}
	
	@GetMapping("getData")
	public List<UserVO> getData() {
		return service.getData();
	}
}
