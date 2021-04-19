package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pujaQpuja.controller.GeneralController;
import pujaQpuja.controller.modelos.PujaController;
import pujaQpuja.utilities.PantallasMenu;

public class PantallaPujarXProductoController implements Initializable {

    GeneralController generalController = GeneralController.getControllerAplication();
   //PujaController pujaController =

    private PantallaPujarXProductoConfirmacionController controlador2 ;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        generalController = GeneralController.getControllerAplication();

        //System.out.println(pujaController.getTemporalVisualizada().getProducto().getDescripcion());

        campoDescripcionProducto.setText(generalController.getTemporalVisualizada().getProducto().getDescripcion());
        //campoDescripcionProducto.setText(pujaController.getTemporalVisualizada().getProducto().getDescripcion());
        textoNombreProducto.setText(generalController.getTemporalVisualizada().getProducto().getNombre());
        //textoNombreProducto.setText(pujaController.getTemporalVisualizada().getProducto().getNombre());
        campoPrecioSubasta.setText(Double.toString(generalController.getTemporalVisualizada().getPrecioFinal()));
        //campoPrecioSubasta.setText(Double.toString(pujaController.getTemporalVisualizada().getPrecioFinal()));
        // campoNumeroPujantes.setText(Double.toString(singleton.getTemporalVisualizada().getListaCompradores().size()));
        imagenProducto.setImage(generalController.getTemporalVisualizada().getProducto().getFoto());
       // imagenProducto.setImage(pujaController.getTemporalVisualizada().getProducto().getFoto());
    }

    @FXML
    void AbrirPujar(ActionEvent event) throws IOException {
        String precioOfertado = campoDigitePrecio.getText();
        if (precioOfertado != null) {
            Double precio = 0.0;
            try {
                precio = Double.parseDouble(precioOfertado);
            } catch (Exception e) {
                // TODO: handle exception
                // mostrar show alert dialog, campo incorrecto
            }
            if (precio > 0.0) {
                if (precio <= generalController.getTemporalVisualizada().getPrecioFinal()) {


                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + "PantallaPujarXProductoError.fxml"));
                            fxmlLoader.load();
                           Parent p = fxmlLoader.getRoot();
                            Stage s = new Stage();
                            s.setScene(new Scene(p));
                            s.show(); 
                } else {
                    // mostrar pantalla confirmacion- en caso de que no servir, hacer alert show
                    // dialogs
                    
                  //  Parent pantallaIngresarParent2 = FXMLLoader
                   //         .load(getClass().getResource("/view/" + "PantallaPujarXProductoConfirmacion.fxml"));
                  //  Scene pantallaIngresarScene2 = new Scene(pantallaIngresarParent2);
                 //   Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                //   window2.setScene(pantallaIngresarScene2);
                  //  window2.show();
                  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + "PantallaPujarXProductoConfirmacion.fxml"));
                  fxmlLoader.load();
                  PantallaPujarXProductoConfirmacionController ConfirmacionController = fxmlLoader.getController();
                  ConfirmacionController.SetPrecioNuevo(precio);
                  ConfirmacionController.setControlador(this);
                  ConfirmacionController.getTextoPrecio().setText(Double.toString( precio));
                  Parent p = fxmlLoader.getRoot();
                  Stage s = new Stage();
                  s.setScene(new Scene(p));
                  s.show(); 
                  

                }
            }
        }
    }

    @FXML
    void AbrirRealizarPregunta(ActionEvent event) {

    }

    @FXML
    void abrirAjustes(MouseEvent event) {
        PantallasMenu.abrirAjustes(event);
    }

    @FXML
    void abrirCategorias(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
    }

    @FXML
    void abrirHistorialCompras(MouseEvent event) {
        PantallasMenu.abrirHistorialCompras(event);
    }

    @FXML
    void abrirHistorialVentas(MouseEvent event) {
        PantallasMenu.abrirHistorialVentas(event);
    }

    @FXML
    void abrirNotificaciones(MouseEvent event) {
        PantallasMenu.abrirNotificaciones(event);
    }

    @FXML
    void abrirPerfil(MouseEvent event) {
        PantallasMenu.abrirPerfil(event);
    }

    @FXML
    void abrirRealizarSubasta(MouseEvent event) {
        PantallasMenu.abrirRealizarSubasta(event);
    }

    @FXML
    void abririMetodoPago(MouseEvent event) {

    }

    @FXML
    void accionBuscar(MouseEvent event) {

    }

    @FXML
    void irAtras(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaSeleccionarCategoria.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    public boolean confirmacion(boolean confirmacion,Double precionuevo)
    {
        //crear la puja y validad y lo demas
        
       if(confirmacion==true) {
        //generalController.getTemporalVisualizada().setPrecioFinal(precionuevo);
       generalController.getTemporalVisualizada().setPrecioFinal(precionuevo);
        campoPrecioSubasta.setText(Double.toString(generalController.getTemporalVisualizada().getPrecioFinal()));
        return true;
       }
       else{
        return false;
       }
    }
    public void setControlador(PantallaPujarXProductoConfirmacionController controlador)
    {
        this.controlador2 = controlador; 
    }
   public  Button botonPuja ()
   {
       return this.botonPuja;
   }
  
}
