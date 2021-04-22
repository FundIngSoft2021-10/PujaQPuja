package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaErrorRegistroController implements Initializable {

    private ControladorGeneral controladorGeneral;

    @FXML
    private Button botonRegresar;
    @FXML
    private Button botonCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    private void accionRegresar(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    private void accionCancelar(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);
    }

}
