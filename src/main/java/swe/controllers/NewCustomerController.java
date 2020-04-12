package swe.controllers;

// Name: Jack Young
// Date: 4/11/2020

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
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
		app.getRootController().setCenter(app.getExistingCustomer());
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
