package swe.controllers;

// Name: Jack Young
// Date: 4/13/2020

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import swe.launch.App;

public class OrderScreen2Controller {

	@FXML
	private CheckBox pepperoni;
	@FXML
	private CheckBox sausage;
	@FXML
	private CheckBox beef;
	@FXML
	private CheckBox chicken;
	@FXML
	private CheckBox bacon;
	@FXML
	private CheckBox salami;
	@FXML
	private CheckBox onions;
	@FXML
	private CheckBox peppers;
	@FXML
	private CheckBox mushrooms;
	@FXML
	private CheckBox olives;
	@FXML
	private CheckBox spinach;
	@FXML
	private CheckBox bananaPeppers;


	private App app;

	public void setApp(App app) {
		this.app = app;
	}

	@FXML
	private void checked(Event event) {
		CheckBox target = (CheckBox) event.getTarget();
		if (target.isSelected())
			app.getCurrentPizza().getOptions().add(target.getText());
		else
			app.getCurrentPizza().getOptions().remove(target.getText());
		app.getViews().getReceiptPreviewController().update();
		System.out.println(app.getCurrentPizza().getOptions());
	}

	@FXML
	private void backButton() {
		app.getViews().getOrderScreenController().setRight(app.getViews().getOrderScreen1());
	}

	@FXML
	private void confirmButton() {
		app.getViews().getOrderScreenController().setRight(app.getViews().getOrderScreen3());
	}

	public void clear() {
		pepperoni.setSelected(false);
		sausage.setSelected(false);
		beef.setSelected(false);
		chicken.setSelected(false);
		bacon.setSelected(false);
		salami.setSelected(false);
		onions.setSelected(false);
		peppers.setSelected(false);
		mushrooms.setSelected(false);
		olives.setSelected(false);
		spinach.setSelected(false);
		bananaPeppers.setSelected(false);
	}
}
