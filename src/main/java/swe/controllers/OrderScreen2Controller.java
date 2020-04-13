package swe.controllers;

// Name: Jack Young
// Date: 4/13/2020

import javafx.fxml.FXML;
import swe.launch.App;

public class OrderScreen2Controller {

	private App app;

	public void setApp(App app) {
		this.app = app;
	}

	@FXML
	private void backButton() {
		app.getOrderScreenController().setRight(app.getOrderScreen1());
	}

	@FXML
	private void confirmButton() {

	}
}
