package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public void saveUser(UserVO order) {
		userRepository.save(order);
	}
	
	public List<UserVO> getData() {
		return userRepository.findAll();
	}
}
