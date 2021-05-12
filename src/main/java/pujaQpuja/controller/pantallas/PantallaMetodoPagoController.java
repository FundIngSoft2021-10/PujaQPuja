package pujaQpuja.controller.pantallas;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.otros.TipoTarjeta;
import pujaQpuja.utilities.PantallasMenu;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PantallaMetodoPagoController implements Initializable {


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
    private ChoiceBox<TipoTarjeta> desplegableTipoTarjeta;
    @FXML
    private TextField campoNumeroTarjeta;
    @FXML
    private TextField campoFechaExpiracion;
    @FXML
    private TextField campoCodigoSeguridad;
    @FXML
    private TextField campoNombre;
    @FXML
    private TextField campoApellido;
    @FXML
    private TextField campoCiudad;
    @FXML
    private TextField campoDireccion;
    @FXML
    private TextField campoCodigoPostal;
    @FXML
    private TextField campoTelefono;
    @FXML
    private Button botonPagar;


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
    void irAtras(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        desplegableTipoTarjeta.getItems().setAll(TipoTarjeta.values());
    }

    @FXML
    void pagar(ActionEvent event) {

        boolean correcto= false;
        if(        campoApellido.getText()       !=""
                && campoCiudad.getText()         !=""
                && campoCodigoPostal.getText()   != ""
                && campoCodigoSeguridad.getText()!= ""
                && campoFechaExpiracion.getText()!= ""
                && campoNombre.getText()         != ""
                && campoTelefono.getText()       != ""
                && campoDireccion.getText()      != ""
                && campoNumeroTarjeta.getText()  != "")
        {
            correcto = true;
        }
        if(correcto)
             PantallasMenu.abrirPantalla(event,"PantallaExitoPago");
        else
            PantallasMenu.abrirPantalla(event, "PantallaErrorPago");
    }
}
