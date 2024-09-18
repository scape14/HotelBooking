package com.booking.hotel.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.model.Category;
import com.booking.hotel.model.Room;
import com.booking.hotel.repositories.CategoryRepository;
import com.booking.hotel.repositories.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}

	public String findByCategoryName(String name) {
		Category category = categoryRepository.getCategoryByCategoryName(name);
		List<Room> rooms = filterByCategory(category);

		StringBuilder sb = new StringBuilder();
		for (Room room : rooms) {
			sb.append(room).append("</br>");
		}
		return sb.toString();
	}

	public String getAvailableRooms() {
		StringBuilder stringBuilder = new StringBuilder();
		for (Room room : availableRooms()) {
			stringBuilder.append(room).append("</br>");
		}
		return stringBuilder.toString();
	}

	public List<Room> filterByCategory(Category category) {
		List<Room> result = new ArrayList<>();
		for (Room room : roomRepository.findAll()) {
			if (room.getCategory().equals(category)) {
				result.add(room);
			}
		}
		return result;
	}

	public List<Room> availableRooms() {
		List<Room> result = new ArrayList<>();
		for (Room room : roomRepository.findAll()) {
			if (room.getAvailable() == 1) {
				result.add(room);
			}
		}
		return result;
	}
}
