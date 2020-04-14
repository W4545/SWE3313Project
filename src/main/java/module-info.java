module SWEProject.main {
    requires javafx.controls;
    requires javafx.fxml;

    opens swe.views;
    opens swe.images;
    opens swe.controllers to javafx.fxml;

    exports swe.launch;
    exports swe.controllers;
}