package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaCalificarProductoController implements Initializable {

    private ControladorGeneral controladorGeneral;
    private double calificacion;
    private long id;

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
    private RadioButton botonRadioBuena;
    @FXML
    private RadioButton botonRadioRegular;
    @FXML
    private RadioButton botonRadioMala;
    @FXML
    private Button botonAceptar;
    @FXML
    private TextField campoOpinionProducto;
    @FXML
    private Rectangle botonRectanguloQA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
        id = controladorGeneral.autenticacionController.getTemporalVisualizada().getVendedor().getId();
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
        PantallasMenu.abrirVentana("DetallesCompra");
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    private void accionAceptar(ActionEvent event) throws IOException {
        if (botonRadioBuena.isSelected() || botonRadioRegular.isSelected() || botonRadioMala.isSelected()) {
            if(botonRadioBuena.isSelected()){
                calificacion=5.0;
                boolean a= controladorGeneral.usuarioController.calificarV(calificacion,id);
            } else if(botonRadioRegular.isSelected()){
                calificacion=3.0;
                boolean a=controladorGeneral.usuarioController.calificarV(calificacion,id);
            } else if(botonRadioMala.isSelected()){
                calificacion=1.0;
                boolean a=controladorGeneral.usuarioController.calificarV(calificacion,id);
            }
            ButtonType botonAceptar= new ButtonType("Aceptar");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Recibimos tu calificación. Gracias por ayudarnos a mejorar!" , botonAceptar);
            alert.setHeaderText("Muchas gracias!");
            alert.showAndWait();
            if (alert.getResult() == botonAceptar) {
                PantallasMenu.abrirVentana("HistorialCompras");
                PantallasMenu.cerrarPantalla(event);
            }

        } else {
            ButtonType cancelar= new ButtonType("Cancelar");
            ButtonType volver = new ButtonType("Volver");
            Alert alert = new Alert(Alert.AlertType.ERROR, "No recibimos tu calificación. Por favor selecciona una opción." , cancelar,volver);
            alert.setHeaderText("Hubo un error.");
            alert.showAndWait();
            if (alert.getResult() == volver) {
                PantallasMenu.abrirVentana("PantallaCalificarProducto");
                PantallasMenu.cerrarPantalla(event);
            }
            else if (alert.getResult() == cancelar)
            {
                PantallasMenu.abrirVentana("HistorialCompras");
                PantallasMenu.cerrarPantalla(event);
            }
        }
    }

}
