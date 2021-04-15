/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class HistorialComprasController implements Initializable {

    @FXML
    private ImageView botonAtras;
    @FXML
    private ImageView botonPerfil;
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
    private TableView<?> tablaHistorialCompras;
    @FXML
    private TableColumn<?, ?> columnaFotoProducto;
    @FXML
    private TableColumn<?, ?> columnaDescripcionProducto;
    @FXML
    private TableColumn<?, ?> columnaEstadoProducto;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void irAtras(MouseEvent event) {
    }

    @FXML
    private void abrirPerfil(MouseEvent event) {
    }

    @FXML
    private void abrirAjustes(MouseEvent event) {
    }

    @FXML
    private void abrirCategorias(MouseEvent event) {
    }

    @FXML
    private void abrirRealizarSubasta(MouseEvent event) {
    }

    @FXML
    private void abrirHistorialVentas(MouseEvent event) {
    }

    @FXML
    private void abrirHistorialCompras(MouseEvent event) {
    }

    @FXML
    private void abrirNotificaciones(MouseEvent event) {
    }

    @FXML
    private void abririMetodoPago(MouseEvent event) {
    }

}
