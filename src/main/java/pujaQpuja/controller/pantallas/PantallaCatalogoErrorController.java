package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaCatalogoErrorController implements Initializable {

    @FXML
    private Button botonAceptar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void accionAceptar(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);
    }

}
