package swe.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import swe.fabrications.Person;
import swe.launch.App;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem exitItem;

    @FXML
    private BorderPane rootPane;

    private Stage primaryStage;

    private App app;

    private ObservableList<Person> customers;

    @FXML
    private void exit() {
        primaryStage.close();
    }

    public void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public void setCenter(Node parent) {
        rootPane.setCenter(parent);
    }

    public void setApp(App app) {
        this.app = app;
    }

    public ObservableList<Person> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Person> list) {
        customers = FXCollections.observableList(list);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
