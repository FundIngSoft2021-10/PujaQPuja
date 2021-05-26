package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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

public class PantallaRegistroController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    
    

    @FXML
    void abrirQA(MouseEvent event) {
        PantallasMenu.abrirVentana("PantallaPreguntas");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abrirRealizarPregunta(ActionEvent event) {
        PantallasMenu.abrirVentana("PantallaChat");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abrirAjustes(MouseEvent event) {
        PantallasMenu.abrirVentana("PantallaPerfil");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abrirCategorias(MouseEvent event) {
        PantallasMenu.abrirVentana("PantallaSeleccionarCategoria");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abrirHistorialCompras(MouseEvent event) {
        PantallasMenu.abrirVentana("HistorialCompras");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abrirHistorialVentas(MouseEvent event) {
        PantallasMenu.abrirVentana("HistorialVentas");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abrirNotificaciones(MouseEvent event) {
        PantallasMenu.abrirVentana("PantallaNotificaciones");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abrirPerfil(MouseEvent event) {
        PantallasMenu.abrirVentana("PantallaPerfil");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abrirRealizarSubasta(MouseEvent event) {
        PantallasMenu.abrirVentana("PantallaRealizarSubasta");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void abririMetodoPago(MouseEvent event) {
        PantallasMenu.abrirVentana("PantallaMetodoPago");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void accionBuscar(MouseEvent event) {
    }

    @FXML
    void irAtras(MouseEvent event) throws IOException {
        PantallasMenu.abrirVentana("inicio");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    private void accionRegistrarse(ActionEvent event) throws IOException, InterruptedException {
        Usuario usuario = new Usuario();

        if (campoPassword.getText().equals(campoConfirmarPassword.getText()) && checkAceptarTerminos.isSelected() && Utiles.isNumeric(campoTelefono.getText()) && Utiles.isValid(campoCorreo.getText())) {
            usuario.setNombres(campoNombres.getText());
            usuario.setApellidos(campoApellidos.getText());
            usuario.setCorreo(campoCorreo.getText());
            usuario.setDireccion(campoDireccion.getText());
            usuario.setTelefono(campoTelefono.getText());
            usuario.setPassword(campoPassword.getText());

            if (!controladorGeneral.usuarioController.buscarPorCorreo(usuario)) {
                controladorGeneral.usuarioController.crear(usuario);
                PantallasMenu.abrirPantalla(event, "Inicio");
                PantallasMenu.abrirVentana("PantallaExitoRegistro");
            } else {
                PantallasMenu.abrirVentana("PantallaErrorRegistro");
            }
        } else {
            PantallasMenu.abrirVentana("PantallaErrorRegistro");
        }
    }

    private void abrirInicio(Event event) {
        PantallasMenu.abrirPantalla(event, "Inicio");
    }

}
