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
import pujaQpuja.controller.modelos.ProductoController;
import pujaQpuja.controller.modelos.PujaController;
import pujaQpuja.model.entities.Categoria;
import pujaQpuja.model.entities.Condicion;
import pujaQpuja.model.entities.Producto;
import pujaQpuja.utilities.PantallasMenu;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PantallaRealizarSubastaController implements Initializable {

    private AutenticacionController autenticacionController;
    private ProductoController productoController;
    private PujaController pujaController;

    private String rutaImagen;

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
    private TextField campoPrecioInicial;
    @FXML
    private ImageView imagenProducto;
    @FXML
    private Button botonAdjuntarFoto;
    @FXML
    private Button botonPublicar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        autenticacionController = AutenticacionController.getControllerAplication();
        productoController = new ProductoController();
        pujaController = new PujaController();

        desplegableCategoria.getItems().setAll(Categoria.values());
        rutaImagen = "";
    }

    @FXML
    private void irAtras(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
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
    private void accionPublicar(ActionEvent event) throws IOException, SQLException {

        Producto productoASubastar = new Producto();

        // FALTA AGREGAR ESE PRODUCTO A LA LISTA DE PUJAS

        productoASubastar.setNombre(campoNombreProducto.getText());
        if (!campoPrecioInicial.getText().isEmpty())
            productoASubastar.setPrecioInicial(Float.parseFloat(campoPrecioInicial.getText()));
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
        productoASubastar.setCondicion(Condicion.USADO);

        if (productoASubastar.getPrecioInicial() >= 0 && !productoASubastar.getNombre().isBlank() && !productoASubastar.getDescripcion().isBlank() && productoASubastar.getCategoria() != null && productoASubastar.getFoto() != null) {

            productoController.crear(productoASubastar, rutaImagen);
            pujaController.crear(productoASubastar);

            PantallasMenu.abrirVentana("PantallaExitoRealizarSubasta");
        } else {
            PantallasMenu.abrirVentana("PantallaErrorPublicacionSubasta");
        }
    }

}
