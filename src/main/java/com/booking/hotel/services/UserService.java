package com.booking.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.model.User;
import com.booking.hotel.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	
	public List<User> findedallUser() {
		return userRepository.findAll();
	}

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public String addUsers() {
		userRepository.save(new User("firstname", "secondname", "+7140049000", "joao@gmail.com"));
		return "User is added!";
	}
}