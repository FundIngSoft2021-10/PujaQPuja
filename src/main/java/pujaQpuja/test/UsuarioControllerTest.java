package pujaQpuja.test;

import org.junit.Test;
import pujaQpuja.controller.modelos.ControladorGeneral;
import pujaQpuja.model.entities.Usuario;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
public class UsuarioControllerTest {
ControladorGeneral control = new ControladorGeneral();
//prueba no funcional de rendimiento en creacion de usuarios

    @Test
    public void crear() {

        long a=System.currentTimeMillis();
        Usuario usuarionuevo = new Usuario();
        usuarionuevo.setNombres("Guillermo");
        usuarionuevo.setApellidos("Montes");
        usuarionuevo.setPassword("TqQueremos");
        usuarionuevo.setDireccion("Calle 14");
        usuarionuevo.setDocumento("445800");
        usuarionuevo.setTelefono("3784569864");
        usuarionuevo.setCorreo("guille@hotmail.com");
        control.usuarioController.crear(usuarionuevo);
        long b=System.currentTimeMillis();
       long resultado= b-a;
       assertTrue(resultado<5000);

    }
    @Test
    public void crear_() {
//      Prueba no funcional con fallo significa que la creación se pasa del tiempo de 1 segun
        long a=System.currentTimeMillis();
        Usuario usuarionuevo = new Usuario();
        usuarionuevo.setNombres("Guillermo");
        usuarionuevo.setApellidos("Montes");
        usuarionuevo.setPassword("TqQueremos");
        usuarionuevo.setDireccion("Calle 14");
        usuarionuevo.setDocumento("445800");
        usuarionuevo.setTelefono("3784569864");
        usuarionuevo.setCorreo("guille@hotmail.com");
        control.usuarioController.crear(usuarionuevo);
        long b=System.currentTimeMillis();
        long resultado= b-a;
        assertFalse(resultado<1000);
    }


//prueba funcional
            @Test
            public void buscarPorId() {
                long idPrueba=1;
                assertNotNull(control.usuarioController.buscarPorId(idPrueba));
            }


            @Test
            public void obtenerCalificacionV() {
            long idPrueba2 = 2;
            assertNotEquals(-1,control.usuarioController.obtenerCalificacionV(idPrueba2));
            }

            @Test
            public void buscarPorId_() {
                long idPrueba=9000;
                assertNull(control.usuarioController.buscarPorId(idPrueba).getDocumento());
            }


            @Test
            public void obtenerCalificacionV_() {
                long idPrueba2 = -1;
                assertEquals(-1,control.usuarioController.obtenerCalificacionV(idPrueba2));
            }


}






