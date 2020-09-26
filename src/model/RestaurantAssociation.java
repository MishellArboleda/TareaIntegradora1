package model;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class RestaurantAssociation {
	private static ArrayList<Restaurant> restaurants;
	
	public RestaurantAssociation (){		
	}
	
	public RestaurantAssociation (ArrayList<Restaurant> restaurants){
		this.restaurants = restaurants;
	}

	
public final static String SAVE_PATH_RESTAUTANT = "data/restaurant.txt";
		
	
	public void exportDataRestaurantAssociation(String fileName, String separator) throws FileNotFoundException {

		PrintWriter pw = new PrintWriter(fileName);
		for(Restaurant restaurant:restaurants) {
			pw.println(restaurant.getNit()+ separator + restaurant.getName() + separator+ restaurant.getAdmin_name()); 
			}
		pw.close();
	}
	public void importDataProduct(String fileName, String separator) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		while(line!=null) {
			String[] parts = line.split(separator);
			String nit = parts[0];
			String name = parts[1];
		    String admin_name = parts[2];
			Restaurant restaurant1 = new Restaurant(nit, name, admin_name);
			addRestaurant(restaurant1);
			line = br.readLine();
		}
		br.close();
	}
	
	public void saveDataProduct() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_RESTAUTANT));
		oos.writeObject(restaurants);
		oos.close();
	}
	@SuppressWarnings("unchecked")
	
	public void loadDatClient() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_PATH_RESTAUTANT));
		restaurants = (ArrayList<Restaurant>)ois.readObject();
		ois.close();
	}
	
	public static void addRestaurant(Restaurant r) {
		restaurants.add(r);
	}

	public ArrayList<Restaurant> burbbleRestaurantsSortByName(){

		ArrayList<Restaurant> restaurantByName = restaurants;
		for( int i = restaurantByName.size(); i > 0; i-- )
		{
			for( int j = 0; j < i - 1; j++ )
			{
				if( (restaurantByName.get(j).getName().compareTo(restaurantByName.get(j+1).getName()))== -1){
					Restaurant temp = restaurantByName.get(j);
					restaurantByName.add(j,restaurantByName.get(j+1));
					restaurantByName.add(j+1,temp);
				}
			}
		}
		return restaurantByName;
	}

	public  int searchRestaurantByNit(String nit) {
		int index = -1;
		int bound = restaurants.size();
		for ( int i = 0; i < bound; i++) {
			if (restaurants.get(i).equals(nit)) {
				index = i;
				break;
			}
		}
		return index;
	}


}
