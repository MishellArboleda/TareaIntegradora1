package model;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;

public class Restaurant {
	private String nit;
	private String name;
	private String admin_name;
	private ArrayList<Product> products;
	private ArrayList<Client> clients;
	private ArrayList<Order> orders;

	public Restaurant() {
	}

	public Restaurant(String nit, String name, String admin_name) {
		this.nit = nit;
		this.name = name;
		this.admin_name = admin_name;
		this.products = new ArrayList<>();
		this.clients = new ArrayList<>();
		this.orders = new ArrayList<>();
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	/*public static Restaurant createRestaurant(String nit, String name, String admin_name,
			ArrayList<Restaurant> restaurants) {
		Restaurant restaurant = new Restaurant(nit, name, admin_name);
		restaurants.add(restaurant);
		return restaurant;
	}*/

	public static Restaurant getRestaurant(String nit, ArrayList<Restaurant> restaurants) {
		Restaurant r = new Restaurant();
		for (Restaurant restaurant : restaurants) {
			if (restaurant.nit.equals(nit)) {
				return r = restaurant;
			}
		}
		return r;
	}

	public static Restaurant updateRestaurant(String nit, String name, String admin_name,
			ArrayList<Restaurant> restaurants) {
		Restaurant r = getRestaurant(nit, restaurants);
		r.setName(name);
		r.setAdmin_name(admin_name);
		return r;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void addClients(Client client){
		if(clients.size() == 0){
			clients.add(client);
		}else{
			ClientComparator  clientComparator = new ClientComparator();
			int pos = 0;
			for(int i = 0; i<clients.size();i++){
				int indicador = clientComparator.compare(client,clients.get(i));
				if(indicador == 1){

				}else if(indicador == -1 || indicador == 0) {
					pos = i+1;
				}
			}
			clients.add(pos,client);
		}
	}
}