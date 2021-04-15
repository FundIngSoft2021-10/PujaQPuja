package pujaQpuja.controller.pantallas;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

public class PantallaExitoController {

    @FXML
    private Button botonRegresar;

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "inicio.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

}
