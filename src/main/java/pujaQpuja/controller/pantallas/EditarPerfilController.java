package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.Usuario;
import pujaQpuja.utilities.PantallasMenu;
import pujaQpuja.utilities.Utiles;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditarPerfilController implements Initializable {

    private ControladorGeneral controladorGeneral;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        controladorGeneral = new ControladorGeneral();
        campoCorreo.setText(controladorGeneral.autenticacionController.getAutenticado().getCorreo());
        campoNombres.setText(controladorGeneral.autenticacionController.getAutenticado().getNombres());
        campoApellidos.setText(controladorGeneral.autenticacionController.getAutenticado().getApellidos());
        campoTelefono.setText(controladorGeneral.autenticacionController.getAutenticado().getTelefono());
        campoDocumento.setText(controladorGeneral.autenticacionController.getAutenticado().getDocumento());
        campoDireccion.setText(controladorGeneral.autenticacionController.getAutenticado().getDireccion());
    }

    @FXML
    private void irAtras(MouseEvent event) throws IOException {
        PantallasMenu.abrirPantalla(event, "PantallaPerfil");
    }

    @FXML
    private void abrirPerfil(MouseEvent event) {
        PantallasMenu.abrirPerfil(event);
    }

    @FXML
    private void abrirAjustes(MouseEvent event) {
        PantallasMenu.abrirAjustes(event);
    }

    @FXML
    private void abrirCategorias(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
    }

    @FXML
    private void abrirRealizarSubasta(MouseEvent event) {
        PantallasMenu.abrirRealizarSubasta(event);
    }

    @FXML
    private void abrirHistorialVentas(MouseEvent event) {
        PantallasMenu.abrirHistorialVentas(event);
    }

    @FXML
    private void abrirHistorialCompras(MouseEvent event) {
        PantallasMenu.abrirHistorialCompras(event);
    }

    @FXML
    private void abrirNotificaciones(MouseEvent event) {
        PantallasMenu.abrirNotificaciones(event);
    }

    @FXML
    private void abririMetodoPago(MouseEvent event) {
        PantallasMenu.abririMetodoPago(event);
    }

    @FXML
    private void accionGuardar(ActionEvent event) throws IOException {
        Usuario usuario = controladorGeneral.autenticacionController.getAutenticado();

        if (!campoNombres.getText().isBlank()) {
            usuario.setNombres(campoNombres.getText());
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

        controladorGeneral.usuarioController.modificar(usuario);
        controladorGeneral.autenticacionController.setAutenticado(usuario);

        PantallasMenu.abrirPantalla(event, "PantallaSeleccionarCategoria");
    }

    @FXML
    private void accionCancelar(ActionEvent event) throws IOException {
        PantallasMenu.abrirPantalla(event, "PantallaSeleccionarCategoria");
    }

}
