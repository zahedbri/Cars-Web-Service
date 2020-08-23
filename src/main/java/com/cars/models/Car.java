package com.cars.models;

public class Car {
	
	private String brand;
	private String model;
	private String type;
	
	public Car(String brand, String model, String type) {
		this.brand = brand;
		this.model = model;
		this.type = type;
	}

	public String getBrand() {
		return this.brand;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getType() {
		return this.type;
	}
}
