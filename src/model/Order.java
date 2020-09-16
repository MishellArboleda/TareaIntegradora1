package model;

import java.util.ArrayList;
import java.util.Date;

public class Order {
	private int order_code;
	private Date date;
	private Date time;
	private Client id_client;
	private Restaurant nit_restaurant;
	private ArrayList<Product> products;
	private String status;
	
	public Order() {
	}

	public Order(int order_code, Date date, Date time, Client id_client, Restaurant nit_restaurant,
			ArrayList<Product> products, String status) {
		this.order_code = order_code;
		this.date = date;
		this.time = time;
		this.id_client = id_client;
		this.nit_restaurant = nit_restaurant;
		this.products = products;
		this.status = status;
	}

	public int getOrder_code() {
		return order_code;
	}

	public void setOrder_code(int order_code) {
		this.order_code = order_code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Client getId_client() {
		return id_client;
	}

	public void setId_client(Client id_client) {
		this.id_client = id_client;
	}

	public Restaurant getNit_restaurant() {
		return nit_restaurant;
	}

	public void setNit_restaurant(Restaurant nit_restaurant) {
		this.nit_restaurant = nit_restaurant;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public static Order createOrder(int order_code, Date date, Date time, Client id_client, 
			Restaurant nit_restaurant, ArrayList<Product> products, String status, 
			ArrayList<Order> orders) {
		Order o = new Order(order_code, date, time, id_client, nit_restaurant, products, status);
		orders.add(o);
		return o;
	}
	
	public static Order getOrder(int order_code,ArrayList<Order> orders) {
		Order o = new Order();
		for (Order my_order : orders) {
			if (my_order.order_code==order_code) {
				o = my_order;
				return o;
			}
		}
		return o;
	}
	
	public static Order updateOrder(int order_code, Date date, Date time, Client id_client, 
			Restaurant nit_restaurant, ArrayList<Product> products, String status, 
			ArrayList<Order> orders) {
		Order o = getOrder(order_code, orders);
		o.setDate(date);
		o.setId_client(id_client);
		o.setNit_restaurant(nit_restaurant);
		o.setProducts(products);
		o.setStatus(status);
		o.setTime(time);
		return o;
		
	}
	

}
