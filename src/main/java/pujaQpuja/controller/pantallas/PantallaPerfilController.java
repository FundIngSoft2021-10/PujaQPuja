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
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaPerfilController implements Initializable {


    @FXML
    private Button botonRegresar;
    @FXML
    private ImageView imagenFotoPerfil;
    @FXML
    private Button botonEditarPerfil;
    @FXML
    private Button botonPrivacidadSeguridad;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void regresar(ActionEvent event) {
    }

    @FXML
    private void editarPerfil(ActionEvent event) {
    }

    @FXML
    private void privacidadSeguridad(ActionEvent event) {
    }

}
