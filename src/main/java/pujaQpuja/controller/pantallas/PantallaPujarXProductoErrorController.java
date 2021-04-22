package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaPujarXProductoErrorController implements Initializable {

    @FXML
    private Button botonRegresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);
    }

}
