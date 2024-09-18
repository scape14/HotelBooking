package com.booking.hotel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.hotel.model.Category;
import com.booking.hotel.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}