module pujaQpuja {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens pujaQpuja to javafx.fxml;
    exports pujaQpuja;
}