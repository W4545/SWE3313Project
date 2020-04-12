package swe.fabrications;

// Name: Jack Young
// Date: 4/12/2020

import java.util.ArrayList;

public class Pizza implements Food {

	private String crust;
	private String size;
	private String sauce;
	private ArrayList<String> options;
	private double baseCost;
	private double optionsCost;

	public Pizza(String crust, String size, String sauce, ArrayList<String> options, double baseCost, double optionsCost) {
		this.crust = crust;
		this.size = size;
		this.sauce = sauce;
		this.options = options;
		this.baseCost = baseCost;
		this.optionsCost = optionsCost;
	}

	public String getCrust() {
		return crust;
	}

	public void setCrust(String crust) {
		this.crust = crust;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSauce() {
		return sauce;
	}

	public void setSauce(String sauce) {
		this.sauce = sauce;
	}

	public ArrayList<String> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<String> options) {
		this.options = options;
	}

	public double getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(double baseCost) {
		this.baseCost = baseCost;
	}

	public double getPrice() {
		return baseCost + optionsCost * options.size();
	}
}
