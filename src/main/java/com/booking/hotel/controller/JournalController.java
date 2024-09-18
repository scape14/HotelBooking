package com.booking.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.booking.hotel.model.BookingJournal;
import com.booking.hotel.model.User;
import com.booking.hotel.services.JournalService;

@RestController
public class JournalController {

    @Autowired
    private JournalService journalService;    

    @GetMapping("/booking")
    private List<BookingJournal> findallBooking() {
        return journalService.findallBooking();
    }

    @GetMapping("/findBookingUser/{userID}")
    private List<BookingJournal> findBookingUser(@PathVariable("userID") User user) {
        return journalService.findBookingUser(user);
    }
}