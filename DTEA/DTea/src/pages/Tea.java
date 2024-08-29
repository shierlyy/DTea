package pages;

public class Tea {
	
	private String name;
	private double price;
	private Integer stock;
	private String description;
	
	public Tea(String name, double price, Integer stock, String description) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
