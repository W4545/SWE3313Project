package swe.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class TestController {

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem exitItem;

    private Stage primaryStage;

    @FXML
    private void exit() {
        primaryStage.close();
    }

    public void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

}
