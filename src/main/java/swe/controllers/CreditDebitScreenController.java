package swe.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import swe.launch.App;

public class CreditDebitScreenController {

    @FXML
    private TextField monthField;
    @FXML
    private TextField yearField;
    private App app;


    @FXML
    private void confirm() {
        app.getEndCheckoutScreenController().setReceiptPreview(app.getReceiptPreview());
        app.getRootController().setCenter(app.getEndCheckoutScreen());
    }

    public void setApp(App app) {
        this.app = app;
    }
}
