/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class DetallesVentaController implements Initializable {
    @FXML
    public ImageView botonMenu;
    @FXML
    private TextField campoNombreProducto;
    @FXML
    private TextField campoPrecio;
    @FXML
    private TextField campoNombreComprador;
    @FXML
    private TextField campoMasInformacion;
    @FXML
    private TextField campoDescripcion;
    @FXML
    private Button botonTableroDePreguntas;
    @FXML
    private Button botonEditarProducto;
    @FXML
    private Button botonEliminarProducto;
    @FXML
    private Button botonRegresar;
    @FXML
    private ImageView imagenProducto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void accionAbrirMenu(MouseEvent mouseEvent) {
    }

    @FXML
    public void accionTableroDePreguntas(ActionEvent actionEvent) {
    }

    @FXML
    public void accionEditarProducto(ActionEvent actionEvent) {
    }

    @FXML
    public void accionRegresar(ActionEvent actionEvent) {
    }

    @FXML
    public void accionEliminarProducto(ActionEvent actionEvent) {
    }
}
