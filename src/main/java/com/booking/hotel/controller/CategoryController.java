package com.booking.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.hotel.model.Category;
import com.booking.hotel.services.CategoryService;

@RestController
@RequestMapping("/findallCategory")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	private List<Category> findCategory() {
		return categoryService.getAllCategories();
	}
}
