package com.triveous.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	
	@ManyToOne
	@JsonIgnore
	private Customer customer;
	
	@ManyToMany(mappedBy="orders",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Product> product;
	
	
	private double totalPrice;
}
