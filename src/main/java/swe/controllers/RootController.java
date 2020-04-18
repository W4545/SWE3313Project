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
    private BorderPane rootPane;

    private Stage primaryStage;

    private App app;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
