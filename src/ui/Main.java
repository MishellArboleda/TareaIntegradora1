package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import model.Client;
import model.Order;
import model.Product;
import model.Restaurant;
import model.Status;

public class Main {

	public static void main(String[] args) {

		System.out.println("Hola mundo");
		Restaurant restaurant = new Restaurant("VDV","CDVD","VDVD");
		Client client1 = new Client("TI", "123", "LUIS", "ARIAS", "CLL 12", "123");
		Client client2 = new Client("TI", "123", "LUISA", "ARIAS", "CLL 12", "123");
		Client client3 = new Client("TI", "123", "LUISO", "ARIAS", "CLL 12", "123");
		Client client4 = new Client("TI", "123", "LUIS", "LOPEZ", "CLL 12", "123");
		Client client5 = new Client("TI", "123", "LUIS", "QUIJANO", "CLL 12", "123");
		Client client6 = new Client("TI", "123", "LUIS", "ANGULO", "CLL 12", "123");
		Client client7 = new Client("TI", "123", "LUIS", "VARGAS", "CLL 12", "123");
		Client client8 = new Client("TI", "123", "LUIS", "GUARIN", "CLL 12", "123");
		Client client9 = new Client("TI", "123", "LUIS", "ARBOLEDA", "CLL 12", "123");
		Client client10 = new Client("TI", "123", "LUIS", "MORALES", "CLL 12", "123");
		Client client11 = new Client("TI", "123", "LUIS", "DELGADO", "CLL 12", "123");
		Client client12 = new Client("TI", "123", "LUIS", "AYALA", "CLL 12", "123");

		restaurant.addClients(client4);
		restaurant.addClients(client1);
		restaurant.addClients(client6);
		restaurant.addClients(client3);
		restaurant.addClients(client4);
		restaurant.addClients(client2);
		restaurant.addClients(client5);
		restaurant.addClients(client12);
		restaurant.addClients(client7);
		restaurant.addClients(client8);
		restaurant.addClients(client10);
		restaurant.addClients(client11);
		restaurant.addClients(client9);
		restaurant.addClients(client7);

		for (int i = 0; i<restaurant.getClients().size(); i++){
			System.out.println(""+restaurant.getClients().get(i).getLast_name()+" "+restaurant.getClients().get(i).getName());
		}
		
		ArrayList<Product> products = new ArrayList<>();
		Product product = new Product("vve","fvefvr","fevf",73653);
		Product product2 = new Product("mia","fvefvr","fevf",73653);
		products.add(product);
		Date date = new Date();
		Order o = new Order( UUID.randomUUID().toString(),date,date,restaurant.getClients().get(1),restaurant, products);
		System.out.println("el estado del producto es "+o.getStatus() );
		o.setStatus(Status.DELIVERED);
		System.out.println("el estado del producto es " +o.getStatus());
		o.setStatus(Status.IN_PROCESS);
		System.out.println("el estado del producto es " +o.getStatus());
		
		restaurant.addOrder(o);
		restaurant.addProducts(product);
		
		System.out.println("el restaurante buscado es:" +restaurant.searchtProduct(product2.getCod()));
		System.out.println("productos"+restaurant.getOrders().get(0).getProducts());
	}
	
}