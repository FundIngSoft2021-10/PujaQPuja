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

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class InformacionController implements Initializable {


    @FXML
    private ImageView imagenInformacion;
    @FXML
    private TextField campoTiempoSubasta;
    @FXML
    private TextField campoPrecioActual;
    @FXML
    private TextField campoTiempoRestante;
    @FXML
    private TextField campoTotalPujas;
    @FXML
    private TextField campoPrecioInicial;
    @FXML
    private Button botonRegresar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
