package swe.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class OrderScreen3Controller implements Initializable {

    private App app;

    @FXML
    private Button debitCreditButton;

    @FXML
    private Button cashButton;

    @FXML
    private void creditDebit() {
        app.getOrderScreenController().setRight(app.getCreditDebitScreen());
    }


    public void setApp(App app) {
        this.app = app;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cashButton.prefWidthProperty().bind(debitCreditButton.widthProperty());
    }
}
