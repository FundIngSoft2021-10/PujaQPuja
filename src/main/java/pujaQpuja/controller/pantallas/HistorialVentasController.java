package pujaQpuja.controller.pantallas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HistorialVentasController implements Initializable {

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
    private TableView<TablaCatalogoTemporal> tablaHistorialVentas;
    @FXML
    private TableColumn<TablaCatalogoTemporal, ImageView> columnaFotoProducto;
    @FXML
    private TableColumn<TablaCatalogoTemporal, String> columnaDescripcionProducto;
    @FXML
    private TableColumn<TablaCatalogoTemporal, String> columnaEstadoProducto;
    @FXML
    private Rectangle botonRectanguloQA;

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
        datos.addAll(controladorGeneral.pujaController.getPujasPropiasA());
        tablaHistorialVentas.setItems(datos);

        FilteredList<TablaCatalogoTemporal> filteredData = new FilteredList<>(datos, b -> true);

        SortedList<TablaCatalogoTemporal> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablaHistorialVentas.comparatorProperty());
        tablaHistorialVentas.setItems(sortedData);
    }

    @FXML
    private void abrirPerfil(MouseEvent event) {
        PantallasMenu.abrirPerfil(event);
    }

    @FXML
    void abrirQA(MouseEvent event) {
        PantallasMenu.abrirQA(event);
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
    private void irAtras(MouseEvent event) {
    }

    @FXML
    void seleccionar(MouseEvent event) throws IOException {
        if (tablaHistorialVentas.getSelectionModel().getSelectedItem() != null) {
            Puja a = tablaHistorialVentas.getSelectionModel().getSelectedItem().getPuja();
            Puja b = controladorGeneral.pujaController.pujaVisualizada(a);
            controladorGeneral.autenticacionController.setTemporalVisualizada(b);
            Parent pantallaIngresarParent = FXMLLoader.load(getClass().getResource("/view/" + "DetallesVenta.fxml"));
            Scene pantallaIngresarScene = new Scene(pantallaIngresarParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(pantallaIngresarScene);
            window.show();
        }
    }
}
