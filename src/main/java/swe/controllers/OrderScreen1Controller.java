package swe.controllers;

// Name: Jack Young
// Date: 4/13/2020

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import swe.launch.App;

public class OrderScreen1Controller {

	private App app;

	@FXML
	private ToggleGroup crustToggleGroup;

	public void setApp(App app) {
		this.app = app;
	}

	@FXML
	private void nextButton() {
		app.getOrderScreenController().setRight(app.getOrderScreen2());
	}
}
