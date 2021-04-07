package pujaQpuja;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class InicioController implements Initializable {

    @FXML
    private TextField nombreProducto;
    @FXML
    private TextField precio;
    @FXML
    private TextField nombreComprador;
    @FXML
    private TextField masInformacion;
    @FXML
    private TextField descripcion;
    @FXML
    private BottomNavigationButton botonTableroPreguntas;
    @FXML
    private BottomNavigationButton botonEditarProducto;
    @FXML
    private BottomNavigationButton botonEliminarProducto;
    @FXML
    private BottomNavigationButton botonRegreso;



    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub

    }
}
