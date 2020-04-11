package swe.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import swe.controllers.TestController;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class App extends Application {
    private Parent test;
    private TestController testController;

    private void loadFXML() {
        URL testURL = Objects.requireNonNull(App.class.getClassLoader().getResource("swe/views/root.fxml"));
        FXMLLoader loader1 = new FXMLLoader(testURL);
        try {
            test = loader1.load();
            testController = loader1.getController();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load root.fxml");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadFXML();

        Scene scene = new Scene(test);
        testController.setPrimaryStage(primaryStage);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("Debugging: Press Esc to exit fullscreen");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
