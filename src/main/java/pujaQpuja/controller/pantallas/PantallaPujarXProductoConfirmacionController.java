package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pujaQpuja.utilities.PantallasMenu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaPujarXProductoConfirmacionController implements Initializable {

    private Double precionuevo;
    private PantallaPujarXProductoController controlador1;

    @FXML
    private Button botonSi;
    @FXML
    private Button botonNo;
    @FXML
    private Label textPrecioPujaARealizar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // textPrecioPujaARealizar.setText(Double.toString(this.precionuevo));
    }

    @FXML
    void accionNo(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);

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

        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void accionSi(ActionEvent event) throws IOException {
        PantallasMenu.cerrarPantalla(event);

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

        PantallasMenu.cerrarPantalla(event);
    }

    public Label getTextoPrecio() {
        return this.textPrecioPujaARealizar;
    }

    public void setPrecioNuevo(Double precio) {
        this.precionuevo = precio;
    }

    public void setControlador(PantallaPujarXProductoController controlador) {
        this.controlador1 = controlador;
    }

}
