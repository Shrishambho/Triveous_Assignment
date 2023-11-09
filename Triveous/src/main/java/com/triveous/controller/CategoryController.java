package com.triveous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.model.Category;
import com.triveous.service.CategoryService;

import jakarta.validation.Valid;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categorySerice;
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody @Valid Category category){
		
		Category savedCategory=categorySerice.addCategory(category);
		
		return new ResponseEntity<>(savedCategory,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/category")
	public ResponseEntity<List<Category>> getAllCategorie(){
		
		List<Category> cList=categorySerice.getAllCategories();
		
		return new ResponseEntity<>(cList,HttpStatus.ACCEPTED);
	}
}
