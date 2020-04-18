package swe.launch;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import swe.fabrications.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App extends Application {

    private LoadFXML loadFXML;

    @Override
    public void start(Stage primaryStage) {
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

    private void loadCustomers() {
        try {
            Scanner scanner = new Scanner(new File("customers.txt"));
            List<String> rawLines = new ArrayList<>();
            List<Person> customers = new ArrayList<>();

            while (scanner.hasNextLine())
                rawLines.add(scanner.nextLine());
            // String.format("%s&AS&%s&AS&%s&AS&%s", customerID.get(), name.get(), address.get(), paymentMethod.get());
            rawLines.forEach(line -> {
                String[] items = line.split("&AS&");
                if (items.length == 4)
                    customers.add(new Person(items[0], items[1], items[2], items[3]));
            });

            loadFXML.getRootController().setCustomers(customers);

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
}
