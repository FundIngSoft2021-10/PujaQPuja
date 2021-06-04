package pujaQpuja.test;

import org.junit.Test;
import pujaQpuja.controller.modelos.ControladorGeneral;

import static org.junit.Assert.*;

public class AutenticacionControllerTest {

    ControladorGeneral control = new ControladorGeneral();
    //Prueba Funcional
    @Test
   public void iniciarSesion() {
            String correo="a@a.com";
            String contra ="a";
            assertTrue(control.autenticacionController.iniciarSesion(correo,contra));
        //devuelve true si deja iniciar sesión
    }
    //Prueba funcional fallo
       @Test
   public void iniciarSesion_() {
            String correo="a@a.com";
            String contra ="contraseñaincorrecta";
            assertFalse(control.autenticacionController.iniciarSesion(correo,contra));
        //devuelve false si impide iniciar sesión
    }
}
