package swe.fabrications;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class PizzaView extends ItemView {

    private final SimpleStringProperty crust;
    private final SimpleStringProperty size;
    private final SimpleStringProperty sauce;
    private final SimpleStringProperty optionsString;
    private final SimpleDoubleProperty basePrice;
    private final ObservableList<String> options;



    public PizzaView (String crust, String size, String sauce, double price) {
        super("Pizza", price);
        this.crust = new SimpleStringProperty(crust);
        this.size = new SimpleStringProperty(size);
        this.sauce = new SimpleStringProperty(sauce);
        this.optionsString = new SimpleStringProperty("[]");
        options = FXCollections.observableArrayList();
        options.addListener((ListChangeListener<String>) c -> {
            optionsString.set(options.toString());
        });
        this.basePrice = new SimpleDoubleProperty(price);
        this.price.bind(Bindings.createDoubleBinding(() -> basePrice.get() + options.size() * .2, options, basePrice));
        textProperty().unbind();
        textProperty().bind(Bindings.concat(Bindings.format("$%.2f", this.price), " Pizza CRUST=", this.crust, " SIZE=", this.size, " SAUCE=", this.sauce,
                "\n\tOPTIONS=", optionsString));

    }

    public String getCrust() {
        return crust.get();
    }

    public Property<String> crustProperty() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust.set(crust);
    }

    public String getSize() {
        return size.get();
    }

    public Property<String> sizeProperty() {
        return size;
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getSauce() {
        return sauce.get();
    }

    public Property<String> sauceProperty() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce.set(sauce);
    }

    public ObservableList<String> getOptions() {
        return options;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    public double getBasePrice() {
        return basePrice.get();
    }

    public SimpleDoubleProperty basePriceProperty() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice.set(basePrice);
    }
}
