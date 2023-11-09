package com.triveous.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.model.Category;
import com.triveous.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository cRepository;
	
	@Override
	public Category addCategory(Category category) {
		
		Category  savedCategory = cRepository.save(category);
		
		return savedCategory;
	}

	@Override
	public List<Category> getAllCategories() {
	
		List<Category> category=cRepository.findAll();
		
		return category;
	}

}
