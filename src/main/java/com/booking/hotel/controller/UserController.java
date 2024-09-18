package com.booking.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.booking.hotel.model.User;
import com.booking.hotel.services.UserService;

@RestController
public class UserController {
	
	@Autowired
    private UserService userService;

    @GetMapping("/find/all/User")
    public List<User> findallUsers() {
        return userService.findedallUser();
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public User registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/saveUser")
    public String addUsers() {
        return userService.addUsers();
    }
}
