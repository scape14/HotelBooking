package com.booking.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.booking.hotel.model.Feature;
import com.booking.hotel.model.Room;
import com.booking.hotel.model.User;
import com.booking.hotel.services.JournalService;
import com.booking.hotel.services.RoomService;

@RestController
public class RoomController {

	@Autowired
	private RoomService roomService;

	@Autowired
	private JournalService journalService;

	@GetMapping("/findAllRooms")
	private List<Room> findAllRoom() {
		return roomService.getAllRooms();
	}

	@GetMapping("find/category/{name}")
	private String findByCategoryName(@PathVariable String name) {
		return roomService.findByCategoryName(name);
	}

	@GetMapping("room/available")
	private String getAvailableRooms() {
		return roomService.getAvailableRooms();
	}

	@PostMapping("/room/book")
	public Room bookRoom(@RequestParam("roomId") Room room, @RequestParam("userId") User user,
			@RequestParam("featureId") Feature[] features, @RequestParam("year") int year,
			@RequestParam("month") int month, @RequestParam("dayOfMonth") int dayOfMonth) {
		return journalService.bookRoom(room, user, features, year, month, dayOfMonth);
	}

}
