package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import pujaQpuja.controller.modelos.AutenticacionController;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.Producto;
import pujaQpuja.utilities.PantallasMenu;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaModificarSubastaController implements Initializable {

    private ControladorGeneral controladorGeneral;
    private String rutaImagen;
    private AutenticacionController autenticacionController;

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
    private TextField campoNombreProducto;
    @FXML
    private ChoiceBox<Categoria> desplegableCategoria;
    @FXML
    private TextArea campoDescripcionProducto;
    @FXML
    private ImageView imagenProducto;
    @FXML
    private Button botonCancelarSubasta;
    @FXML
    private Button botonModificar;
    @FXML
    private Button botonPausarSubasta;
    @FXML
    private Button botonReanudarPuja;
    @FXML
    private Rectangle botonRectanguloQA;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
        autenticacionController = AutenticacionController.getInstance();
        campoNombreProducto.setText(autenticacionController.getTemporalVisualizada().getProducto().getNombre());
        campoDescripcionProducto.setText(autenticacionController.getTemporalVisualizada().getProducto().getDescripcion());
        imagenProducto.setImage(autenticacionController.getTemporalVisualizada().getProducto().getFoto());
        desplegableCategoria.getItems().setAll(Categoria.values());
        rutaImagen = "";
    }

    @FXML
    void abrirQA(MouseEvent event) {
        PantallasMenu.abrirQA(event);
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
    void irAtras(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
    }

    @FXML
    private void accionAdjuntarFoto(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Buscar Imagen");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"), new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("PNG", "*.png"));
        File imgFile = fileChooser.showOpenDialog((Stage) ((Node) event.getSource()).getScene().getWindow());
        if (imgFile != null) {
            Image image = new Image("file:" + imgFile.getAbsolutePath());
            rutaImagen = imgFile.getAbsolutePath();
            imagenProducto.setImage(image);
        }
    }


    @FXML
    void accionModificarSubasta(ActionEvent event) {

        Producto productoASubastar = new Producto();
        productoASubastar.setNombre(campoNombreProducto.getText());
        productoASubastar.setDescripcion(campoDescripcionProducto.getText());

        Categoria categoria = Categoria.CALZADO;
        if (Categoria.CALZADO == desplegableCategoria.getValue()) {
            categoria = Categoria.CALZADO;
        }
        if (Categoria.DEPORTE == desplegableCategoria.getValue()) {
            categoria = Categoria.DEPORTE;
        }

        if (Categoria.ELECTRODOMESTICOS == desplegableCategoria.getValue()) {
            categoria = Categoria.ELECTRODOMESTICOS;
        }

        if (Categoria.PANTALONES == desplegableCategoria.getValue()) {
            categoria = Categoria.PANTALONES;
        }

        if (Categoria.ROPA == desplegableCategoria.getValue()) {
            categoria = Categoria.ROPA;
        }

        if (Categoria.TECNOLOGIA == desplegableCategoria.getValue()) {
            categoria = Categoria.TECNOLOGIA;
        }
        productoASubastar.setCategoria(categoria);
        productoASubastar.setFoto(imagenProducto.getImage());
        productoASubastar.setId(autenticacionController.getTemporalVisualizada().getProducto().getId());

        if (controladorGeneral.productoController.modificarProducto(productoASubastar,rutaImagen)) {
            PantallasMenu.abrirVentana("PantallaExitoRealizarSubasta");
        } else {
            PantallasMenu.abrirVentana("PantallaErrorPublicacionSubasta");
        }
    }



    @FXML
    void abririMetodoPago(MouseEvent event) {

    }


}
