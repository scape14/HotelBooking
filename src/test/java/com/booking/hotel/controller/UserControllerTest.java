package com.booking.hotel.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.booking.hotel.model.User;
import com.booking.hotel.services.UserService;

@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserService userService;

	@Test
	public void testFindAllUsers() throws Exception {

		User user1 = new User();

		User user2 = new User();

		List<User> users = Arrays.asList(user1, user2);

		when(userService.findedallUser()).thenReturn(users);

		mockMvc.perform(get("/find/all/User"));
	}

	@Test
	public void testRegisterUser() throws Exception {
	    User newUser = new User();
	    when(userService.addUser(newUser)).thenReturn(newUser);

	    mockMvc.perform(post("/register"));
	}

	@Test
	public void testAddUsers() throws Exception {
		when(userService.addUsers()).thenReturn("Users added successfully");

		mockMvc.perform(post("/saveUser"));
	}
}
