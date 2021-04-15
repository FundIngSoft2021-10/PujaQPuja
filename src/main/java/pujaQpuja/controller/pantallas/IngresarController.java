/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pujaQpuja.controller.pantallas;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;
import pujaQpuja.controller.SingletonController;
/**
 * FXML Controller class
 *
 * @author LomitoFrito
 */
import pujaQpuja.model.Usuario;
public class IngresarController implements Initializable {

    @FXML
    private TextField campoCorreo;
    @FXML
    private PasswordField campoPassword;
    @FXML
    private Button botonIngresar;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
      
      
      
     


      
    }
    List<Usuario> getlistaUsuarios(){
      List<Usuario> users = new ArrayList<Usuario>();
        users.add(new Usuario(Long.valueOf(1243546),"ken","contra","abrahan","ayala","ken","calle 11 sur","3158346574","1587954785",0.0));

      return users;
    }   
      @FXML
    void iniciarSesion(ActionEvent event) throws IOException {

        SingletonController singleton = SingletonController.getControllerAplication();
        
        String correo = campoCorreo.getText();
        String contra = campoPassword.getText();
        //enviar show message dialgo en caso de que esté vacio o no sea un correo en los campos
        
        if(correo!=null&&contra!=null)
        {
          
          List<Usuario> users=getlistaUsuarios();
          Usuario autenticado;
          for (Usuario usarioActual : users) {
             System.out.println(usarioActual.getCorreo());
             System.out.println(usarioActual.getPassword());
              if( usarioActual.getCorreo().equals(correo) &&  usarioActual.getPassword().equals(contra))
              {
                
                 autenticado = usarioActual;
                 if(autenticado != null)
                 {
                   singleton.getControlador().setAutenticado(autenticado);
                 }
                 Parent pantallaPrincipalParent = FXMLLoader.load(getClass().getResource("/view/" +"PantallaSeleccionarCategoria.fxml"));
                 Scene pantallaPrincipalfxml = new Scene(pantallaPrincipalParent);
                 Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                 window.setScene(pantallaPrincipalfxml);
                 window.show();
                 
              }
              else{
                Parent pantallaErrorIngresoParent = FXMLLoader.load(getClass().getResource("/view/" +"ErrorAutenticar.fxml"));
                Scene pantallaErrorIngresolfxml = new Scene(pantallaErrorIngresoParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(pantallaErrorIngresolfxml);
                window.show();
              }
            
          }  
        }
       
        


    }
    
}
