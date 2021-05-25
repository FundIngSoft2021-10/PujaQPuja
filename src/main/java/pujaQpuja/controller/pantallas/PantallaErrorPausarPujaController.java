package pujaQpuja.controller.pantallas;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import pujaQpuja.utilities.PantallasMenu;

public class PantallaErrorPausarPujaController {
   
    @FXML
    private Text textoPausa;

    @FXML
    private TextArea campoConfirmacion;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Button botonAceptar;

    @FXML
    void accionAceptar(ActionEvent event) throws IOException{
        PantallasMenu.cerrarPantalla(event);
    }

}
