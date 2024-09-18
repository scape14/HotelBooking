package com.booking.hotel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.hotel.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

}
