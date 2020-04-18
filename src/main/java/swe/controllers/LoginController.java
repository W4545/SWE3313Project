package swe.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import swe.launch.App;

public class LoginController {

	private App app;

	@FXML
	private PasswordField passwordField;

	@FXML
	private TextField userNameField;

	public void setApp(App app) {
		this.app = app;
	}

	public void clear() {
		userNameField.setText("");
		passwordField.setText("");
	}

	@FXML
	void submit() {
		String username = userNameField.getText();
		String password = passwordField.getText();
		clear();
		if (username.equals("cashier") && password.equals("password")) {
			app.getViews().getRootController().setCenter(app.getViews().getNewCustomer());
		}
	}
}
