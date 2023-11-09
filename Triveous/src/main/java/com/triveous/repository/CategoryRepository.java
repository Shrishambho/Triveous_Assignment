package com.triveous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
