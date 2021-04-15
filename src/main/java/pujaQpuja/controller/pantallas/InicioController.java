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
    private void accionRegistrarse(ActionEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "PantallaRegistro.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

    @FXML
    private void accionIngresar(ActionEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" + "Ingresar.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

}
