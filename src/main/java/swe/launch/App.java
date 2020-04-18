package swe.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import swe.controllers.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class App extends Application {

    private LoadFXML loadFXML;

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadFXML = new LoadFXML(this);

        loadFXML.loadFXML();
        loadFXML.initControllers();

        loadFXML.getOrderScreenController().setRight(loadFXML.getReceiptPreview());
        loadFXML.getOrderScreenController().setRight(loadFXML.getOrderScreen1());
        loadFXML.getEndCheckoutScreenController().setReceiptPreview(loadFXML.getReceiptPreview());

        Scene scene = new Scene(loadFXML.getRoot());
        loadFXML.getRootController().setPrimaryStage(primaryStage);
        loadFXML.getRootController().setCenter(loadFXML.getLogin());

        primaryStage.setScene(scene);
        // primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("Debugging: Press Esc to exit fullscreen");
        primaryStage.setTitle("Pizza App");
        primaryStage.getIcons().add(new Image("swe/images/logo.png"));

        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    public LoadFXML getViews() {
        return loadFXML;
    }
}
