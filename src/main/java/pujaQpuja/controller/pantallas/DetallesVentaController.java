package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.utilities.PantallasMenu;

public class DetallesVentaController implements Initializable {

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
    private Rectangle botonRectanguloCate3gorias;
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
    private ImageView imagenProducto;
    @FXML
    private TextField campoNombreProducto;
    @FXML
    private TextField campoPrecio;
    @FXML
    private TextField campoDescripcion;
    @FXML
    private TextField campoNombreComprador;
    @FXML
    private Button botonTableroDePreguntas;
    @FXML
    private Button botonEditarProducto;
    @FXML
    private Button botonEliminarProducto;
    @FXML
    private Rectangle botonRectanguloMasInformacion;
    @FXML
    private Rectangle botonRectanguloQA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
        autenticacionController = AutenticacionController.getInstance();
        campoNombreProducto.setText(autenticacionController.getTemporalVisualizada().getProducto().getNombre());
        campoDescripcion.setText(autenticacionController.getTemporalVisualizada().getProducto().getDescripcion());
        imagenProducto.setImage(autenticacionController.getTemporalVisualizada().getProducto().getFoto());
        campoPrecio.setText(String.valueOf(autenticacionController.getTemporalVisualizada().getPrecioFinal()));
        /*campoNombreComprador.setText(autenticacionController.getTemporalVisualizada().getComprador().getNombres() +" "
                                     + autenticacionController.getTemporalVisualizada().getComprador().getApellidos());*/

        rutaImagen = "";
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
        PantallasMenu.abrirVentana("HistorialVentas");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    private void abrirTableroDePreguntas(ActionEvent event) {
        PantallasMenu.abrirVentana("PreguntasPuja");
        PantallasMenu.cerrarPantalla(event);

    }

    @FXML
    private void abrirEditarProducto(ActionEvent event) {
        PantallasMenu.abrirVentana("PantallaModificarSubasta");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    private void abrirMasInformacion(MouseEvent event) {

    }

    @FXML
    void abrirPausarProducto(ActionEvent event) {
        long idPuja =  autenticacionController.getTemporalVisualizada().getId();
        if(controladorGeneral.pujaController.pausarPuja(idPuja)) {
            //PantallasMenu.abrirVentana("PantallaExitoPausarPuja");
        }
        else{
            //PantallasMenu.abrirVentana("PantallaErrorPausarPuja");
        }

    }

    @FXML
    void abrirReanudarProducto(ActionEvent event) {
        long idPuja =  autenticacionController.getTemporalVisualizada().getId();
        if(controladorGeneral.pujaController.reanudarPuja(idPuja)){
            //PantallasMenu.abrirVentana("PantallaExitoReanudarPuja");
        }
        else{
            //PantallasMenu.abrirVentana("PantallaErrorReanudarPuja");
        }
    }

    @FXML
    private void abrirEliminarProducto(ActionEvent event) {
        long idPujaAEliminar = autenticacionController.getTemporalVisualizada().getId();
        long idProductoAEliminar = autenticacionController.getTemporalVisualizada().getProducto().getId();

        controladorGeneral.productoController.eliminarProducto(idProductoAEliminar);
        controladorGeneral.pujaController.eliminarPuja(idPujaAEliminar);
        if(controladorGeneral.productoController.eliminarProducto(idProductoAEliminar) && controladorGeneral.pujaController.eliminarPuja(idPujaAEliminar))
        {
            PantallasMenu.abrirVentana("PantallaConfirmacionEliminarPuja");
        }else{
            //PantallasMenu.abrirVentana("PantallaErrorEliminarProducto");
        }

    }

}
