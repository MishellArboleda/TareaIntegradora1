package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Restaurant;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		ArrayList<Restaurant> restaurantes = new ArrayList<Restaurant>();
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingresa el nit del restaurante: \n");
		String nit = sc.next();
		System.out.print("Ingresa el nombre del restaurante: \n");
		String name = sc.next();
		System.out.print("Ingresa el nombre del administrador del restaurante: \n");
		String admin_name = sc.next();

		Restaurant r = Restaurant.createRestaurant(nit, name, admin_name, restaurantes);
		System.out.println("Valor de restaurantes: " + restaurantes);
		
		System.out.print("Ingresa el nit que quiere buscar: \n");
		String nit_buscar = sc.next();
		
		
		Restaurant my_restaurante_encontrado = Restaurant.getRestaurant(nit_buscar, restaurantes);
		System.out.println("Encontro este nombre: " + my_restaurante_encontrado.getName());

	}

}
