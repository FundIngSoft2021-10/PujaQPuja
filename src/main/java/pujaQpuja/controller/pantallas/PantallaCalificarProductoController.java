/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaCalificarProductoController implements Initializable {

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
    private RadioButton botonRadioBuena;
    @FXML
    private RadioButton botonRadioRegular;
    @FXML
    private RadioButton botonRadioMala;
    @FXML
    private Button botonAceptar;
    @FXML
    private TextField campoOpinionProducto;

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
    private void abrirPerfil(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaPerfil.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirAjustes(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaAjustes.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirCategorias(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaSeleccionarCategoria.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirRealizarSubasta(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaRealizarSubasta.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirHistorialVentas(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"HistorialVentas.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirHistorialCompras(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"HistorialCompras.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirNotificaciones(MouseEvent event) {
    }

    @FXML
    private void abririMetodoPago(MouseEvent event) {
    }

    @FXML
    private void accionAceptar(ActionEvent event) {
    }

}
