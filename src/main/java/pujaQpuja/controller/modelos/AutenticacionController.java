package pujaQpuja.controller.modelos;

import pujaQpuja.model.entities.Puja;
import pujaQpuja.model.entities.Usuario;
import pujaQpuja.model.repository.DB;

import java.sql.Connection;

public class AutenticacionController {

    // ----------------------------------------------------------
    // ----------------------- Singleton ------------------------
    // ----------------------------------------------------------

    private static AutenticacionController conexion = null;

    public static AutenticacionController getInstance() {
        if (conexion == null) {
            conexion = new AutenticacionController();
        }
        return conexion;
    }

    // ----------------------------------------------------------
    // ------------------ Variables Globales --------------------
    // ----------------------------------------------------------

    private Usuario autenticado;
    private UsuarioController usuarioController;

    private Puja temporalVisualizada;

    // ----------------------------------------------------------
    // ---------------------- Constructor -----------------------
    // ----------------------------------------------------------

    public AutenticacionController() {
        usuarioController = new UsuarioController();
    }

    // ----------------------------------------------------------
    // ---------------- Autenticacion y Sesión ------------------
    // ----------------------------------------------------------

    public boolean iniciarSesion(String correo, String password) {
        Usuario temp = new Usuario();
        temp.setCorreo(correo);

        if (usuarioController.buscarPorCorreo(temp)) {
            if (temp.getPassword().equals(password)) {
                autenticado = temp;
                System.out.println("ENTRASTE CORRECTAMENTE");
                return true;
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Correo incorrecto");
        }
        return false;
    }

    public Usuario getAutenticado() {
        return this.autenticado;
    }

    public void setAutenticado(Usuario autenticado) {
        this.autenticado = autenticado;
    }

    public Puja getTemporalVisualizada() {
        return this.temporalVisualizada;
    }

    public void setTemporalVisualizada(Puja temporalVisualizada) {
        this.temporalVisualizada = temporalVisualizada;
    }

}
