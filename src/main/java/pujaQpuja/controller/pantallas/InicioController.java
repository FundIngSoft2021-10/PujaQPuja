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

public class InicioController implements Initializable {

    private ControladorGeneral controladorGeneral;

    @FXML
    private Button botonRegistrarse;
    @FXML
    private Button botonIngresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    private void accionRegistrarse(ActionEvent event) throws IOException {
        PantallasMenu.abrirPantalla(event, "PantallaRegistro");
    }

    @FXML
    private void accionIngresar(ActionEvent event) throws IOException {
        PantallasMenu.abrirPantalla(event, "Ingresar");
    }

}
