package swe.controllers;

// Name: Jack Young
// Date: 4/11/2020

import javafx.fxml.FXML;
import swe.launch.App;

public class ExistingCustomerController {

	private App app;

	@FXML
	private void confirmButton() {
		app.getRootController().setCenter(app.getOrderScreen());
	}

	public void setApp(App app) {
		this.app = app;
	}
}
