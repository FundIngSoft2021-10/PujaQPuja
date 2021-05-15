package pujaQpuja.controller.pantallas;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaChatController implements Initializable {

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
    private TextField campoEscribirMensaje;
    @FXML
    private Text textoTituloTipoChat;
    @FXML
    private TextArea textAreaMensaje;
    @FXML
    private Rectangle botonEnviar;
    @FXML
    private Rectangle botonRectanguloQA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    void abrirQA(MouseEvent event) {
        PantallasMenu.abrirQA(event);
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
    private void accionEnviar(MouseEvent event) {

        textAreaMensaje.appendText(campoEscribirMensaje.getText()+"\n");
        campoEscribirMensaje.clear();
        long idPuja= controladorGeneral.autenticacionController.getTemporalVisualizada().getId();
        long idVendedor=controladorGeneral.autenticacionController.getTemporalVisualizada().getVendedor().getId();
        long idComprador=controladorGeneral.autenticacionController.getAutenticado().getId();
        String mensaje = textAreaMensaje.getText();
        controladorGeneral.mensajeController.crear(idPuja,idVendedor,idComprador,mensaje);
    }
    @FXML
    void enter(KeyEvent event) {
        if(event.getCode().toString().equals("ENTER")){
            textAreaMensaje.appendText(campoEscribirMensaje.getText()+"\n");
            campoEscribirMensaje.clear();
            long idPuja= controladorGeneral.autenticacionController.getTemporalVisualizada().getId();
            long idVendedor=controladorGeneral.autenticacionController.getTemporalVisualizada().getVendedor().getId();
            long idComprador=controladorGeneral.autenticacionController.getAutenticado().getId();
            String mensaje = textAreaMensaje.getText();
            controladorGeneral.mensajeController.crear(idPuja,idVendedor,idComprador,mensaje);
        }

    }
}
