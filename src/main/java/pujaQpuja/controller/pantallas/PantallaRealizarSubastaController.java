package pujaQpuja.controller.pantallas;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pujaQpuja.controller.modelos.ControladorGeneral;
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

    private ControladorGeneral controladorGeneral;
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
    @FXML
    private Rectangle botonRectanguloQA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();

        desplegableCategoria.getItems().setAll(Categoria.values());
        rutaImagen = "";
    }

    @FXML
    void abrirQA(MouseEvent event) {
        PantallasMenu.abrirQA(event);
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


            controladorGeneral.productoController.crear(productoASubastar, rutaImagen);
            controladorGeneral.pujaController.crear(productoASubastar);
            ButtonType botonsi= new ButtonType("Si");
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Estas seguro de publicar el producto : " + campoNombreProducto.getText() + " ?", botonsi, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == botonsi) {

                ////////////////////////////////////////////////////////////////////////77

                ///////////////////////////////////////////////////////////////////////////
                PantallasMenu.abrirVentana("PantallaSeleccionarCategoria");
                PantallasMenu.cerrarPantalla(event);
            }else if(alert.getResult() == ButtonType.NO)
            {
                PantallasMenu.abrirVentana("PantallaSeleccionarCategoria");
                PantallasMenu.cerrarPantalla(event);
            }

        } else {
                        ButtonType botonvolver= new ButtonType("Volver");
                        ButtonType cancelar= new ButtonType("Cancelar");
                        Alert alert = new Alert(Alert.AlertType.ERROR, " Error en los campos " , botonvolver ,cancelar);
                        alert.setHeaderText("ERROR AL VALIDAR DATOS INGRESADOS");
                        alert.showAndWait();

                        if (alert.getResult() == botonvolver) {

                        }else if(alert.getResult() == cancelar)
                        {
                            PantallasMenu.abrirVentana("PantallaSeleccionarCategoria");
                            PantallasMenu.cerrarPantalla(event);
                        }
        }
    }

}
