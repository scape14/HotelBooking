package com.booking.hotel.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.booking.hotel.model.Feature;
import com.booking.hotel.model.Room;
import com.booking.hotel.model.User;
import com.booking.hotel.services.JournalService;
import com.booking.hotel.services.RoomService;

public class RoomControllerTest {

	private MockMvc mockMvc;

	@Mock
	private RoomService roomService;

	@Mock
	private JournalService journalService;

	@InjectMocks
	private RoomController roomController;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(roomController).build();
	}

	@Test
	void testFindAllRoom() throws Exception {
		List<Room> rooms = Arrays.asList(new Room(), new Room());
		when(roomService.getAllRooms()).thenReturn(rooms);

		mockMvc.perform(get("/findAllRooms")).andExpect(status().isOk());

		verify(roomService, times(1)).getAllRooms();
	}

	@Test
	void testFindByCategoryName() throws Exception {
		String categoryName = "Luxury";
		when(roomService.findByCategoryName(categoryName)).thenReturn("Room details");

		mockMvc.perform(get("/find/category/{name}", categoryName));

		verify(roomService, times(1)).findByCategoryName(categoryName);
	}

	@Test
	void testGetAvailableRooms() throws Exception {
		when(roomService.getAvailableRooms()).thenReturn("Available rooms");

		mockMvc.perform(get("/room/available"));

		verify(roomService, times(1)).getAvailableRooms();
	}

	void testBookRoom() throws Exception {
	    Room room = new Room();
	    room.setId(1L);

	    User user = new User();
	    user.setId(1L);

	    Feature feature = new Feature();
	    feature.setId(1L);
	    Feature[] features = new Feature[] { feature };

	    int year = 2022;
	    int month = 6;
	    int dayOfMonth = 20;

	    when(journalService.bookRoom(room, user, features, year, month, dayOfMonth))
	        .thenReturn(room);

	    mockMvc.perform(post("/room/book")
	            .param("roomId", "1")
	            .param("userId", "1")
	            .param("featureId", "1")
	            .param("year", "2022")
	            .param("month", "06")
	            .param("dayOfMonth", "20"));

	    verify(journalService, times(1)).bookRoom(room, user, features, year, month, dayOfMonth);
	}
	
}
