package swe.launch;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import swe.fabrications.Person;

import java.io.*;
import java.util.Scanner;

public class App extends Application {

    private LoadFXML loadFXML;

    private ObservableList<Person> customers;

    public static final boolean DEV_MODE = true;

    @Override
    public void start(Stage primaryStage) {
        loadCustomers();
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
        if (DEV_MODE) {
            primaryStage.setMaximized(true);
        } else {
            primaryStage.setFullScreen(true);
            primaryStage.setFullScreenExitHint("Debugging: Press Esc to exit fullscreen");
        }

        primaryStage.setTitle("Pizza App");
        primaryStage.getIcons().add(new Image("swe/images/logo.png"));

        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Writing customers to file");
        writeCustomers(customers);
        super.stop();
    }

    public static void main(String[] args) {

        launch(args);
    }

    public void loadCustomers() {
        customers = FXCollections.observableArrayList();
        try {
            Scanner scanner = new Scanner(new File("customers.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] items = line.split("&AS&");
                if (items.length == 4)
                    customers.add(new Person(items[0], items[1], items[2], items[3]));
            }
            // String.format("%s&AS&%s&AS&%s&AS&%s", customerID.get(), name.get(), address.get(), paymentMethod.get());

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void writeCustomers(ObservableList<Person> list) {
        try {
            FileWriter fileWriter = new FileWriter(new File("customers.txt"));
            for (Person person : list) {
                fileWriter.write(person.toString());
                fileWriter.write('\n');
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public LoadFXML getViews() {
        return loadFXML;
    }

    public ObservableList<Person> getCustomers() {
        return customers;
    }
}
