package pujaQpuja.controller.pantallas;

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
    private void irAtras(MouseEvent event) {
        PantallasMenu.abrirHistorialVentas(event);
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
    private void abrirTableroDePreguntas(ActionEvent event) {
    }

    @FXML
    private void abrirEditarProducto(ActionEvent event) {
        PantallasMenu.abrirPantalla(event,"PantallaModificarSubasta");
    }

    @FXML
    private void abrirMasInformacion(MouseEvent event) {

    }

    @FXML
    void abrirPausarProducto(ActionEvent event) {
        long idPuja =  autenticacionController.getTemporalVisualizada().getId();
        if(controladorGeneral.pujaController.pausarPuja(idPuja))
            System.out.println("Se pauso la puja con exito");
        else
            System.out.println("No se pauso la puja");
    }

    @FXML
    void abrirReanudarProducto(ActionEvent event) {
        long idPuja =  autenticacionController.getTemporalVisualizada().getId();
        if(controladorGeneral.pujaController.reanudarPuja(idPuja))
            System.out.println("Se reanudo la puja con exito");
        else
            System.out.println("No se reanudo la puja");
    }

    @FXML
    private void abrirEliminarProducto(ActionEvent event) {
        //autenticacionController = AutenticacionController.getInstance();
        long idPujaAEliminar = autenticacionController.getTemporalVisualizada().getId();
        long idProductoAEliminar = autenticacionController.getTemporalVisualizada().getProducto().getId();

        controladorGeneral.productoController.eliminarProducto(idProductoAEliminar);
        controladorGeneral.pujaController.eliminarPuja(idPujaAEliminar);
        //PantallasMenu.abrirPantalla(event,"");
        PantallasMenu.abrirVentana("PantallaConfirmacionEliminarPuja");
    }

}
