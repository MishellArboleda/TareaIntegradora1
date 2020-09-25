package model;

import javax.print.attribute.standard.OrientationRequested;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

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
	
	public boolean searchtProduct(String cod) {
		boolean encontre = false;
		int inicio = 0;
		int fin = products.size() - 1;
		while( inicio <= fin && !encontre ){
			int medio = ( inicio + fin ) / 2;
			if( products.get(medio).getCod().equals(cod)){
				encontre = true;
			}
			else if( products.get(medio).getCod().compareTo(cod) == -1){
				fin = medio - 1;
			}
			else {
				inicio = medio + 1;
			}
		}
		return encontre;
	}

	public void addProducts(Product product){
		if(products.size() == 0){
			products.add(product);
		}else if(searchtProduct(product.getCod()) == false) {
			products.add(product);
		}
	}
	
	public final static String SAVE_PATH_RESTAURANT = "data/restaurant.txt";
	public final static String SAVE_PATH_PRODUCT = "data/product.txt";
	public final static String SAVE_PATH_CLIENT = "data/client.txt";
	public final static String SAVE_PATH_ORDER = "data/order.txt";
		
	
	public void exportDataProduct(String fileName, String separator) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(fileName);
		for(Product product:products) {
			pw.println(product.getCod()+ separator + product.getName() + separator+ product.getDescription() 
			+ separator + product.getCost());
		}
		pw.close();
	}
	public void importDataProduct(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while(line!=null) {
			String[] parts = line.split(separator);
			String cod = parts[0];
			String nombre = parts[1];
		    String description = parts[2];
			double cost = Double.parseDouble(parts[3]);
			Product product1 = new Product(cod,nombre,description,cost);
			addProducts(product1);
			line = br.readLine();
		}
		br.close();
	}
	
	public void saveDataProduct() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_PRODUCT));
		oos.writeObject(products);
		oos.close();
	}
	@SuppressWarnings("unchecked")
	
	public void loadDatClient() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH_PRODUCT));
		products = (ArrayList<Product>)ois.readObject();
		ois.close();
	}
	
	
	public void exportDataClient(String fileName, String separator) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(fileName);
		for(Client client:clients) {
			pw.println(client.getDocument_type()+ separator + client.getId() + separator+ client.getName() + separator+client.getLast_name()+
					separator+ client.getAddres()+separator+client.getPhone_number());
		}
		pw.close();
	}
	public void importDataClient(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while(line!=null) {
			String[] parts = line.split(separator);
			String document_type = parts[0];
			String id = parts[1];
		    String name = parts[2];
			String last_name = parts[3];
			String addres = parts[4];
			String phone_number = parts[5];
			Client client1 = new Client(document_type,id,name, last_name, addres, phone_number);
			addClients(client1);
			line = br.readLine();
		}
		br.close();
	}
	
	public void saveDataClient() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_CLIENT));
		oos.writeObject(clients);
		oos.close();
	}
	@SuppressWarnings("unchecked")
	public void loadDataClient() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH_CLIENT));
		clients = (ArrayList<Client>)ois.readObject();
		ois.close();
	}
	
	public void exportDataOrder(String fileName, String separator) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(fileName);
		for(Order order:orders) {
			pw.println(order.getOrder_code()+ separator + order.getTime() + separator+ order.getDate() + separator+ 
			order.getId_client()+separator+ order.getNit_restaurant()+separator+order.getProducts());
		}
		pw.close();
	}
	/*public void importDataOrder(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while(line!=null) {
			String[] parts = line.split(separator);
			String order_code = parts[0];
			String time = parts[1];
		    String date = parts[2];
			String id_client = parts[3];
			String nit_restaurant = parts[4];
			Order order1 = new Order(order_code,time, date, id_client, nit_restaurant);
			addOrder(order1);
			line = br.readLine();
		}
		br.close();
	}*/
	
	public void saveDataOrder() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_ORDER));
		oos.writeObject(orders);
		oos.close();
	}
	@SuppressWarnings("unchecked")
	public void loadDataOrder() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH_ORDER));
		orders = (ArrayList<Order>)ois.readObject();
		ois.close();
	}

	public void addOrder(Order o) {
		orders.add(o);
		
	}
}


