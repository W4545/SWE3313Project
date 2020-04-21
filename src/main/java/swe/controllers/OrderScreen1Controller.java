package swe.controllers;

// Name: Jack Young
// Date: 4/13/2020

import javafx.beans.property.Property;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import swe.fabrications.ItemView;
import swe.fabrications.PizzaView;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderScreen1Controller implements Initializable {



	private App app;

	@FXML
	private ToggleGroup crustToggleGroup;
	@FXML
	private ToggleGroup sizeToggleGroup;
	@FXML
	private ToggleGroup sauceToggleGroup;
	@FXML
	private ToggleGroup drinkToggleGroup;

	@FXML
	private CheckBox smallCheckBox;

	@FXML
	private CheckBox mediumCheckBox;

	@FXML
	private CheckBox largeCheckBox;

	@FXML
	private CheckBox cookieCheckBox;

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
		cookieCheckBox.setDisable(!cookieCheckBox.isDisabled());
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
		cookieCheckBox.setDisable(!cookieCheckBox.isDisabled());
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
		cookieCheckBox.setDisable(!cookieCheckBox.isDisabled());
		if (!disableDrinkBox.getValue()) {
			disableSmall.setValue(true);
			disableMedium.setValue(true);
		} else {
			disableSmall.setValue(false);
			disableMedium.setValue(false);
		}
	}

	@FXML
	private void cookie() {
		disableSmall.setValue(!disableSmall.getValue());
		disableMedium.setValue(!disableMedium.getValue());
		disableLarge.setValue(!disableLarge.getValue());
	}

	private boolean isPizza() {
		return crustToggleGroup.getSelectedToggle() != null ||
				sizeToggleGroup.getSelectedToggle() != null ||
				sauceToggleGroup.getSelectedToggle() != null;
	}

	private boolean pizzaValidated() {
		return crustToggleGroup.getSelectedToggle() != null &&
				sizeToggleGroup.getSelectedToggle() != null &&
				sauceToggleGroup.getSelectedToggle() != null;
	}

	private boolean isDrink() {
		return smallCheckBox.isSelected() || mediumCheckBox.isSelected() || largeCheckBox.isSelected();
	}

	public void clear() {
		crustToggleGroup.selectToggle(null);
		sizeToggleGroup.selectToggle(null);
		sauceToggleGroup.selectToggle( null);
		drinkToggleGroup.selectToggle(null);
		disableSmall.setValue(false);
		disableMedium.setValue(false);
		disableLarge.setValue(false);
		disableDrinkBox.setValue(true);
		smallCheckBox.setSelected(false);
		mediumCheckBox.setSelected(false);
		largeCheckBox.setSelected(false);
		cookieCheckBox.setSelected(false);
		cookieCheckBox.setDisable(false);
	}

	private Pair<String, Double> getDrinkOrder() {
		String order = ((RadioButton) drinkToggleGroup.getSelectedToggle()).getText();
		double price;
		if (smallCheckBox.isSelected()) {
			price = 1.00;
			order = "Small " + order;
		} else if (mediumCheckBox.isSelected()) {
			price = 1.50;
			order = "Medium " + order;
		} else {
			price = 2.00;
			order = "Large " + order;
		}
		return new Pair<>(order, price);
	}

	private double getPrice(String size) {
		return switch (size.charAt(0)) {
			case 'S' -> 10.00;
			case 'M' -> 14.00;
			case 'L' -> 18.00;
			case 'X' -> 22.00;
			default -> throw new IllegalStateException("Unexpected value: " + size.charAt(0));
		};
	}

	private void newItems() {
		PizzaView pizza;
		if (isPizza() && !pizzaValidated()) {
			new Alert(Alert.AlertType.ERROR, "Please fill all bubbles in pizza section.", ButtonType.OK).show();
		} else if (isPizza() && pizzaValidated()) {
			String crust = ((RadioButton) crustToggleGroup.getSelectedToggle()).getText();
			String size = ((RadioButton) sizeToggleGroup.getSelectedToggle()).getText();
			size = size.substring(0, size.indexOf(' '));
			String sauce = ((RadioButton) sauceToggleGroup.getSelectedToggle()).getText();
			System.out.println(crust + size + sauce);
			double cost = getPrice(size);
			pizza = new PizzaView(crust, size, sauce, cost);
			app.setCurrentPizza(pizza);
			app.getViews().getReceiptPreviewController().getVBox().getChildren().add(pizza);
		}

		setDrink();
	}

	private boolean updateItems() {
		if (app.getCurrentPizza() != null) {
			if (!pizzaValidated())
				return false;
			app.getCurrentPizza().setCrust(((RadioButton) crustToggleGroup.getSelectedToggle()).getText());
			String size = ((RadioButton) sizeToggleGroup.getSelectedToggle()).getText();
			size = size.substring(0, size.indexOf(' '));
			app.getCurrentPizza().setSize(size);
			app.getCurrentPizza().setSauce(((RadioButton) sauceToggleGroup.getSelectedToggle()).getText());
			app.getCurrentPizza().basePriceProperty().set(getPrice(size));
		}
		if (app.getCurrentItem() != null) {
			if (isDrink()) {
				Pair<String, Double> pair = getDrinkOrder();
				app.getCurrentItem().setItem(pair.getKey());
				app.getCurrentItem().setPrice(pair.getValue());
			} else if (cookieCheckBox.isSelected()) {
				app.getCurrentItem().setItem("Cookie");
				app.getCurrentItem().setPrice(2.00);
			} else {
				app.getViews().getReceiptPreviewController().getVBox().getChildren().remove(app.getCurrentItem());
				app.setCurrentItem(null);
			}
		} else {
			setDrink();
		}

		return true;
	}

	private void setDrink() {
		if (isDrink()) {
			Pair<String, Double> pair = getDrinkOrder();
			ItemView itemView = new ItemView(pair.getKey(), pair.getValue());
			app.setCurrentItem(itemView);
			app.getViews().getReceiptPreviewController().getVBox().getChildren().add(itemView);
		} else if (cookieCheckBox.isSelected()) {
			ItemView itemView = new ItemView("Cookie", 2.00);
			app.setCurrentItem(itemView);
			app.getViews().getReceiptPreviewController().getVBox().getChildren().add(itemView);
		}
	}

	@FXML
	private void nextButton() {
		if (app.getCurrentItem() == null && app.getCurrentPizza() == null)
			newItems();
		else {
			boolean success = updateItems();
			if (!success) {
				new Alert(Alert.AlertType.ERROR, "Please fill all bubbles in pizza section.").show();
				return;
			}
		}
		app.getViews().getReceiptPreviewController().update();

		if (app.getCurrentPizza() != null)
			app.getViews().getOrderScreenController().setRight(app.getViews().getOrderScreen2());
		else if (app.getCurrentItem() != null)
			app.getViews().getOrderScreenController().setRight(app.getViews().getOrderScreen3());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		drinkBox.disableProperty().bind(disableDrinkBox);
		smallCheckBox.disableProperty().bind(disableSmall);
		mediumCheckBox.disableProperty().bind(disableMedium);
		largeCheckBox.disableProperty().bind(disableLarge);
	}
}
