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

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import pujaQpuja.controller.SingletonController;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaSeleccionarCategoriaController implements Initializable {


    @FXML
    private TextField campoBuscar;
    @FXML
    private TableView<?> tablaCatalogo;
    @FXML
    private TableColumn<?, ?> columnaDescripcion;
    @FXML
    private TableColumn<?, ?> columnaImagen;
    @FXML
    private ComboBox<?> desplegableFiltros;
    @FXML
    private ImageView botonPerfil;
    @FXML
    private ImageView botonRegresar;
    @FXML
    private ImageView botonBuscar;
    @FXML
    private ImageView botonOrdenar;


    SingletonController singleton = SingletonController.getControllerAplication();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println((singleton).getControlador().getAutenticado().getCorreo());

    }    
    
}
