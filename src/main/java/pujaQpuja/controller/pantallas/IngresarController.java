package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pujaQpuja.controller.modelos.AutenticacionController;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IngresarController implements Initializable {

    private AutenticacionController autenticacionController;

    @FXML
    private TextField campoCorreo;
    @FXML
    private PasswordField campoPassword;
    @FXML
    private Button botonIngresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        autenticacionController = new AutenticacionController();
    }

    @FXML
    private void accionIngresar(ActionEvent event) throws IOException {

        String correo = campoCorreo.getText();
        String contra = campoPassword.getText();

        if (correo != null && contra != null) {
            if (autenticacionController.iniciarSesion(correo, contra)) {
                PantallasMenu.abrirPantalla(event, "PantallaSeleccionarCategoria");
            } else {
                PantallasMenu.abrirVentana("ErrorAutenticar");
            }
        }
    }
}
