package swe.controllers;

// Name: Jack Young
// Date: 4/13/2020

import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderScreen1Controller implements Initializable {

	private App app;

	@FXML
	private ToggleGroup crustToggleGroup;

	@FXML
	private CheckBox smallCheckBox;

	@FXML
	private CheckBox mediumCheckBox;

	@FXML
	private CheckBox largeCheckBox;

	@FXML
	private VBox drinkBox;

	private final Property<Boolean> disableDrinkBox = new SimpleBooleanProperty(true);

	private final Property<Boolean> disableSmall = new SimpleBooleanProperty(false);

	private final Property<Boolean> disableMedium = new SimpleBooleanProperty(false);

	private final Property<Boolean> disableLarge = new SimpleBooleanProperty(false);

	public void setApp(App app) {
		this.app = app;
	}

	@FXML
	void small() {
		disableDrinkBox.setValue(!disableDrinkBox.getValue());
		if (!disableDrinkBox.getValue()) {
			disableMedium.setValue(true);
			disableLarge.setValue(true);
		} else {
			disableMedium.setValue(false);
			disableLarge.setValue(false);
		}
	}

	@FXML
	void medium() {
		disableDrinkBox.setValue(!disableDrinkBox.getValue());
		if (!disableDrinkBox.getValue()) {
			disableSmall.setValue(true);
			disableLarge.setValue(true);
		} else {
			disableSmall.setValue(false);
			disableLarge.setValue(false);
		}
	}

	@FXML
	void large() {
		disableDrinkBox.setValue(!disableDrinkBox.getValue());
		if (!disableDrinkBox.getValue()) {
			disableSmall.setValue(true);
			disableMedium.setValue(true);
		} else {
			disableSmall.setValue(false);
			disableMedium.setValue(false);
		}
	}

	@FXML
	private void nextButton() {
		app.getViews().getOrderScreenController().setRight(app.getViews().getOrderScreen2());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		drinkBox.disableProperty().bind(disableDrinkBox);
		smallCheckBox.disableProperty().bind(disableSmall);
		mediumCheckBox.disableProperty().bind(disableMedium);
		largeCheckBox.disableProperty().bind(disableLarge);
	}
}
