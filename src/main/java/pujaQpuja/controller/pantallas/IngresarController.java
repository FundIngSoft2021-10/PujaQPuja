package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IngresarController implements Initializable {

    private ControladorGeneral controladorGeneral;

    @FXML
    private TextField campoCorreo;
    @FXML
    private PasswordField campoPassword;
    @FXML
    private Button botonIngresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    private void accionIngresar(ActionEvent event) throws IOException {

        String correo = campoCorreo.getText();
        String contra = campoPassword.getText();

        if (correo != null && contra != null) {
            if (controladorGeneral.autenticacionController.iniciarSesion(correo, contra)) {
                PantallasMenu.abrirVentana("PantallaSeleccionarCategoria");
                PantallasMenu.cerrarPantalla(event);
            } else {
                PantallasMenu.abrirVentana("ErrorAutenticar");
            }
        }
    }
}
  
   

    