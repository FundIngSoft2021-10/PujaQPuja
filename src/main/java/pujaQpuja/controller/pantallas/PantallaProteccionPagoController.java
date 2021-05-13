package pujaQpuja.controller.pantallas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pujaQpuja.utilities.PantallasMenu;

public class PantallaProteccionPagoController{

    @FXML
    private Button botonSi;

    @FXML
    private Button botonNo;

    @FXML
    void accionNo(ActionEvent event) {
        PantallasMenu.abrirPantalla(event, "PantallaErrorPago");
        //PantallasMenu.cerrarPantalla(event);
    }

    @FXML
    void accionSi(ActionEvent event) {
        PantallasMenu.abrirPantalla(event,"PantallaExitoPago");
        //PantallasMenu.cerrarPantalla(event);
    }

}

