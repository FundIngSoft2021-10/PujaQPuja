package pujaQpuja.controller.pantallas;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.Mensaje;
import pujaQpuja.model.entities.otros.TablaMensaje;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PreguntasPujaController implements Initializable {
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
    private TableView<TablaMensaje> tablaPreguntasRespuestas;

    @FXML
    private TableColumn<TablaMensaje, String> columnaPregunta;

    @FXML
    private TableColumn<TablaMensaje, String> columnaRespuesta;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
        columnaPregunta.setCellValueFactory(new PropertyValueFactory<TablaMensaje, String>("pregunta"));
        columnaRespuesta.setCellValueFactory(new PropertyValueFactory<TablaMensaje, String>("respuesta"));
        obtenerQA();

    }

    private void obtenerQA() {
        ObservableList<TablaMensaje> datos = FXCollections.observableArrayList();
        datos.addAll(controladorGeneral.mensajeController.getPreguntas(controladorGeneral.autenticacionController.getTemporalVisualizada().getId()));
        tablaPreguntasRespuestas.setItems(datos);
    }

    @FXML
    void abrirQA(MouseEvent event) {
        PantallasMenu.abrirQA(event);
    }

    @FXML
    private void irAtras(MouseEvent event) {
        PantallasMenu.abrirPantalla(event,"DetallesVenta");

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
    void seleccionar(MouseEvent event) throws IOException {
        if (tablaPreguntasRespuestas.getSelectionModel().getSelectedItem() != null) {
            Mensaje a = tablaPreguntasRespuestas.getSelectionModel().getSelectedItem().getMensaje();
            Mensaje b = controladorGeneral.mensajeController.mensajeVisualizado(a);
            controladorGeneral.autenticacionController.setMensajeVisualizado(b);
            Parent pantallaIngresarParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaRespuesta.fxml"));
            Scene pantallaIngresarScene = new Scene(pantallaIngresarParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(pantallaIngresarScene);
            window.show();
        }

    }

}
