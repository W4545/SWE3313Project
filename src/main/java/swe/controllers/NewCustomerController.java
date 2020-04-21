package swe.controllers;

// Name: Jack Young
// Date: 4/11/2020

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import swe.fabrications.Person;
import swe.launch.App;

public class NewCustomerController {

	@FXML
	private TextField customerPhoneNumber;

	@FXML
	private TextField customerName;

	@FXML
	private TextField customerAddress;

	@FXML
	private TextField customerPaymentMethod;

	private App app;

	@FXML
	private void existingCustomerButton() {
		clear();
		app.getViews().getRootController().setCenter(app.getViews().getExistingCustomer());
	}

	@FXML
	private void newCustomerButton() {
		if (customerPhoneNumber.getText().isBlank() || customerName.getText().isBlank() ||
			customerAddress.getText().isBlank() || customerPaymentMethod.getText().isBlank()) {
			new Alert(Alert.AlertType.ERROR, "Please fill in all boxes").show();
			return;
		}
		Person person = new Person(customerPhoneNumber.getText(), customerName.getText(),
				customerAddress.getText(), customerPaymentMethod.getText());
		app.getCustomers().add(person);
		app.getViews().getReceiptPreviewController().setCustomer(person);
		clear();
		app.getViews().getRootController().setCenter(app.getViews().getOrderScreen());
	}

	public void clear() {
		customerAddress.clear();
		customerName.clear();
		customerPaymentMethod.clear();
		customerPhoneNumber.clear();
	}

	public void setApp(App app) {
		this.app = app;
	}
}
