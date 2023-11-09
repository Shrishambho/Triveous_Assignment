package com.triveous.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triveous.model.Product;
import com.triveous.model.ProductDTO;
import com.triveous.service.ProductService;

import jakarta.validation.Valid;

@RestController
public class ProductController {

	@Autowired
	private ProductService pService;
	
	@PostMapping("/product/{categoryId}")
	public ResponseEntity<Product> addProduct(@RequestBody @Valid Product product,@PathVariable Integer categoryId){
		
		Product savedProduct=pService.addProduct(product, categoryId);
		
		return new ResponseEntity<>(savedProduct,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductDTO>> getProductsByCategoryId(@RequestParam Integer categoryId){
		
		List<ProductDTO> pList=pService.getProductsByCategoryId(categoryId);
		
		return new ResponseEntity<>(pList,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/productById")
	public ResponseEntity<Product> getProductById(@RequestParam Integer productId){
		
		Product product=pService.getProductById(productId);
		
		return new ResponseEntity<>(product,HttpStatus.ACCEPTED);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
