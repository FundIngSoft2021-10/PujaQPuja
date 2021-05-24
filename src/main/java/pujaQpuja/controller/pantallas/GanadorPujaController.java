package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class GanadorPujaController implements Initializable {

    private ControladorGeneral controladorGeneral;

    @FXML
    private Button botonMasTarde;
    @FXML
    private Button botonContinuar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    private void accionMasTarde(ActionEvent event) {
    }

    @FXML
    private void accionContinuar(MouseEvent event) {
        PantallasMenu.abririMetodoPago(event);
    }

}
