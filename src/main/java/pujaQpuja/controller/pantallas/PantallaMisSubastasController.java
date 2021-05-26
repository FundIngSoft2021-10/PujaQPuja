package pujaQpuja.controller.pantallas;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class PantallaMisSubastasController implements Initializable {

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
    private TextField campoBusqueda;
    @FXML
    private Rectangle botonBusqueda;
    @FXML
    private TableView<TablaCatalogoTemporal> tablaCatalogo;
    @FXML
    private TableColumn<TablaCatalogoTemporal, ImageView> columnaImagen;
    @FXML
    private TableColumn<TablaCatalogoTemporal, String> columnaDescripcion;
    @FXML
    private ComboBox<Categoria> desplegableFiltros;
    @FXML
    private Rectangle botonOrdenar;
    @FXML
    private Rectangle botonRectanguloQA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
        desplegableFiltros.getItems().setAll(Categoria.values());
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, String>("desc"));
        columnaImagen.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, ImageView>("imagen"));

        obtenerPujas();
    }

    private void obtenerPujas() {
        ObservableList<TablaCatalogoTemporal> datos = FXCollections.observableArrayList();
        datos.addAll(controladorGeneral.pujaController.getPujasPropiasA());
        tablaCatalogo.setItems(datos);

        FilteredList<TablaCatalogoTemporal> filteredData = new FilteredList<>(datos, b -> true);
        campoBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(TablaCatalogoTemporal -> {
                if (newValue == null || newValue.isEmpty())
                    return true;
                return TablaCatalogoTemporal.getDesc().toLowerCase().indexOf(newValue.toLowerCase()) != -1 ? true : false;
            });
        });
        SortedList<TablaCatalogoTemporal> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablaCatalogo.comparatorProperty());
        tablaCatalogo.setItems(sortedData);
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
    void irAtras(MouseEvent event) throws IOException {
        PantallasMenu.abrirVentana("PantallaSeleccionarCategoria");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    private void accionBuscar(MouseEvent event) {
        System.out.println("metodobuscar");
    }

    @FXML
    private void accionOrdenar(MouseEvent event) {
    }

    @FXML
    void filtrarXcategoria(ActionEvent event) {

        ObservableList<TablaCatalogoTemporal> datos = FXCollections.observableArrayList();
        datos.addAll(controladorGeneral.pujaController.getPujasActivaByCategoria(desplegableFiltros.getSelectionModel().getSelectedItem()));
        tablaCatalogo.setItems(datos);

        FilteredList<TablaCatalogoTemporal> filteredData = new FilteredList<>(datos, b -> true);
        campoBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(TablaCatalogoTemporal -> {
                if (newValue == null || newValue.isEmpty())
                    return true;
                return TablaCatalogoTemporal.getDesc().toLowerCase().indexOf(newValue.toLowerCase()) != -1 ? true : false;
            });
        });
        SortedList<TablaCatalogoTemporal> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablaCatalogo.comparatorProperty());
        tablaCatalogo.setItems(sortedData);
    }

    @FXML
    void seleccionar(MouseEvent event) throws IOException {
        if (tablaCatalogo.getSelectionModel().getSelectedItem() != null) {
            Puja a = tablaCatalogo.getSelectionModel().getSelectedItem().getPuja();
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









