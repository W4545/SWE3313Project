package swe.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import swe.launch.App;

import java.net.URL;
import java.util.ResourceBundle;

public class EndCheckoutScreenController implements Initializable {

    @FXML
    private Button receiptButton;

    @FXML
    private Button exitButton;

    @FXML
    private GridPane gridPane;

    private App app;


    public void setApp(App app) {
        this.app = app;
    }

    public void setReceiptPreview(Parent parent) {
        if (gridPane.getChildren().size() > 4) {
            gridPane.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 1);
        }
        gridPane.add(parent, 0, 1, 2, 1);
    }

    @FXML
    private void exitButton() {
        app.getViews().getRootController().newOrder();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exitButton.prefWidthProperty().bind(receiptButton.widthProperty());
    }
}
