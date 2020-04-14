package swe.controllers;

// Name: Jack Young
// Date: 4/12/2020

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceiptPreviewController implements Initializable {
	private App app;

	@FXML
	private VBox vBox;

	@FXML
	private Label total;

	public void setApp(App app) {
		this.app = app;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		vBox.getChildren().add(new Label("$14.00 Pizza: SIZE-M CRUST-Hand Tossed SAUCE-Marinara"));
//		vBox.getChildren().add(new Label("$0.40\t\tTOPPINGS- Pepperoni Sausage"));
//		vBox.getChildren().add(new Label("$1.50 M Fountain Drink OPTION-Water"));
//		total.setText("Total: $15.90");
	}
}
