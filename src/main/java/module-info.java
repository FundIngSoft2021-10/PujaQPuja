module pujaQpuja {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    requires com.gluonhq.charm.glisten;
    requires java.base;
    opens pujaQpuja to javafx.fxml;
    exports pujaQpuja;
}