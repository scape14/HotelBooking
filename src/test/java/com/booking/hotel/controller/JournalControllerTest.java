package com.booking.hotel.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.booking.hotel.model.BookingJournal;
import com.booking.hotel.services.JournalService;

@WebMvcTest(JournalController.class)
public class JournalControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private JournalService journalService;

	@InjectMocks
	private JournalController journalController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(journalController).build();
	}

	@Test
	public void testFindAllBooking() throws Exception {
		List<BookingJournal> bookings = Arrays.asList(new BookingJournal(), new BookingJournal());
		when(journalService.findallBooking()).thenReturn(bookings);

		mockMvc.perform(get("/booking")).andExpect(status().isOk());

		verify(journalService, times(1)).findallBooking();
	}

}
