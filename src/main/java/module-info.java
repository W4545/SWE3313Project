module SWEProject.main {
    requires javafx.controls;
    requires javafx.fxml;

    opens swe.views;
    opens swe.images;
    opens swe.controllers to javafx.fxml;
    opens swe.fabrications to javafx.fxml, javafx.base;

    exports swe.launch;
    exports swe.controllers;
}