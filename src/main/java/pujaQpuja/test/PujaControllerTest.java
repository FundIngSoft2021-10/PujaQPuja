
package pujaQpuja.test;

import org.junit.Test;
import pujaQpuja.controller.modelos.ControladorGeneral;

import static org.junit.Assert.*;

public class PujaControllerTest {
     ControladorGeneral control = new ControladorGeneral();

    @Test
    public void obtenerNumeroPujantesPorPujaId() {
         int pujas=4;

           int npujas= control.pujaController.obtenerNumeroPujantesPorPujaId((long)38);
             //System.out.println(npujas);
             assertEquals(pujas,npujas);
    }
      @org.junit.Test
    public void getNumeroPujantesById_() {
           int pujas=8;
           int npujas= control.pujaController.obtenerNumeroPujantesPorPujaId((long)38);
            // System.out.println(npujas);
             assertNotEquals(pujas,npujas);
    }

    @Test
    public void insertarComprador() {

      //  boolean bandera=false;
      //  boolean respuesta= control.pujaController.insertarComprador((long)0,(long)0,0.0);
        assertFalse(control.pujaController.insertarComprador((long)0,(long)0,0.0));


    }

    @Test
    public void actualizarPrecio() {
         assertTRUE(control.pujaController.actualizarPrecio((long)0,0.0));
    }

    @Test
    public void reanudarPuja() {
         assertTRUE(control.pujaController.reanudarPuja((long)0));
    }

    @Test
    public void pausarPuja() {
         assertTRUE(control.pujaController.pausarPuja((long)0));
    }

    @Test
    public void eliminarPuja() {
         assertFalse(control.pujaController.eliminarPuja((long)0));
    }
}