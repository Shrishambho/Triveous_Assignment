package com.triveous.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer categoryId;
	
	@Pattern(regexp="^[A-Za-z ]+$",message="Invalid Category Name")
	@Size(min=3, message="The category name should contains atleast 3 characters")
	private String name;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private List<Product> products;
	
}
