package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pujaQpuja.model.Usuario;

/**
 * FXML Controller class
 *
 * @author Cristian Da Camara
 */

public class PantallaRegistroController implements Initializable {

    @FXML
    private TextField campoNombreApellido;
    @FXML
    private TextField campoCorreo;
    @FXML
    private TextField campoDireccion;
    @FXML
    private TextField campoTelefono;
    @FXML
    private PasswordField campoPassword;
    @FXML
    private PasswordField campoConfirmarPassword;
    @FXML
    private CheckBox checkAceptarTerminos;
    @FXML
    private Button botonRegistrarse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Usuario usuario = new Usuario();
    }

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    @FXML
    private void registrarse(ActionEvent event) throws IOException {
        Usuario usuario = new Usuario();

        if (campoPassword.getText().equals(campoConfirmarPassword.getText()) && checkAceptarTerminos.isSelected()
                && isNumeric(campoTelefono.getText()) && isValid(campoCorreo.getText())) {
            usuario.setApellidos(campoNombreApellido.getText());
            usuario.setCorreo(campoCorreo.getText());
            usuario.setDireccion(campoDireccion.getText());
            usuario.setTelefono(campoTelefono.getText());
            usuario.setPassword(campoPassword.getText());
            System.out.println("holiwi");

            Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaExitoRegistro.fxml"));
            Scene errorRegistroScene = new Scene(pantallaErrorParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(errorRegistroScene);
            window.show();

        } else {
            Parent pantallaErrorParent = FXMLLoader
                    .load(getClass().getResource("/view/" + "PantallaErrorRegistro.fxml"));
            Scene errorRegistroScene = new Scene(pantallaErrorParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(errorRegistroScene);
            window.show();
        }
    }

}
