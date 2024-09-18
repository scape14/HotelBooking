package com.booking.hotel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.hotel.model.BookingJournal;
import com.booking.hotel.model.User;

@Repository
public interface BookingJournalRepository extends CrudRepository<BookingJournal, Long> {

    List<BookingJournal> findByUser(User user);

    List<BookingJournal> findAll();
}