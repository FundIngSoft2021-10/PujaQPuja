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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PantallaPujarXProductoConfirmacionController implements Initializable {
    private Double precionuevo;
    private PantallaPujarXProductoController controlador1;

    @FXML
    private Button botonSi;

    @FXML
    private Button botonNo;

    @FXML
    private Label textPrecioPujaARealizar;

    public Label getTextoPrecio() {
        return this.textPrecioPujaARealizar;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // textPrecioPujaARealizar.setText(Double.toString(this.precionuevo));
    }

    @FXML
    void accionNo(ActionEvent event) throws IOException {
        cerrar();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + "PantallaPujarXProducto.fxml"));
        fxmlLoader.load();
        PantallaPujarXProductoController ConfirmacionController = fxmlLoader.getController();

        if (ConfirmacionController.confirmacion(false, this.precionuevo)) {
            //showalert messaje puja realizada con exito
        }
        Parent p = fxmlLoader.getRoot();
        Stage s = new Stage();
        s.setScene(new Scene(p));
        s.show();
        Stage escena = (Stage) this.botonSi.getScene().getWindow();
        escena.close();
    }

    @FXML
    void accionSi(ActionEvent event) throws IOException {
        cerrar();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/" + "PantallaPujarXProducto.fxml"));
        fxmlLoader.load();
        PantallaPujarXProductoController ConfirmacionController = fxmlLoader.getController();

        if (ConfirmacionController.confirmacion(true, this.precionuevo)) {
            //showalert messaje puja realizada con exito
        }
        Parent p = fxmlLoader.getRoot();
        Stage s = new Stage();
        s.setScene(new Scene(p));
        s.show();
        Stage escena = (Stage) this.botonSi.getScene().getWindow();
        escena.close();
    }

    public void SetPrecioNuevo(Double precio) {
        this.precionuevo = precio;
    }

    public void setControlador(PantallaPujarXProductoController controlador) {
        this.controlador1 = controlador;
    }

    public void cerrar() {
        Stage stage = (Stage) this.controlador1.botonPuja().getScene().getWindow();
        stage.close();
    }
}
