package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class PantallaPujarXProductoController implements Initializable {

    private ControladorGeneral controladorGeneral;
    private PantallaPujarXProductoConfirmacionController controlador2;

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
    private ImageView imagenProducto;
    @FXML
    private TextField campoDescripcionProducto;
    @FXML
    private TextField campoPrecioSubasta;
    @FXML
    private TextField campoNumeroPujantes;
    @FXML
    private TextField campoDigitePrecio;
    @FXML
    private Button botonPuja;
    @FXML
    private Button botonRealizarPregunta;
    @FXML
    private Text textoNombreProducto;
    @FXML
    private Text calificacion;
    @FXML
    private Rectangle botonRectanguloQA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();

        campoDescripcionProducto.setText(controladorGeneral.autenticacionController.getTemporalVisualizada().getProducto().getDescripcion());
        textoNombreProducto.setText(controladorGeneral.autenticacionController.getTemporalVisualizada().getProducto().getNombre());
        campoPrecioSubasta.setText(Double.toString(controladorGeneral.autenticacionController.getTemporalVisualizada().getPrecioFinal()));
        campoNumeroPujantes.setText(Integer.toString(controladorGeneral.pujaController.obtenerNumeroPujantesPorPujaId(controladorGeneral.autenticacionController.getTemporalVisualizada().getId())));
        imagenProducto.setImage(controladorGeneral.autenticacionController.getTemporalVisualizada().getProducto().getFoto());
        DecimalFormat df = new DecimalFormat("#.00");
        calificacion.setText(df.format(controladorGeneral.usuarioController.obtenerCalificacionV(controladorGeneral.autenticacionController.getTemporalVisualizada().getVendedor().getId())).toString()+"/5");
    }

    @FXML
    void abrirPujar(ActionEvent event) throws IOException {
        String precioOfertado = campoDigitePrecio.getText();
        if (precioOfertado != null) {
            Double precio = 0.0;
            try {
                precio = Double.parseDouble(precioOfertado);
            } catch (Exception e) {
                System.err.println(e);
            }
            if (precio > 0.0) {
                if (precio <= controladorGeneral.autenticacionController.getTemporalVisualizada().getPrecioFinal()) {
                    ButtonType botonsi= new ButtonType("Si");
                   Alert alert = new Alert(Alert.AlertType.ERROR, "Error, por favor digite un precio valido" , botonsi);
                   alert.setHeaderText("Hey cuidado animal");
                 
                        alert.showAndWait();
                        if (alert.getResult() == botonsi) {
                            //do stuff
                        }
                } else {
                   /* FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + "PantallaPujarXProductoConfirmacion.fxml"));
                    fxmlLoader.load();
                    PantallaPujarXProductoConfirmacionController ConfirmacionController = fxmlLoader.getController();
                    ConfirmacionController.setPrecioNuevo(precio);
                    ConfirmacionController.setControlador(this);
                    ConfirmacionController.getTextoPrecio().setText(Double.toString(precio));
                    Parent p = fxmlLoader.getRoot();
                    Stage s = new Stage();
                    s.setScene(new Scene(p));
                    s.show();*/
                    ButtonType botonsi= new ButtonType("Si");
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Estas seguro de pujar: $ " + campoDigitePrecio.getText() + " ?", botonsi, ButtonType.NO);
                        alert.showAndWait();

                        if (alert.getResult() == botonsi) {
                            confirmacion(true,Double.valueOf(campoDigitePrecio.getText()));
                        }else if(alert.getResult() == ButtonType.NO)
                        {
                               //xd
                        }
                }
            }
        }
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
        PantallasMenu.abrirVentana("PantallaSeleccionarCategoria");
        PantallasMenu.cerrarPantalla(event);
    }

    public boolean confirmacion(boolean confirmacion, Double precionuevo) {
        // crear la puja y validad y lo demas

        if (confirmacion == true) {
            controladorGeneral.pujaController.insertarComprador(controladorGeneral.autenticacionController.getTemporalVisualizada().getId(), controladorGeneral.autenticacionController.getAutenticado().getId(), precionuevo);
            campoNumeroPujantes.setText(Integer.toString(Integer.valueOf(campoNumeroPujantes.getText()) + 1));
            controladorGeneral.pujaController.actualizarPrecio(controladorGeneral.autenticacionController.getTemporalVisualizada().getId(), precionuevo);
            campoPrecioSubasta.setText(Double.toString(precionuevo));
            return true;
        } else {
            return false;
        }
    }

    public void setControlador(PantallaPujarXProductoConfirmacionController controlador) {
        this.controlador2 = controlador;
    }

    public Button botonPuja() {
        return this.botonPuja;
    }

}
