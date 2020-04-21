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

	public void setLeft(Parent parent) {
		if (splitPane.getItems().size() == 2)
			splitPane.getItems().set(0, parent);
		else
			splitPane.getItems().add(0, parent);
		splitPane.setDividerPositions(.25);
	}

	public void setRight(Parent parent) {
		if (splitPane.getItems().size() == 2)
			splitPane.getItems().set(1, parent);
		else
			splitPane.getItems().add(1, parent);
		splitPane.setDividerPositions(.25);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
