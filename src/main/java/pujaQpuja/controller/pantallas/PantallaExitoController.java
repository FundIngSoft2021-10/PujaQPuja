package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;

public class PantallaExitoController {

    @FXML
    private Button botonRegresar;

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);
    }

}
