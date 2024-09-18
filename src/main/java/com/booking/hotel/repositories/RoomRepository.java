package com.booking.hotel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.hotel.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAll();
}
