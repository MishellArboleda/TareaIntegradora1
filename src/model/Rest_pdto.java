package model;

public class Rest_pdto {
	private Restaurant nit_restaurant;
	private Product cod_product;

	public Rest_pdto() {
	}

	public Rest_pdto(Restaurant nit_restaurant, Product cod_product) {
		this.nit_restaurant = nit_restaurant;
		this.cod_product = cod_product;
	}

	public Restaurant getNit_restaurant() {
		return nit_restaurant;
	}

	public void setNit_restaurant(Restaurant nit_restaurant) {
		this.nit_restaurant = nit_restaurant;
	}

	public Product getCod_product() {
		return cod_product;
	}

	public void setCod_product(Product cod_product) {
		this.cod_product = cod_product;
	}

	public static Rest_pdto assignProductToRestauurant(Restaurant nit_restaurant, Product cod_product) {
		Rest_pdto rp = new Rest_pdto(nit_restaurant, cod_product);
		return rp;
	}

}
