package swe.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class App extends Application {
    private Parent test;

    private void loadFXML() {
        URL testURL = Objects.requireNonNull(App.class.getClassLoader().getResource("swe/views/test.fxml"));
        FXMLLoader loader1 = new FXMLLoader(testURL);
        try {
            test = loader1.load();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load test.fxml");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadFXML();

        Scene scene = new Scene(test);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
