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
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Cristian Da Camara
 */
public class EditarPerfilController implements Initializable {

    @FXML
    private Rectangle botonAtras;
    @FXML
    private Rectangle botonPerfil;
    @FXML
    private Rectangle botonRectanguloAjustes;
    @FXML
    private Rectangle botonRectanguloCategorias;
    @FXML
    private Rectangle botonRectanguloRealizarSubasta;
    @FXML
    private Rectangle botonRectanguloHistorialVentas;
    @FXML
    private Rectangle botonRectanguloHistorialCompras;
    @FXML
    private Rectangle botonRectanguloNotificaciones;
    @FXML
    private Rectangle botonRectanguloMetodoPago;
    @FXML
    private TextField campoCorreo;
    @FXML
    private PasswordField campoPassword;
    @FXML
    private TextField campoNombres;
    @FXML
    private TextField campoApellidos;
    @FXML
    private TextField campoDocumento;
    @FXML
    private TextField campoTelefono;
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
    private void irAtras(MouseEvent event) {
    }

    @FXML
    private void abrirPerfil(MouseEvent event) {
    }

    @FXML
    private void abrirAjustes(MouseEvent event) {
    }

    @FXML
    private void abrirCategorias(MouseEvent event) {
    }

    @FXML
    private void abrirRealizarSubasta(MouseEvent event) {
    }

    @FXML
    private void abrirHistorialVentas(MouseEvent event) {
    }

    @FXML
    private void abrirHistorialCompras(MouseEvent event) {
    }

    @FXML
    private void abrirNotificaciones(MouseEvent event) {
    }

    @FXML
    private void abririMetodoPago(MouseEvent event) {
    }

    @FXML
    private void accionGuardar(ActionEvent event) throws IOException {
        Usuario usuario = new Usuario();

        if (!campoNombres.getText().isBlank()) {
            usuario.setApellidos(campoNombres.getText());
        }
        if (!campoApellidos.getText().isBlank()) {
            usuario.setApellidos(campoApellidos.getText());
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

    @FXML
    private void accionCancelar(ActionEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaHome.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

}
