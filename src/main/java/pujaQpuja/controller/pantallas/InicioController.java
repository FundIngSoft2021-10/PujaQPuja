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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class InicioController implements Initializable {


    @FXML
    private Button botonRegistrarse;
    @FXML
    private Button botonIngresar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void ingresar(ActionEvent event) throws IOException {
        Parent pantallaIngresoParent = FXMLLoader.load(getClass().getResource("/view/" +"Ingresar.fxml"));
        Scene pantallaIngresofxml = new Scene(pantallaIngresoParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(pantallaIngresofxml);
        window.show();

        
    }

    @FXML
    void registrar(ActionEvent event) throws IOException {
        Parent pantallaRegistroParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaRegistro.fxml"));
        Scene pantallaRegistroScene = new Scene(pantallaRegistroParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(pantallaRegistroScene);
        window.show();

    }
    
}
