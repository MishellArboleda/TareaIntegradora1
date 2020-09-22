package model;

import java.util.ArrayList;

public class Client {
	private String document_type;
	private String id;
	private String name;
	private String last_name;
	private String full_name;
	private String addres;
	private String phone_number;

	public Client() {
	}

	public Client(String document_type, String id, String name, String last_name, String addres, String phone_number) {
		this.document_type = document_type;
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.full_name = this.name + " " + this.last_name;
		this.addres = addres;
		this.phone_number = phone_number;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String name, String last_name) {
		this.full_name = this.name + " " + this.last_name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	
	public static Client getClient(String id, ArrayList<Client> clients) {
		Client c = new Client();
		for (Client my_client : clients) {
			if (id.equals(my_client.id)) {
				c = my_client;
				return c;
			}
		}
		return c;
	}

	public static Client updateClient(String document_type, String id, String name, String last_name, String addres,
			String phone_number, ArrayList<Client> clients) {
		Client c = getClient(id, clients);
		c.setDocument_type(document_type);
		c.setName(name);
		c.setLast_name(last_name);
		c.setFull_name(name, last_name);
		c.setAddres(addres);
		c.setPhone_number(phone_number);
		return c;
	}

	public static ArrayList<Client> sortingClient(ArrayList<Client> clients, Client c) {
		return clients;
	}
		}

	 
