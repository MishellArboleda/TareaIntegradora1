package model;

import java.util.ArrayList;

public class Product {
	private String cod;
	private String name;
	private String description;
	private double cost;
	
	public Product() {
	}

	public Product(String cod, String name, String description, double cost) {
		super();
		this.cod = cod;
		this.name = name;
		this.description = description;
		this.cost = cost;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public static Product createProduct (String cod, String name, String description, 
			double cost, ArrayList<Product> products) {
		Product p = new Product(cod, name, description, cost);
		products.add(p);
	    return p;
	}
	
	public static Product getProduct(String cod, ArrayList<Product> products){
		Product p = new Product();
		for (Product product : products) {
			if (product.cod.equals(cod)) {
				p = product;
				return p; 
			}
		}
		return p;
	}
	
	public static Product updateProduct (String cod, String name, String description, 
			double cost, ArrayList<Product> products) {
		Product p = new Product();
		p = getProduct(cod, products);
		p.setCost(cost);
		p.setDescription(description);
		p.setName(name);
		
		return p;
	}


}
