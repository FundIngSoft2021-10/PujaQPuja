package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import pujaQpuja.controller.modelos.AutenticacionController;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class DetallesCompraController implements Initializable {

    private ControladorGeneral controladorGeneral;
    private String rutaImagen;
    private AutenticacionController autenticacionController;

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
    private Rectangle botonRectanguloQA;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private TextField campoNombreProducto;

    @FXML
    private TextField campoPrecio;

    @FXML
    private TextField campoDescripcion;

    @FXML
    private Button botonCalificar;

    @FXML
    private Button botonRegresar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
        autenticacionController = AutenticacionController.getInstance();
        campoNombreProducto.setText(autenticacionController.getTemporalVisualizada().getProducto().getNombre());
        campoDescripcion.setText(autenticacionController.getTemporalVisualizada().getProducto().getDescripcion());
        imagenProducto.setImage(autenticacionController.getTemporalVisualizada().getProducto().getFoto());
        campoPrecio.setText(String.valueOf(autenticacionController.getTemporalVisualizada().getPrecioFinal()));

        rutaImagen = "";
    }

    @FXML
    void abrirCalificacion(ActionEvent event) {
        PantallasMenu.abrirPantalla(event,"PantallaCalificarProducto");
    }

    @FXML
    void abrirRegresar(ActionEvent event) {
        PantallasMenu.abrirPantalla(event,"HistorialCompras");
    }

    @FXML
    private void irAtras(MouseEvent event) {
        PantallasMenu.abrirHistorialCompras(event);
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
    void abrirQA(MouseEvent event) {
        PantallasMenu.abrirQA(event);
    }

}
