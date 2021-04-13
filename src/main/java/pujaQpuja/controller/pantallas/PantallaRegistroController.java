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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import pujaQpuja.model.Usuario;
/**
 * FXML Controller class
 *
 * @author Cristian Da Camara
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
        //Usuario usuario = new Usuario();
    }    
    
    @FXML
    private void registrarse(ActionEvent event) {
        Usuario usuario = new Usuario();
        if(campoPassword.getText().equals(campoConfirmarPassword.getText()) && checkAceptarTerminos.isSelected())
        {
            usuario.setApellidos(campoNombreApellido.getText());
            usuario.setCorreo(campoCorreo.getText());
            usuario.setDireccion(campoDireccion.getText());
            usuario.setTelefono(campoTelefono.getText());
            usuario.setPassword(campoPassword.getText());
            //System.out.println("hola");
        }else
        {
           /* Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
            openScene.start(window);*/
        }
    }

}
