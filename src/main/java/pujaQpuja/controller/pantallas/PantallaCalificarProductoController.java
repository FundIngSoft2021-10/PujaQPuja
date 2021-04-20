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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import pujaQpuja.controller.GeneralController;
import pujaQpuja.utilities.PantallasMenu;

/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
public class PantallaCalificarProductoController implements Initializable {

    @FXML
    private Rectangle botonAtras;
    @FXML
    private Rectangle botonPerfil;
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
    private RadioButton botonRadioBuena;
    @FXML
    private RadioButton botonRadioRegular;
    @FXML
    private RadioButton botonRadioMala;
    @FXML
    private Button botonAceptar;
    @FXML
    private TextField campoOpinionProducto;

    GeneralController single = GeneralController.getControllerAplication();

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
        PantallasMenu.abrirPerfil(event);
    }

    @FXML
    private void abrirAjustes(MouseEvent event) {
        PantallasMenu.abrirAjustes(event);
    }

    @FXML
    private void abrirCategorias(MouseEvent event) {
        PantallasMenu.abrirCategorias(event);
    }

    @FXML
    private void abrirRealizarSubasta(MouseEvent event) {
        PantallasMenu.abrirRealizarSubasta(event);
    }

    @FXML
    private void abrirHistorialVentas(MouseEvent event) {
        PantallasMenu.abrirHistorialVentas(event);
    }

    @FXML
    private void abrirHistorialCompras(MouseEvent event) {
        PantallasMenu.abrirHistorialCompras(event);
    }

    @FXML
    private void abrirNotificaciones(MouseEvent event) {
        PantallasMenu.abrirNotificaciones(event);
    }

    @FXML
    private void abririMetodoPago(MouseEvent event) {
        PantallasMenu.abririMetodoPago(event);
    }

    @FXML
    private void accionAceptar(ActionEvent event) throws IOException {

        if (botonRadioBuena.isSelected()) {
            System.out.println("Buena");
        } else if (botonRadioRegular.isSelected()) {
            System.out.println("Regular");
        } else if (botonRadioMala.isSelected()) {
            System.out.println("Mala");
        } else {
            Parent pantallaExitoParent = FXMLLoader
                    .load(getClass().getResource("/view/" + "PantallaErrorCalificar.fxml"));
            Scene exitoCalificarScene = new Scene(pantallaExitoParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(exitoCalificarScene);
            window.show();
        }
        if (botonRadioBuena.isSelected() || botonRadioRegular.isSelected() || botonRadioMala.isSelected()) {
            Parent pantallaExitoParent = FXMLLoader
                    .load(getClass().getResource("/view/" + "PantallaExitoCalificar.fxml"));
            Scene exitoCalificarScene = new Scene(pantallaExitoParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(exitoCalificarScene);
            window.show();
        }
    }

}
