package com.StockManager.Model;

import java.util.Objects;

public class Product {

	private Long id;
	private String name;
	private String description;
	private int amount;
	private Long heritage;
	
	
	
	 public Product() {
		super();
	}
	Product(Long id, String name, String description, int amount, Long heritage) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
		this.heritage = heritage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Long getHeritage() {
		return heritage;
	}
	public void setHeritage(Long heritage) {
		this.heritage = heritage;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, description, heritage, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return amount == other.amount && Objects.equals(description, other.description)
				&& Objects.equals(heritage, other.heritage) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
	
}
