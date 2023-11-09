package com.triveous.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId;
	
	@Pattern(regexp="^[A-Za-z ]+$",message="Invalid Product Name")
	@Size(min=3, message="The product name should contains atleast 3 characters")
	private String title;
	
	@Min(value = 0, message = "Price must be greater than or equal to 0")
	private double price;
	
	@NotNull(message="Description can not be not null.")
	private String description;
	
	@NotNull(message="availability can not be not null.")
	private String availability;
	
	@NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be at least 1")
    private Integer quantity;
	
	
	@ManyToOne
	@JsonIgnore
	private Category category;

}
