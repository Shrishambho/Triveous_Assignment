package com.triveous.service;

import java.util.List;

import com.triveous.model.Category;

public interface CategoryService {

	public Category addCategory(Category category);

	public List<Category> getAllCategories();
}
