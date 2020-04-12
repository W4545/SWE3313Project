package swe.fabrications;

// Name: Jack Young
// Date: 4/12/2020

public class Drink implements Food {

	String size;
	String name;
	double price;

	public Drink(String name, String size, double price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public String getName() {
		return name;
	}

	@Override
	public double getPrice() {
		return price;
	}
}
