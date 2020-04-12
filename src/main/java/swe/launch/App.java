package swe.launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import swe.controllers.*;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class App extends Application {
    private Parent root;
    private RootController rootController;

    private Parent login;
    private LoginController loginController;

    private Parent newCustomer;
    private NewCustomerController newCustomerController;

    private Parent orderScreen;
    private OrderScreenController orderScreenController;

    private Parent existingCustomer;
    private ExistingCustomerController existingCustomerController;

    private void loadFXML() {
        URL rootURL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/root.fxml"));
        URL loginURL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/login.fxml"));
        URL newCustomerURL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/newCustomer.fxml"));
        URL orderScreenURL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/orderScreen.fxml"));
        URL existingCustomerURL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/existingCustomer.fxml"));

        FXMLLoader rootLoader = new FXMLLoader(rootURL);
        FXMLLoader loginLoader = new FXMLLoader(loginURL);
        FXMLLoader newCustomerLoader = new FXMLLoader(newCustomerURL);
        FXMLLoader orderScreenLoader = new FXMLLoader(orderScreenURL);
        FXMLLoader existingCustomerLoader = new FXMLLoader(existingCustomerURL);

        try {
            root = rootLoader.load();
            rootController = rootLoader.getController();
            login = loginLoader.load();
            loginController = loginLoader.getController();
            newCustomer = newCustomerLoader.load();
            newCustomerController = newCustomerLoader.getController();
            orderScreen = orderScreenLoader.load();
            orderScreenController = orderScreenLoader.getController();
            existingCustomer = existingCustomerLoader.load();
            existingCustomerController = existingCustomerLoader.getController();

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to load an FXML file.");
        }
    }

    private void initControllers() {
        rootController.setApp(this);
        loginController.setApp(this);
        newCustomerController.setApp(this);
        orderScreenController.setApp(this);
        existingCustomerController.setApp(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadFXML();
        initControllers();

        Scene scene = new Scene(root);
        rootController.setPrimaryStage(primaryStage);
        rootController.setCenter(login);

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitHint("Debugging: Press Esc to exit fullscreen");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Parent getRoot() {
        return root;
    }

    public RootController getRootController() {
        return rootController;
    }

    public Parent getLogin() {
        return login;
    }

    public LoginController getLoginController() {
        return loginController;
    }

    public Parent getNewCustomer() {
        return newCustomer;
    }

    public NewCustomerController getNewCustomerController() {
        return newCustomerController;
    }

    public Parent getOrderScreen() {
        return orderScreen;
    }

    public OrderScreenController getOrderScreenController() {
        return orderScreenController;
    }

    public Parent getExistingCustomer() {
        return existingCustomer;
    }

    public ExistingCustomerController getExistingCustomerController() {
        return existingCustomerController;
    }
}
