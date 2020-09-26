package ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import model.Client;
import model.Order;
import model.Product;
import model.Restaurant;
import model.RestaurantAssociation;
import model.Status;


public class Main {
	public static final int EXIT_OPTION = 16;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
			System.out.println("Menu");
			System.out.println("1. Register restaurant");
			System.out.println("2. Register products");
			System.out.println("3. Client registration");
			System.out.println("4. Order record");
			System.out.println("5. Update the details of a restaurant");
			System.out.println("6. Update the data of a product");
			System.out.println("7. Update the data of a client");
			System.out.println("8. Update the data of a order");
			System.out.println("9. Change the status of an order");
			System.out.println("10. Verify that all the products in the order belong to the restaurant that the customer chose");
			System.out.println("11. Save Elements");
			System.out.println("12. Load Elements");
			System.out.println("13. List all restaurants on the screen");
			System.out.println("14. List all clients on screen");
			System.out.println("15. Find a client");
			System.out.println("16. Exit");
			System.out.print("Enter the option: ");
			option = Integer.parseInt(sc.nextLine());
			switch(option) {
			case 1:
				System.out.println("Enter the details to register a restaurant:"  );
				System.out.print("Nit: ");
				String nit = sc.nextLine();
				System.out.println("Name: "); 
				String name = sc.nextLine();
				System.out.println("Administrator name: ");
				String admin_name = sc.nextLine();
				Restaurant r = new Restaurant(nit, name, admin_name);
				System.out.println("The restaurant has been successfully registered: " + r.getName() );
				System.out.println("The product: " + r.getName() + " with code: " + r.getNit() + 
						" has been successfully registered."  );
				break;
			case 2:
				System.out.println("Enter the details to register a product:"  );
				System.out.println("Code: ");
				String cod = sc.nextLine();
				System.out.println("Name: "); 
				String name2 = sc.nextLine();
				System.out.println("Description: "); 
				String description = sc.nextLine();
				System.out.println("Cost: ");
				double cost = Double.parseDouble(sc.nextLine());
				Product p = new Product(cod, name2, description, cost);
				System.out.println("The product: " + p.getName() + " with code: " + p.getCod() + 
						" has been successfully registered."  );
				break;
			case 3:
				System.out.println("Enter the details to register a client: "  );
				System.out.println("Document type: ");
				String document_type = sc.nextLine();
				System.out.println("Id: "); 
				String id = sc.nextLine();
				System.out.println("Name: "); 
				String name3 = sc.nextLine();
				System.out.println("Last name: ");
				String last_name = sc.nextLine();
				System.out.println("Addres: ");
				String addres = sc.nextLine();
				System.out.println("Phone number: ");
				String phone_number = sc.nextLine();
				Client c = new Client(document_type, id, name3, last_name, addres, phone_number);
				System.out.println("The client: " + c.getFull_name() + " with identification: " + c.getId() + 
						" has been successfully registered."  );
				break;
			case 4:
				System.out.println("Enter the details to record a order: "  );
				System.out.println("Id client: "); 
				String id_client = sc.nextLine();
				System.out.println("Nit restaurant: ");
				String nit_restaurant = sc.nextLine();
				System.out.println("Status: ");
				String status = sc.nextLine();
				Date date = new Date();
				int code = (int) Math.random();
				ArrayList<Product> products = new ArrayList<Product>();
				Order o = new Order(code, date, id_client, nit_restaurant, products);
				System.out.println("The order with the code: " + o.getOrder_code() + " has been successfully registered");
				break;
			case 5:
				System.out.println("enter the nit of the restaurant to update: "  );
				String nit2 = sc.nextLine();
				Restaurant r2 = new Restaurant();
				System.out.println("the restaurant to update is: " +r2.getName() + "with the nit" + r2.getNit());
				System.out.print("Nit: ");
				String nit3 = sc.nextLine();
				System.out.println("Name: "); 
				String nam = sc.nextLine();
				System.out.println("Administrator name: ");
				String admin_name2 = sc.nextLine();
				Restaurant r3 = new Restaurant(nit3, nam, admin_name2);
				System.out.println("The restaurant has been successfully registered: " + r3.getName() );
				System.out.println("The product: " + r3.getName() + " with code: " + r3.getNit() + 
						" has been successfully update."  );
				break;
			case 6:
				System.out.println("enter the cod of the product to update: "  );
				String cod2 = sc.nextLine();
				Product p2 = new Product();
				System.out.println("the product to update is: " +p2.getName() + "with the cod" + p2.getCod());
				System.out.println("Name: "); 
				String nam3 = sc.nextLine();
				System.out.println("Description: "); 
				String description2 = sc.nextLine();
				System.out.println("Cost: ");
				double cost2 = Double.parseDouble(sc.nextLine());
				Product p3 = new Product(cod2, nam3, description2, cost2);
				System.out.println("The product: " + p2.getName() + " with code: " + p2.getCod() + 
						" has been successfully update."  );
				break;
			case 7:
				System.out.println("enter the id of the client to update: "  );
				String id2 = sc.nextLine();
				Client c2 = new Client();
				String document_type2 = sc.nextLine();
				System.out.println("Id: "); 
				String id3 = sc.nextLine();
				System.out.println("Name: "); 
				String name4 = sc.nextLine();
				System.out.println("Last name: ");
				String last_name2 = sc.nextLine();
				System.out.println("Addres: ");
				String addres2 = sc.nextLine();
				System.out.println("Phone number: ");
				String phone_number2 = sc.nextLine();
				Client c3 = new Client(document_type2, id3, name4, last_name2, addres2, phone_number2);
				System.out.println("The client: " + c3.getFull_name() + " with identification: " + c3.getId() + 
						" has been successfully update."  );
				break;
			case 8:
				System.out.println("enter the cod of the product to update: "  );
				String cod4 = sc.nextLine();
				Product p4 = new Product();
				System.out.println("Id client: "); 
				String id_client4 = sc.nextLine();
				System.out.println("Nit restaurant: ");
				String nit_restaurant4 = sc.nextLine();
				System.out.println("Status: ");
				String status4 = sc.nextLine();
				Date date4 = new Date();
				int code4 = (int) Math.random();
				System.out.println("Status: "); 
				Status status2 = sc.nextLine();
				ArrayList<Product> products2 = new ArrayList<Product>();
				ArrayList<Order> orders2 = new ArrayList<Order>();
				Order o4 = new Order();
				o4.updateOrder(code4, date4, id_client4, nit_restaurant4, products2, status2, orders2);
				System.out.println("The order with the code: " + o4.getOrder_code() + " has been successfully registered");
				break;
			}
			
			
			
		} while(option!=EXIT_OPTION);
	}
}
