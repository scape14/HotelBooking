package com.booking.hotel.services;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.hotel.model.BookingJournal;
import com.booking.hotel.model.Feature;
import com.booking.hotel.model.Room;
import com.booking.hotel.model.User;
import com.booking.hotel.repositories.BookingJournalRepository;
import com.booking.hotel.util.PriceCalculator;

@Service
public class JournalService {

	@Autowired
	private BookingJournalRepository bookingJournalRepository;

	public Room bookRoom(Room room, User user, Feature[] features, int year, int month, int dayOfMonth) {
		LocalDate dateFrom = LocalDate.now();
		LocalDate dateTo = LocalDate.of(year, month, dayOfMonth);

		List<Feature> featuresList = Arrays.asList(features);

		return bookRoom(user, room, dateFrom, dateTo, featuresList);
	}

	private Room bookRoom(User user, Room room, LocalDate dateFrom, LocalDate dateTo, List<Feature> features) {
		double price = PriceCalculator.getPrice(room, features);
		BookingJournal journalEntry = new BookingJournal(user, room, dateFrom, dateTo, price);
		return bookingJournalRepository.save(journalEntry).getRoom_id();
	}

	public List<BookingJournal> findallBooking() {
		return bookingJournalRepository.findAll();
	}

	public List<BookingJournal> findBookingUser(User user) {
		return bookingJournalRepository.findByUser(user);
	}
}
