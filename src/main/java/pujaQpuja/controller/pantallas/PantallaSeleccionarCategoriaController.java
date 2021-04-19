/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
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
import pujaQpuja.controller.GeneralController;
import pujaQpuja.controller.modelos.PujaController;
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.EstadoPuja;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.utilities.PantallasMenu;

/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaSeleccionarCategoriaController implements Initializable {

    GeneralController generalController;
    PujaController pujaController ;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       generalController = GeneralController.getControllerAplication();
       pujaController = new PujaController();

        // TODO REPARAR CÓDIGO
        //System.out.println(generalController.getAutenticado().getCorreo());

        desplegableFiltros.getItems().setAll(Categoria.values());
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, String>("desc"));
        columnaImagen.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, ImageView>("imagen"));

        obtenerPujas();
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
    private void accionBuscar(MouseEvent event) {
        System.out.println("metodobuscar");
    }

    @FXML
    private void accionOrdenar(MouseEvent event) {
    }

    private void obtenerPujas() {
        ObservableList<TablaCatalogoTemporal> datos = pujaController.getPujasActivasItems();

        tablaCatalogo.setItems(datos);
        FilteredList<TablaCatalogoTemporal> filteredData = new FilteredList<>(datos, b -> true);
        campoBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(TablaCatalogoTemporal -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (TablaCatalogoTemporal.getDesc().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else
                    return false; // Does not match.
            });
        });
        SortedList<TablaCatalogoTemporal> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablaCatalogo.comparatorProperty());
        tablaCatalogo.setItems(sortedData);
    }


    @FXML
    void filtrarXcategoria(ActionEvent event) {

        ObservableList<TablaCatalogoTemporal> datos = pujaController.getPujasActivaByCategoria(desplegableFiltros.getSelectionModel().getSelectedItem());

        tablaCatalogo.setItems(datos);
        FilteredList<TablaCatalogoTemporal> filteredData = new FilteredList<>(datos, b -> true);
        campoBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(TablaCatalogoTemporal -> {
                        if (newValue == null || newValue.isEmpty()) {
                            return true;
                        }
                        String lowerCaseFilter = newValue.toLowerCase();
                        if (TablaCatalogoTemporal.getDesc().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                            return true; // Filter matches first name.
                        } else
                            return false; // Does not match.
                    }
            );
        });
        SortedList<TablaCatalogoTemporal> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tablaCatalogo.comparatorProperty());
        tablaCatalogo.setItems(sortedData);
        // System.out.println(datos.size());

    }

    @FXML
    void seleccionar(MouseEvent event) throws IOException {
        if(tablaCatalogo.getSelectionModel().getSelectedItem() != null)
        {
            Puja a = tablaCatalogo.getSelectionModel().getSelectedItem().getPuja();
            Puja b = pujaController.pujaVisualizada(a);
            generalController.setTemporalVisualizada(b);
            Parent pantallaIngresarParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaPujarXProducto.fxml"));
            Scene pantallaIngresarScene = new Scene(pantallaIngresarParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(pantallaIngresarScene);
            window.show();
        }

    }

    public String getDesplegable() {

        return this.desplegableFiltros.getSelectionModel().getSelectedItem().toString();
    }
}
