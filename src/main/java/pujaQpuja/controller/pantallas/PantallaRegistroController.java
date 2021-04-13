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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaRegistroController implements Initializable {


    @FXML
    private TextField campoNombreApellido;
    @FXML
    private TextField campoCorreo;
    @FXML
    private TextField campoDireccion;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoPassword;
    @FXML
    private TextField campoConfirmarPassword;
    @FXML
    private CheckBox checkAceptarTerminos;
    @FXML
    private Button botonRegistrarse;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void registrarse(ActionEvent event) {
    }

}
