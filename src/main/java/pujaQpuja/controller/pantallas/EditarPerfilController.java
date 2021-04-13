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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import pujaQpuja.Utiles;
import pujaQpuja.model.Usuario;
/**
 * FXML Controller class
 *
 * @author Cristian Da Camara
 */
public class EditarPerfilController implements Initializable {


    @FXML
    private PasswordField campoPassword;
    @FXML
    private TextField campoCorreo;
    @FXML
    private TextField campoTelefono;
    @FXML
    private TextField campoDocumento;
    @FXML
    private TextField campoNombreApellido;
    @FXML
    private TextField campoDireccion;
    @FXML
    private Button botonGuardar;
    @FXML
    private Button botonCancelar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    void cancelar(ActionEvent event) {

    }

    @FXML
    void guardar(ActionEvent event) {
        Usuario usuario = new Usuario();
        if(!campoNombreApellido.getText().isBlank()){
            
        }
        if(!campoCorreo.getText().isBlank() && Utiles.isValid(campoCorreo.getText())){
            
        }
        if(!campoPassword.getText().isBlank()){
            
        }
        if(!campoDocumento.getText().isBlank()){
            
        }
        if(!campoTelefono.getText().isBlank() && Utiles.isNumeric(campoTelefono.getText())){
            
        }
        if(!campoDireccion.getText().isBlank()){
            
        }
    }
    
}
