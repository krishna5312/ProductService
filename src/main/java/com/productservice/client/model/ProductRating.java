package com.productservice.client.model;

import jakarta.persistence.Entity;

@Entity
public class ProductRating extends BaseModel{
	double rate;
	int count;
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ProductRating() {
	}
}