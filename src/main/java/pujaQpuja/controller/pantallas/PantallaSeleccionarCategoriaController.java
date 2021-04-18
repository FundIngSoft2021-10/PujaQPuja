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

        // TODO REPARAR CÓDIGO
        System.out.println(generalController.getAutenticado().getCorreo());

        desplegableFiltros.getItems().setAll(Categoria.values());
        // TableColumn<TablaCatalogoTemporal, String> descripcion = new
        // TableColumn<>("Descripción");
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, String>("desc"));
        // TableColumn<TablaCatalogoTemporal, ImageView> imagen = new
        // TableColumn<>("Imagen");
        columnaImagen.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, ImageView>("imagen"));
        ObservableList<TablaCatalogoTemporal> datos = FXCollections.observableArrayList();
        for (Puja actual : generalController.getPujasActivas()) {
            if (actual.getEstado() == EstadoPuja.ACTIVO) {
                TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
                temp.setPuja(actual);
                temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n"
                        + "Descripción:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ "
                        + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: "
                        + actual.getProducto().getCategoria());
                temp.setDesc(dtemp.toString());
                datos.add(temp);
                // System.out.println(dtemp);
            }
        }
        tablaCatalogo.setItems(datos);
        FilteredList<TablaCatalogoTemporal> filteredData = new FilteredList<>(datos, b -> true);
        campoBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(TablaCatalogoTemporal -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
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

    @FXML
    void filtrarXcategoria(ActionEvent event) {

        ObservableList<TablaCatalogoTemporal> datos = FXCollections.observableArrayList();
        for (Puja actual : generalController.getPujasActivas()) {
            if (actual.getProducto().getCategoria() == desplegableFiltros.getSelectionModel().getSelectedItem()) {
                TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
                temp.setPuja(actual);
                temp.setImagen(new ImageView(actual.getProducto().getFoto()));
                StringBuilder dtemp = new StringBuilder("Nombre:  " + actual.getProducto().getNombre() + "\n"
                        + "Descripción:  " + actual.getProducto().getDescripcion() + "\n" + "Precio:  " + "$ "
                        + actual.getPrecioFinal() + " COP" + "\n" + "Categoria: "
                        + actual.getProducto().getCategoria());
                temp.setDesc(dtemp.toString());
                datos.add(temp);
                // System.out.println(dtemp);
            }
        }
        tablaCatalogo.setItems(datos);
        FilteredList<TablaCatalogoTemporal> filteredData = new FilteredList<>(datos, b -> true);
        campoBusqueda.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(TablaCatalogoTemporal -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();
                ////////////////////////////////////////////////////////////////////////
                ////////////////////////////////////////////////////////////////////////
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

        generalController.setTemporalVisualizada(
                generalController.buscarPuja(tablaCatalogo.getSelectionModel().getSelectedItem().getPuja().getId()));
        Parent pantallaIngresarParent = FXMLLoader
                .load(getClass().getResource("/view/" + "PantallaPujarXProducto.fxml"));
        Scene pantallaIngresarScene = new Scene(pantallaIngresarParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(pantallaIngresarScene);
        window.show();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
/*
 * package pujaQpuja.controller.pantallas;
 * 
 * import java.net.URL; import java.util.ResourceBundle;
 * 
 * import javafx.collections.FXCollections; import
 * javafx.collections.ObservableList; import javafx.event.ActionEvent; import
 * javafx.fxml.FXML; import javafx.fxml.Initializable; import
 * javafx.scene.control.Button; import javafx.scene.control.ComboBox; import
 * javafx.scene.control.TableColumn; import javafx.scene.control.TableView;
 * import javafx.scene.control.TextField; import
 * javafx.scene.control.cell.PropertyValueFactory; import
 * javafx.scene.image.ImageView; import
 * pujaQpuja.controller.SingletonController; import
 * pujaQpuja.model.entities.EstadoPuja; import pujaQpuja.model.entities.Puja;
 * import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
 * 
 * 
 * public class PantallaSeleccionarCategoriaController implements Initializable
 * {
 * 
 * 
 * @FXML private TextField campoBuscar;
 * 
 * @FXML private TableView<TablaCatalogoTemporal> tablaCatalogo;
 * 
 * @FXML private TableColumn<TablaCatalogoTemporal, String> columnaDescripcion;
 * 
 * @FXML private TableColumn<TablaCatalogoTemporal, ImageView> columnaImagen;
 * 
 * @FXML private ComboBox<?> desplegableFiltros;
 * 
 * @FXML private Button botonBuscar;
 * 
 * @FXML private ImageView botonPerfil;
 * 
 * @FXML private ImageView botonRegresar;
 * 
 * @FXML private ImageView botonOrdenar;
 * 
 * 
 * SingletonController singleton =
 * SingletonController.getControllerAplication();
 * 
 * 
 * @Override public void initialize(URL url, ResourceBundle rb) {
 * System.out.println((singleton).getControlador().getAutenticado().getCorreo())
 * ;
 * 
 * TableColumn<TablaCatalogoTemporal, String> descripcion = new
 * TableColumn<>("Descripción"); columnaDescripcion.setCellValueFactory(new
 * PropertyValueFactory<TablaCatalogoTemporal, String>("desc"));
 * TableColumn<TablaCatalogoTemporal, ImageView> imagen = new
 * TableColumn<>("Imagen"); columnaImagen.setCellValueFactory(new
 * PropertyValueFactory<TablaCatalogoTemporal,ImageView >("imagen"));
 * ObservableList<TablaCatalogoTemporal> datos =
 * FXCollections.observableArrayList(); for (Puja actual :
 * singleton.getControlador().getPujasActivas()) {
 * if(actual.getEstado()==EstadoPuja.ACTIVO) { TablaCatalogoTemporal temp = new
 * TablaCatalogoTemporal();
 * temp.setImagen(actual.getProducto().getFotos().get(0)); StringBuilder dtemp =
 * new StringBuilder("Nombre:  "+actual.getProducto().getNombre()+"\n"+
 * "Descripción:  "+actual.getProducto().getDescripcion()+"\n"+"Precio:  "+"$ "+
 * actual.getPrecioFinal()+" COP"); temp.setDesc(dtemp.toString());
 * datos.add(temp); System.out.println(dtemp); } }
 * tablaCatalogo.setItems(datos); System.out.println(datos.size());
 * 
 * }
 * 
 * 
 * @FXML void buscarProducto(ActionEvent event) {
 * 
 * /* String buscador = campoBuscar.getText(); if(buscador!= null) { // crear
 * menealerta } else { for (Puja pujaActual :
 * singleton.getControlador().getPujasActivas() )
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 * @FXML void desplegarfiltros(ActionEvent event) {
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * 
 * else if
 * (TablaCatalogoTemporal.getPuja().getProducto().getCondicion().getNUEVO().
 * toLowerCase().indexOf(lowerCaseFilter) != -1) { return true; // Filter
 * matches last name. } else if
 * (TablaCatalogoTemporal.getPuja().getProducto().getCondicion().getRESTAURADO()
 * .toLowerCase().indexOf(lowerCaseFilter) != -1) { return true; // Filter
 * matches last name. } else if
 * (TablaCatalogoTemporal.getPuja().getProducto().getCondicion().getUSADO().
 * toLowerCase().indexOf(lowerCaseFilter) != -1) { return true; // Filter
 * matches last name. }
 */