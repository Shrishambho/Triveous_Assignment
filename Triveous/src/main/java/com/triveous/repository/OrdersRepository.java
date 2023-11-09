package com.triveous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.triveous.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

}
