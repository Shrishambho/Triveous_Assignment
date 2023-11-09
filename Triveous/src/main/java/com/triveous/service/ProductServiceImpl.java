package com.triveous.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triveous.exception.CategoryException;
import com.triveous.exception.ProductException;
import com.triveous.model.Category;
import com.triveous.model.Product;
import com.triveous.model.ProductDTO;
import com.triveous.repository.CategoryRepository;
import com.triveous.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private CategoryRepository cRepository;

	@Autowired
	private ProductRepository pRepository;
	
	@Override
	public Product addProduct(Product product,Integer categoryId) throws CategoryException {
		
		Optional<Category> opt=cRepository.findById(categoryId);
		
		if(opt.isEmpty()) {
			throw new CategoryException("No category present with given id.");
		}
		else {
			Category category=opt.get();
			
			category.getProducts().add(product);
			
			product.setCategory(category);
			
			Product savedProduct=pRepository.save(product);
			
			return savedProduct;
			
		}
		
	}

	@Override
	public List<ProductDTO> getProductsByCategoryId(Integer categoryId) throws CategoryException {
		
        Optional<Category> opt=cRepository.findById(categoryId);
		
		if(opt.isEmpty()) {
			throw new CategoryException("No category present with given id.");
		}
		else {
			
			
			
			
			Category category=opt.get();
			
			List<Product> list=category.getProducts();
			
			List<ProductDTO> dtoList=new ArrayList<>();
			
			for(Product x:list) {
				ProductDTO pd=new ProductDTO();
				pd.setTitle(x.getTitle());
				pd.setPrice(x.getPrice());
				pd.setDescription(x.getDescription());
				pd.setAvailability(x.getAvailability());
				dtoList.add(pd);
			}
			
			
			return dtoList;
		}
	}

	@Override
	public Product getProductById(Integer productId) throws ProductException {
		Optional<Product> opt=pRepository.findById(productId);
		if(opt.isEmpty()) {
			throw new ProductException("No product with given id present.");
		}
		else {
			Product product=opt.get();
			return product;
		}
 		
	}

}
