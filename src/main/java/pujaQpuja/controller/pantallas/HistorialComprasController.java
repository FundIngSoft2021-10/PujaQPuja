package pujaQpuja.controller.pantallas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.utilities.PantallasMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class HistorialComprasController implements Initializable {

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
    private TableView<TablaCatalogoTemporal> tablaHistorialCompras;
    @FXML
    private TableColumn<TablaCatalogoTemporal, ImageView> columnaFotoProducto;
    @FXML
    private TableColumn<TablaCatalogoTemporal, String> columnaDescripcionProducto;
    @FXML
    private TableColumn<TablaCatalogoTemporal, String> columnaEstadoProducto;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
        columnaDescripcionProducto.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, String>("desc"));
        columnaFotoProducto.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, ImageView>("imagen"));
        columnaEstadoProducto.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal,String>("estado"));
        obtenerPujas();
    }

    private void obtenerPujas() {
        ObservableList<TablaCatalogoTemporal> datos = FXCollections.observableArrayList();
        datos.addAll(controladorGeneral.pujaController.getPujasGanadasA());
        tablaHistorialCompras.setItems(datos);

        FilteredList<TablaCatalogoTemporal> filteredData = new FilteredList<>(datos, b -> true);

        SortedList<TablaCatalogoTemporal> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablaHistorialCompras.comparatorProperty());
        tablaHistorialCompras.setItems(sortedData);
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

}
