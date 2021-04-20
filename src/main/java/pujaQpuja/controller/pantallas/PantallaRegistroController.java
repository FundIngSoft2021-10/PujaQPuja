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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pujaQpuja.controller.modelos.UsuarioController;
import pujaQpuja.model.entities.Usuario;
import pujaQpuja.utilities.Utiles;
import pujaQpuja.utilities.PantallasMenu;

/**
 * FXML Controller class
 *
 * @author Cristian Da Camara
 */
public class PantallaRegistroController implements Initializable {

    UsuarioController usuarioController;

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
    private TextField campoNombres;
    @FXML
    private TextField campoApellidos;
    @FXML
    private TextField campoDireccion;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoCorreo;
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
        usuarioController = new UsuarioController();
    }

    @FXML
    private void irAtras(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "inicio.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
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
    private void accionRegistrarse(ActionEvent event) throws IOException {
        Usuario usuario = new Usuario();

        if (campoPassword.getText().equals(campoConfirmarPassword.getText()) && checkAceptarTerminos.isSelected() && Utiles.isNumeric(campoTelefono.getText()) && Utiles.isValid(campoCorreo.getText())) {
            usuario.setNombres(campoNombres.getText());
            usuario.setApellidos(campoApellidos.getText());
            usuario.setCorreo(campoCorreo.getText());
            usuario.setDireccion(campoDireccion.getText());
            usuario.setTelefono(campoTelefono.getText());
            usuario.setPassword(campoPassword.getText());

            if (!usuarioController.buscarPorCorreo(usuario)) {
                usuarioController.crear(usuario);
                Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaExitoRegistro.fxml"));
                Scene errorRegistroScene = new Scene(pantallaErrorParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(errorRegistroScene);
                window.show();
            } else {
                Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaErrorRegistro.fxml"));
                Scene errorRegistroScene = new Scene(pantallaErrorParent);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(errorRegistroScene);
                window.show();
            }
        } else {
            Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaErrorRegistro.fxml"));
            Scene errorRegistroScene = new Scene(pantallaErrorParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(errorRegistroScene);
            window.show();
        }
    }

}
