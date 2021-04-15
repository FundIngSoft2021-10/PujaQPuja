/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import pujaQpuja.controller.SingletonController;
import pujaQpuja.model.EstadoPuja;
import pujaQpuja.model.Puja;
import pujaQpuja.model.TablaCatalogoTemporal;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
 
public class PantallaSeleccionarCategoriaController implements Initializable {


    @FXML
    private TextField campoBuscar;

    @FXML
    private TableView<TablaCatalogoTemporal> tablaCatalogo;

    @FXML
    private TableColumn<TablaCatalogoTemporal, String> columnaDescripcion;

    @FXML
    private TableColumn<TablaCatalogoTemporal, ImageView> columnaImagen;

    @FXML
    private ComboBox<?> desplegableFiltros;

    @FXML
    private Button botonBuscar;

    @FXML
    private ImageView botonPerfil;

    @FXML
    private ImageView botonRegresar;

    @FXML
    private ImageView botonOrdenar;


    SingletonController singleton = SingletonController.getControllerAplication();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println((singleton).getControlador().getAutenticado().getCorreo());

        TableColumn<TablaCatalogoTemporal, String> descripcion = new TableColumn<>("Descripción");
        columnaDescripcion.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal, String>("desc"));
        TableColumn<TablaCatalogoTemporal, ImageView> imagen = new TableColumn<>("Imagen");
        columnaImagen.setCellValueFactory(new PropertyValueFactory<TablaCatalogoTemporal,ImageView >("imagen"));
         ObservableList<TablaCatalogoTemporal> datos = FXCollections.observableArrayList();
         for (Puja actual : singleton.getControlador().getPujasActivas()) {
             if(actual.getEstado()==EstadoPuja.ACTIVO)
             {
                TablaCatalogoTemporal temp = new TablaCatalogoTemporal();
                temp.setImagen(actual.getProducto().getFotos().get(0));
                StringBuilder dtemp = new StringBuilder("Nombre:  "+actual.getProducto().getNombre()+"\n"+ "Descripción:  "+actual.getProducto().getDescripcion()+"\n"+"Precio:  "+"$ "+ actual.getPrecioFinal()+" COP");
                temp.setDesc(dtemp.toString());
                datos.add(temp);
                System.out.println(dtemp);
             }
         }
         tablaCatalogo.setItems(datos);
         System.out.println(datos.size());

    }    

    
    @FXML
    void buscarProducto(ActionEvent event) {
        
      /*  String buscador = campoBuscar.getText();
            if(buscador!= null)
            {
// crear menealerta
            }
              else
                {
                 for (Puja pujaActual : singleton.getControlador().getPujasActivas() )
                   
               }

            }
*/
    }

    @FXML
    void desplegarfiltros(ActionEvent event) {

    }
    
    
}
