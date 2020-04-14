package swe.controllers;

// Name: Jack Young
// Date: 4/11/2020

import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class ExistingCustomerController implements Initializable {

	private App app;

	@FXML
	private TableView table;

	@FXML
	private void confirmButton() {
		app.getRootController().setCenter(app.getOrderScreen());
	}

	public void setApp(App app) {
		this.app = app;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
