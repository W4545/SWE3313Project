package swe.controllers;

import javafx.fxml.FXML;
import swe.launch.App;

public class CreditDebitScreenController {

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
