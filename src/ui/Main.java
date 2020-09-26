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
			    System.out.println("The restaurant has been successfully registered: " );
			    break;

			}
		} while(option!=EXIT_OPTION);
	}
}
