module pujaQpuja {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires com.gluonhq.charm.glisten;
    requires java.base;
    opens pujaQpuja to javafx.fxml;
    exports pujaQpuja;
    exports pujaQpuja.controller;
    opens pujaQpuja.controller to javafx.fxml;
    exports pujaQpuja.controller.pantallas;
    opens pujaQpuja.controller.pantallas to javafx.fxml;
    exports pujaQpuja.model;
    opens pujaQpuja.model to javafx.fxml;
}