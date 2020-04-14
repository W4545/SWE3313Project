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

    private Parent orderScreen3;
    private OrderScreen3Controller orderScreen3Controller;

    private Parent creditDebitScreen;
    private CreditDebitScreenController creditDebitScreenController;

    private Parent endCheckoutScreen;
    private EndCheckoutScreenController endCheckoutScreenController;

    private Parent receiptPreview;
    private ReceiptPreviewController receiptPreviewController;

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
        URL orderScreen3URL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/orderScreen3.fxml"));
        URL creditDebitScreenURL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/creditDebitScreen.fxml"));
        URL endCheckoutScreenURL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/endCheckoutScreen.fxml"));
        URL receiptPreviewURL = Objects.requireNonNull(
                App.class.getClassLoader().getResource("swe/views/receiptPreview.fxml"));

        FXMLLoader loaderRoot = new FXMLLoader(rootURL);
        FXMLLoader loaderLogin = new FXMLLoader(loginURL);
        FXMLLoader loaderNewCustomer = new FXMLLoader(newCustomerURL);
        FXMLLoader LoaderOrderScreen = new FXMLLoader(orderScreenURL);
        FXMLLoader LoaderExistingCustomer = new FXMLLoader(existingCustomerURL);
        FXMLLoader loaderOrderScreen1 = new FXMLLoader(orderScreen1URL);
        FXMLLoader loaderOrderScreen2 = new FXMLLoader(orderScreen2URL);
        FXMLLoader loaderOrderScreen3 = new FXMLLoader(orderScreen3URL);
        FXMLLoader loaderCreditDebitScreen = new FXMLLoader(creditDebitScreenURL);
        FXMLLoader loaderEndCheckoutScreen = new FXMLLoader(endCheckoutScreenURL);
        FXMLLoader loaderReceiptPreview = new FXMLLoader(receiptPreviewURL);

        try {
            root = loaderRoot.load();
            rootController = loaderRoot.getController();
            login = loaderLogin.load();
            loginController = loaderLogin.getController();
            newCustomer = loaderNewCustomer.load();
            newCustomerController = loaderNewCustomer.getController();
            orderScreen = LoaderOrderScreen.load();
            orderScreenController = LoaderOrderScreen.getController();
            existingCustomer = LoaderExistingCustomer.load();
            existingCustomerController = LoaderExistingCustomer.getController();
            orderScreen1 = loaderOrderScreen1.load();
            orderScreen1Controller = loaderOrderScreen1.getController();
            orderScreen2 = loaderOrderScreen2.load();
            orderScreen2Controller = loaderOrderScreen2.getController();
            orderScreen3 = loaderOrderScreen3.load();
            orderScreen3Controller = loaderOrderScreen3.getController();
            creditDebitScreen = loaderCreditDebitScreen.load();
            creditDebitScreenController = loaderCreditDebitScreen.getController();
            endCheckoutScreen = loaderEndCheckoutScreen.load();
            endCheckoutScreenController = loaderEndCheckoutScreen.getController();
            receiptPreview = loaderReceiptPreview.load();
            receiptPreviewController = loaderReceiptPreview.getController();

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
        orderScreen3Controller.setApp(this);
        creditDebitScreenController.setApp(this);
        endCheckoutScreenController.setApp(this);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadFXML();
        initControllers();

        orderScreenController.setRight(receiptPreview);
        orderScreenController.setRight(orderScreen1);
        endCheckoutScreenController.setReceiptPreview(receiptPreview);

        Scene scene = new Scene(root);
        rootController.setPrimaryStage(primaryStage);
        rootController.setCenter(login);

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

    public Parent getOrderScreen3() {
        return orderScreen3;
    }

    public OrderScreen3Controller getOrderScreen3Controller() {
        return orderScreen3Controller;
    }

    public Parent getCreditDebitScreen() {
        return creditDebitScreen;
    }

    public CreditDebitScreenController getCreditDebitScreenController() {
        return creditDebitScreenController;
    }

    public Parent getEndCheckoutScreen() {
        return endCheckoutScreen;
    }

    public EndCheckoutScreenController getEndCheckoutScreenController() {
        return endCheckoutScreenController;
    }

    public Parent getReceiptPreview() {
        return receiptPreview;
    }

    public ReceiptPreviewController getReceiptPreviewController() {
        return receiptPreviewController;
    }
}
