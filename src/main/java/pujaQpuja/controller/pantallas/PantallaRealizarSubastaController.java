/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pujaQpuja.model.Categoría;
import pujaQpuja.model.Producto;
import javafx.fxml.FXMLLoader;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaRealizarSubastaController implements Initializable {

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
    private TextField campoNombreProducto;
    @FXML
    private ChoiceBox<?> desplegableCategoria;
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
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaPerfil.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirAjustes(MouseEvent event) {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"¨PantallaAjustes.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirCategorias(MouseEvent event) {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaSeleccionarCategoria.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirRealizarSubasta(MouseEvent event) {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaRealizarSubasta.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirHistorialVentas(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"historialVentas.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void abrirHistorialCompras(MouseEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"historialCompras.fxml"));
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
    private void accionAdjuntarFoto(ActionEvent event) {
    }

    @FXML
    private void accionPublicar(ActionEvent event) {
        //AQUI
        Producto productoASubastar= new Producto();
        productoASubastar.setNombre(campoNombreProducto.getText());
        productoASubastar.setPrecioInicial(Float.parseFloat(campoPrecioInicial.getText()));
        productoASubastar.setDescripcion(campoDescripcionProducto.getText());
        
        List<Categoría> categorias = new ArrayList<Categoría>();
        if(Categoría.CALZADO==desplegableCategoria.getValue()){
            Categoría cat=Categoría.CALZADO;
            categorias.add(cat); 
        }
        if(Categoría.DEPORTE==desplegableCategoria.getValue()){
            Categoría cat=Categoría.CALZADO;
            categorias.add(cat); 
        }
        productoASubastar.setCategorias(categorias);

        List<Image> fotos=new ArrayList<>();

        productoASubastar.setFotos(fotos);
    }
    

}
