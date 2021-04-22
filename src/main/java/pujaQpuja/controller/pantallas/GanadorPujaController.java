package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pujaQpuja.controller.modelos.ControladorGeneral;

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
    private void accionContinuar(ActionEvent event) {
    }

}
