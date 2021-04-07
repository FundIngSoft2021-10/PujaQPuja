/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.view.inicio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
/*
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.BottomNavigation;
import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
*/
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
