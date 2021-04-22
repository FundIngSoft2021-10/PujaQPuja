package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaErrorCalificarController implements Initializable {

    private ControladorGeneral controladorGeneral;

    @FXML
    private Text textoCalificar;
    @FXML
    private TextArea campoConfirmacion;
    @FXML
    private ImageView imagenProducto;
    @FXML
    private Button botonAceptar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    void accionAceptar(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);
    }

}
