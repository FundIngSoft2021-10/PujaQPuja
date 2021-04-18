module pujaQpuja {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires java.base;

    exports pujaQpuja;
    exports pujaQpuja.utilities;
    exports pujaQpuja.controller;
    exports pujaQpuja.controller.pantallas;
    exports pujaQpuja.model.entities;
    exports pujaQpuja.model.entities.otros;
    exports pujaQpuja.model.repository;

    opens pujaQpuja to javafx.fxml;
    opens pujaQpuja.utilities to javafx.fxml;
    opens pujaQpuja.controller to javafx.fxml;
    opens pujaQpuja.controller.pantallas to javafx.fxml;
    opens pujaQpuja.model.entities to javafx.fxml;
    opens pujaQpuja.model.repository to javafx.fxml;
    opens pujaQpuja.model.entities.otros to javafx.fxml;
}