package pages;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String email; 
	private String pass;
	private String name;
	private List<String> cart;

	public User(String email, String pass, String name) {
		super();
		this.email = email;
		this.pass = pass;
		this.name = name;
		this.cart = new ArrayList<>();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getCart() {
		if(cart == null) {
			cart = new ArrayList<>();
		}
		return cart;
	}
	
	public void addTeaToCart (String tea) {
		if(cart == null) {
			cart = new ArrayList<>();
		}
		cart.add(tea);
	}
	
	public void removeTeaFromCart (String tea) {
		cart.remove(tea);
	}
	
	public void clearCart() {
		cart.clear();
	}
	
}
