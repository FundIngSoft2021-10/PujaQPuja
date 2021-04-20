package pujaQpuja.controller.pantallas;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;


public class PantallaErrorCalificarController {

    @FXML
    private Text textoCalificar;

    @FXML
    private TextArea campoConfirmacion;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Button botonAceptar;

    @FXML
    void accionAceptar(ActionEvent event) throws IOException {
        Parent pantallaErrorParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaCalificarProducto.fxml"));
        Scene errorRegistroScene = new Scene(pantallaErrorParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(errorRegistroScene);
        window.show();
    }

}
