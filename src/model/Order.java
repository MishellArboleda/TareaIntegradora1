package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Order {
	private String order_code;
	private Date date;
	private Date time;
	private Client id_client;
	private Restaurant nit_restaurant;
	private ArrayList<Product> products;
	private Status status;
	
	public Order() {
	}
	

	public Order(String code,Date date, Date time, Client id_client, Restaurant nit_restaurant,
			ArrayList<Product> products) {
		this.order_code = code;
		this.date = date;
		this.time = time;
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

	public Status getStatus() {
		return status;
	}
	
	public String getOrder_code() {
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

	public static Order getOrder(String order_code,ArrayList<Order> orders) {
		Order o = new Order();
		for (Order my_order : orders) {
			if (my_order.order_code.equals(order_code)) {
				o = my_order;
				return o;
			}
		}
		return o;
	}
	
	public static Order updateOrder(String order_code, Date date, Date time, Client id_client,
			Restaurant nit_restaurant, ArrayList<Product> products, Status status, 
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
