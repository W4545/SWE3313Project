package swe.fabrications;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;

public class ItemView extends Label implements Food {
    protected final SimpleDoubleProperty price;
    protected final SimpleStringProperty item;

    public ItemView(String item, double price) {
        this.price = new SimpleDoubleProperty(price);
        this.item = new SimpleStringProperty(item);
        setWrapText(true);
        textProperty().bind(Bindings.format("$%.2f %s", this.price, this.item));
    }

    @Override
    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getItem() {
        return item.get();
    }

    public SimpleStringProperty itemProperty() {
        return item;
    }

    public void setItem(String item) {
        this.item.set(item);
    }
}
