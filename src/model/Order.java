package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Order {
	private int order_code;
	private Date date;
	private String id_client;
	private String nit_restaurant;
	private ArrayList<Product> products;
	private Status status;
	
	public Order() {
	}
	

	public Order(int code,Date date, String id_client, String nit_restaurant,
			ArrayList<Product> products) {
		this.order_code = code;
		this.date = date;
		this.id_client = id_client;
		this.nit_restaurant = nit_restaurant;
		this.products = products;
		status = Status.REQUESTED;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId_client() {
		return id_client;
	}

	public void setId_client(String id_client) {
		this.id_client = id_client;
	}

	public String getNit_restaurant() {
		return nit_restaurant;
	}

	public void setNit_restaurant(String nit_restaurant) {
		this.nit_restaurant = nit_restaurant;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public Status getStatus() {
		return status;
	}
	
	public int getOrder_code() {
		return order_code;
	}
	

	public void setStatus(Status status) {
		if(this.status == Status.IN_PROCESS) {
			if (status != Status.DELIVERED && status != Status.SENT) {
				this.status = status;
			}
		} else if (this.status == Status.SENT) {
			if (status != Status.REQUESTED && status != Status.IN_PROCESS) {
				this.status = status;
			}
		} else if (this.status == Status.DELIVERED) {

		} else {
			this.status = status;
		}
	}

	public static Order getOrder(int order_code,ArrayList<Order> orders) {
		Order o = new Order();
		for (Order my_order : orders) {
			if (my_order.order_code == order_code) {
				o = my_order;
				return o;
			}
		}
		return o;
	}
	
	public static Order updateOrder(int order_code, Date date,  String id_client,
			String nit_restaurant, ArrayList<Product> products, Status status, 
			ArrayList<Order> orders) {
		Order o = getOrder(order_code, orders);
		o.setDate(date);
		o.setId_client(id_client);
		o.setNit_restaurant(nit_restaurant);
		o.setProducts(products);
		o.setStatus(status);
		return o;
		
	}
}
