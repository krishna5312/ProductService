package com.productservice.client.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Category extends BaseModel{
	
	    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

		private String name;
		
		@OneToMany(mappedBy = "category")
		private List<Product> products;
	 
	 

}
