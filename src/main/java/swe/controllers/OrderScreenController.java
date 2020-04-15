package swe.controllers;

// Name: Jack Young
// Date: 4/12/2020

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderScreenController implements Initializable {

	private App app;

	@FXML
	private SplitPane splitPane;


	public void setApp(App app) {
		this.app = app;
	}

	public void setRight(Parent parent) {
		if (splitPane.getItems().size() > 1)
			splitPane.getItems().remove(1);
		splitPane.getItems().add(parent);
		splitPane.setDividerPositions(.25);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
