package pujaQpuja.controller.pantallas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.Puja;
import pujaQpuja.utilities.PantallasMenu;

import java.net.URL;
import java.util.ResourceBundle;

public class PantallaConfirmacionEliminarPujaController implements Initializable {
    private ControladorGeneral controladorGeneral;

    @FXML
    private Button botonSi;

    @FXML
    private Button botonNo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controladorGeneral = new ControladorGeneral();
    }

    @FXML
    void accionNo(ActionEvent event) {
        PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void accionSi(ActionEvent event) {
        //TODO esperar respuesta Puja de otra pantalla
        Puja pujaEliminar = new Puja();
        controladorGeneral.pujaController.eliminarPuja(pujaEliminar.getId());
        PantallasMenu.cerrarPantalla(event);
    }
}
