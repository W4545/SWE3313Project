package swe.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem exitItem;

    @FXML
    private MenuItem newOrder;

    @FXML
    private MenuItem logOut;

    @FXML
    private BorderPane rootPane;

    private Stage primaryStage;

    private App app;

    @FXML
    private void exit() {
        primaryStage.close();
    }

    @FXML
    public void newOrder() {
        app.getViews().getRootController().setCenter(app.getViews().getNewCustomer());
        app.setCurrentItem(null);
        app.setCurrentPizza(null);
        app.getViews().getOrderScreen1Controller().clear();
        app.getViews().getOrderScreen2Controller().clear();
        app.getViews().getReceiptPreviewController().getVBox().getChildren().clear();
        app.getViews().getReceiptPreviewController().update();
        app.getViews().getOrderScreenController().setLeft(app.getViews().getReceiptPreview());
        app.getViews().getOrderScreenController().setRight(app.getViews().getOrderScreen1());
        app.getViews().getExistingCustomerController().clear();
        app.getViews().getNewCustomerController().clear();
    }

    @FXML
    private void logout() {
        newOrder();
        app.setLoggedIn(false);
        app.getViews().getRootController().setCenter(app.getViews().getLogin());
    }

    public void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public void setCenter(Node parent) {
        rootPane.setCenter(parent);
    }

    public void setApp(App app) {
        this.app = app;
        newOrder.disableProperty().bind(app.loggedInProperty().not());
        logOut.disableProperty().bind(app.loggedInProperty().not());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
