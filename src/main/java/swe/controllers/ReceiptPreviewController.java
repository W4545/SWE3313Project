package swe.controllers;

// Name: Jack Young
// Date: 4/12/2020

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import swe.fabrications.ItemView;
import swe.fabrications.Person;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceiptPreviewController implements Initializable {
	private App app;

	private Person customer;
	private SimpleDoubleProperty totalProperty;
	private SimpleDoubleProperty taxProperty;

	@FXML
	private VBox vBox;

	@FXML
	private Label tax;

	@FXML
	private Label total;

	@FXML
	private Label orderTitle;

	public void setApp(App app) {
		this.app = app;
	}

	public void setCustomer(Person person) {
		customer = person;
		if (customer == null)
			orderTitle.setText("Order(s):");
		else
			orderTitle.setText(String.format("Order(s) for %s: ", person.getName()));
	}

	public VBox getVBox() {
		return vBox;
	}

	public void update() {
		double value = 0;
		for (Node node : vBox.getChildrenUnmodifiable())
			value += ((ItemView) node).getPrice();
		totalProperty.set(value);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		totalProperty = new SimpleDoubleProperty(0);

		taxProperty = new SimpleDoubleProperty(0);
		taxProperty.bind(Bindings.multiply(totalProperty, App.TAX));

		tax.textProperty().bind(Bindings.format("Tax: $%.2f", taxProperty));
		total.textProperty().bind(Bindings.format("Total: $%.2f", Bindings.add(totalProperty, taxProperty)));
	}
}
