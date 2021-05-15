package pujaQpuja.controller.pantallas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.Mensaje;
import pujaQpuja.model.entities.otros.TablaCatalogoTemporal;
import pujaQpuja.utilities.PantallasMenu;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaPreguntasController implements Initializable {

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
    private Rectangle botonRectanguloQA;

    @FXML
    private TableView<Mensaje> tablaPreguntasRespuestas;

    @FXML
    private TableColumn<Mensaje, String> columnaPregunta;

    @FXML
    private TableColumn<Mensaje, String> columnaRespuesta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
        columnaPregunta.setCellValueFactory(new PropertyValueFactory<Mensaje, String>("preg"));
        columnaRespuesta.setCellValueFactory(new PropertyValueFactory<Mensaje, String>("resp"));
        obtenerQA();
    }

    private void obtenerQA() {
        ObservableList<Mensaje> datos = FXCollections.observableArrayList();
        datos.addAll(controladorGeneral.mensajeController.getPreguntasRespuestas());
//        tablaPreguntasRespuestas.setItems(datos);
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
    void abrirQA(MouseEvent event) {
        PantallasMenu.abrirQA(event);
    }

    @FXML
    private void abrirRealizarSubasta(MouseEvent event) {
        PantallasMenu.abrirRealizarSubasta(event);
    }

    @FXML
    private void abririMetodoPago(MouseEvent event) {
        PantallasMenu.abririMetodoPago(event);
    }

    @FXML
    void irAtras(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
    }

    @FXML
    void seleccionar(MouseEvent event) {

    }

}
