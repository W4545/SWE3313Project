package swe.controllers;

// Name: Jack Young
// Date: 4/11/2020

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import swe.fabrications.Person;
import swe.launch.App;

public class ExistingCustomerController {

	private App app;

	@FXML
	private TableView<Person> table;

	@FXML
	private TextField searchField;

	@FXML
	private void search() {
		String text = searchField.getText();
		if (text.isBlank()) {
			System.out.println("No search term giving, showing all customers");
			table.setItems(app.getCustomers());
		} else {
			System.out.println(String.format("Executing search for customer with ID: %s", text));
			table.setItems(app.getCustomers().filtered(person -> person.getCustomerID().equals(text)));
		}
	}

	@FXML
	private void confirmButton() {
		Person customer = table.getSelectionModel().getSelectedItem();
		if (customer != null) {
			app.getViews().getReceiptPreviewController().setCustomer(customer);
			app.getViews().getRootController().setCenter(app.getViews().getOrderScreen());
		}
	}

	public void setApp(App app) {
		this.app = app;
	}
}
