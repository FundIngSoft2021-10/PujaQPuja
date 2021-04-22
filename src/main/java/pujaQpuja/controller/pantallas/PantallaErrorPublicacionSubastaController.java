package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaErrorPublicacionSubastaController implements Initializable {

    private ControladorGeneral controladorGeneral;

    @FXML
    private Text textoNombreProducto;
    @FXML
    private ImageView imagenProducto;
    @FXML
    private Button botonReintentar;
    @FXML
    private Button botonCancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    private void accionReintentar(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    private void accionCancelar(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);
    }
}
