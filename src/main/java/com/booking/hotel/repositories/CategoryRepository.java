package com.booking.hotel.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.booking.hotel.model.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category getCategoryByCategoryName(String name);

    List<Category> findAll();
}