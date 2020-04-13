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

    private Parent orderScreen1;
    private OrderScreen1Controller orderScreen1Controller;

    private Parent orderScreen2;
    private OrderScreen2Controller orderScreen2Controller;

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
        URL orderScreen1URL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/orderScreen1.fxml"));
        URL orderScreen2URL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/orderScreen2.fxml"));

        FXMLLoader rootLoader = new FXMLLoader(rootURL);
        FXMLLoader loginLoader = new FXMLLoader(loginURL);
        FXMLLoader newCustomerLoader = new FXMLLoader(newCustomerURL);
        FXMLLoader orderScreenLoader = new FXMLLoader(orderScreenURL);
        FXMLLoader existingCustomerLoader = new FXMLLoader(existingCustomerURL);
        FXMLLoader orderScreen1Loader = new FXMLLoader(orderScreen1URL);
        FXMLLoader orderScreen2Loader = new FXMLLoader(orderScreen2URL);

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
            orderScreen1 = orderScreen1Loader.load();
            orderScreen1Controller = orderScreen1Loader.getController();
            orderScreen2 = orderScreen2Loader.load();
            orderScreen2Controller = orderScreen2Loader.getController();

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
        orderScreen1Controller.setApp(this);
        orderScreen2Controller.setApp(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadFXML();
        initControllers();

        orderScreenController.setRight(orderScreen1);

        Scene scene = new Scene(root);
        rootController.setPrimaryStage(primaryStage);
        rootController.setCenter(login);

        primaryStage.setScene(scene);
        // primaryStage.setFullScreen(true);
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

    public Parent getOrderScreen1() {
        return orderScreen1;
    }

    public OrderScreen1Controller getOrderScreen1Controller() {
        return orderScreen1Controller;
    }

    public Parent getOrderScreen2() {
        return orderScreen2;
    }

    public OrderScreen2Controller getOrderScreen2Controller() {
        return orderScreen2Controller;
    }
}
