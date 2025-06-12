package com.productservice.client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends BaseModel{

	String title;
	int price;
	   @ManyToOne(optional = false)
	    private Category category;
	String description;
	String image;

	//ProductRating rating;

	public Product(String title, int price, Category category, String description, String image) {
		this.title = title;
		this.price = price;
		this.category = category;
		this.description = description;
		this.image = image;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Product() {
	
	}
}
