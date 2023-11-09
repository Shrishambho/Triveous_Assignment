package com.triveous.service;

import java.util.List;

import com.triveous.exception.CategoryException;
import com.triveous.exception.ProductException;
import com.triveous.model.Product;
import com.triveous.model.ProductDTO;

public interface ProductService {

	public Product addProduct(Product product,Integer categoryId)throws CategoryException;

	public List<ProductDTO> getProductsByCategoryId(Integer categoryId)throws CategoryException;

	public Product getProductById(Integer productId)throws ProductException ;
}
