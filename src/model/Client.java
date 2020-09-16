package model;

import java.util.ArrayList;

public class Client {
	private String document_type;
	private String id;
	private String full_name;
	private String addres;
	private String phone_number;

	public Client() {
	}

	public Client(String document_type, String id, String full_name, String addres, String phone_number) {
		this.document_type = document_type;
		this.id = id;
		this.full_name = full_name;
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

	public void setFull_name(String full_name) {
		this.full_name = full_name;
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

	public static Client createClient(String document_type, String id, String full_name, String addres,
			String phone_number, ArrayList<Client> clients) {
		Client c = new Client(document_type, id, full_name, addres, phone_number);
		clients.add(c);
		return c;
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

	public static Client updateClient(String document_type, String id, String full_name, String addres,
			String phone_number, ArrayList<Client> clients) {
		Client c = getClient(id, clients);
		c.setDocument_type(document_type);
		c.setFull_name(full_name);
		c.setAddres(addres);
		c.setPhone_number(phone_number);
		return c;
	}
}
