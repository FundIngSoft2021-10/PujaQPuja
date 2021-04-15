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
import pujaQpuja.Utiles;

/**
 * FXML Controller class
 *
 * @author Cristian Da Camara
 */

public class PantallaRegistroController implements Initializable {


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Usuario usuario = new Usuario();
    }

  

    private void registrarse(ActionEvent event) throws IOException {
        Usuario usuario = new Usuario();

        if (campoPassword.getText().equals(campoConfirmarPassword.getText()) && checkAceptarTerminos.isSelected()
                && Utiles.isNumeric(campoTelefono.getText()) && Utiles.isValid(campoCorreo.getText())) {
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
