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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import pujaQpuja.controller.GeneralController;

/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class IngresarController implements Initializable {

  @FXML
  private TextField campoCorreo;
  @FXML
  private PasswordField campoPassword;
  @FXML
  private Button botonIngresar;

  GeneralController controlador;

  /**
   * Initializes the controller class.
   */
  @Override
  public void initialize(URL url, ResourceBundle rb) {
    controlador = GeneralController.getControllerAplication();
  }

  @FXML
  private void accionIngresar(ActionEvent event) throws IOException {

    String correo = campoCorreo.getText();
    String contra = campoPassword.getText();

    if (correo != null && contra != null) {
      if (controlador.iniciarSesion(correo, contra)) {
        Parent pantallaPrincipalParent = FXMLLoader
            .load(getClass().getResource("/view/" + "PantallaSeleccionarCategoria.fxml"));
        Scene pantallaPrincipalfxml = new Scene(pantallaPrincipalParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(pantallaPrincipalfxml);
        window.show();
      } else {
        Parent pantallaErrorIngresoParent = FXMLLoader.load(getClass().getResource("/view/" + "ErrorAutenticar.fxml"));
        Scene pantallaErrorIngresolfxml = new Scene(pantallaErrorIngresoParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(pantallaErrorIngresolfxml);
        window.show();
      }
    }
  }
}
