/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import pujaQpuja.Utiles;
import pujaQpuja.model.Usuario;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

/**
 * FXML Controller class
 *
 * @author Cristian Da Camara
 */
public class EditarPerfilController implements Initializable {

    @FXML
    private PasswordField campoPassword;
    @FXML
    private TextField campoCorreo;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoDocumento;
    @FXML
    private TextField campoNombreApellido;
    @FXML
    private TextField campoDireccion;
    @FXML
    private Button botonGuardar;
    @FXML
    private Button botonCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    public void accionAbrirMenu(MouseEvent mouseEvent) {

    }

    void cancelar(ActionEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaHome.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    void guardar(ActionEvent event) throws IOException {
        Usuario usuario = new Usuario();

        if (!campoNombreApellido.getText().isBlank()) {
            usuario.setApellidos(campoNombreApellido.getText());
        }
        if (!campoCorreo.getText().isBlank() && Utiles.isValid(campoCorreo.getText())) {
            usuario.setCorreo(campoCorreo.getText());
        }
        if (!campoPassword.getText().isBlank()) {
            usuario.setPassword(campoPassword.getText());
        }
        if (!campoDocumento.getText().isBlank()) {
            usuario.setDocumento(campoDocumento.getText());
        }
        if (!campoTelefono.getText().isBlank() && Utiles.isNumeric(campoTelefono.getText())) {
            usuario.setTelefono(campoTelefono.getText());
        }
        if (!campoDireccion.getText().isBlank()) {
            usuario.setDireccion(campoDireccion.getText());
        }

        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaHome.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

}
