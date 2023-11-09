package com.triveous.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.triveous.model.Product;
import com.triveous.model.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

//@Query("select NEW com.triveous.ProductDTO(p.title,p.price,p.description,p.availability) from Product p inner join Category c where p.categoryId:=Id")	
//public List<ProductDTO> findProductDTO(@Param("Id") Integer Id);
}
