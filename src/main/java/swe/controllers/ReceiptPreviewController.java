package swe.controllers;

// Name: Jack Young
// Date: 4/12/2020

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import swe.launch.App;

public class ReceiptPreviewController {
	private App app;

	@FXML
	private VBox vBox;

	public void setApp(App app) {
		this.app = app;
	}
}
