package com.triveous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.model.CartProduct;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct,Integer> {

}
