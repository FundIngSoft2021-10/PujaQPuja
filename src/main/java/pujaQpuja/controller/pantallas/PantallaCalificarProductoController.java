package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaCalificarProductoController implements Initializable {

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
    private RadioButton botonRadioBuena;
    @FXML
    private RadioButton botonRadioRegular;
    @FXML
    private RadioButton botonRadioMala;
    @FXML
    private Button botonAceptar;
    @FXML
    private TextField campoOpinionProducto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    private void irAtras(MouseEvent event) {
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
    private void accionAceptar(ActionEvent event) throws IOException {
        if (botonRadioBuena.isSelected() || botonRadioRegular.isSelected() || botonRadioMala.isSelected()) {
            PantallasMenu.abrirPantalla(event, "PantallaExitoCalificar");
        } else {
            PantallasMenu.abrirVentana("PantallaErrorCalificar");
        }
    }

}
