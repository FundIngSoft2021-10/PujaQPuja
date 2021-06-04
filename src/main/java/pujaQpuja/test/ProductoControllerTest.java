package pujaQpuja.test;

import org.junit.Test;
import pujaQpuja.controller.modelos.ControladorGeneral;

import static org.junit.Assert.*;

public class ProductoControllerTest {
    //Prueba Funcional
    ControladorGeneral control = new ControladorGeneral();
    @Test
    public void eliminarProducto() {
        long idProductoPrueba=40;
        //el producto es "logo" producto de prueba para eliminarlo y que elimine sólo si esté no está en una puja activa en este caso no lo elimina porque esta activo
        assertFalse(control.productoController.eliminarProducto(idProductoPrueba));
    }
    
 

}