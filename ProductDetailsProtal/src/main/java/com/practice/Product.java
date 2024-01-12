package com.practice;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private String productName;
    private double price;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}