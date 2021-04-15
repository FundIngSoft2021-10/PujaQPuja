module pujaQpuja {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires java.base;
    opens pujaQpuja to javafx.fxml;
    exports pujaQpuja;
    exports pujaQpuja.model;
    exports pujaQpuja.controller;
    exports pujaQpuja.controller.pantallas;
    opens pujaQpuja.controller to javafx.fxml;
    opens pujaQpuja.controller.pantallas to javafx.fxml;
}